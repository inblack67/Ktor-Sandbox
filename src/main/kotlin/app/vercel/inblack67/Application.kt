package app.vercel.inblack67

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import app.vercel.inblack67.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        configureHTTP()
    }.start(wait = true)
}
