import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import redis.clients.jedis.Jedis
import java.time.Instant

suspend fun playWithRedis() = coroutineScope {
    val redis = Jedis("localhost", 6379)
    redis.set("hello", "worlds")
    redis.expireAt("hello", Instant.now().plusSeconds(1).epochSecond)
    delay(200)
    val res = redis.get("hello")
    println("res => $res")
}

fun main() = runBlocking {
   playWithRedis()
}