package behavioural

interface HandlerChain {
    fun addHeader(inputHeader: String): String
}

class AuthenticationHeader(private val token: String, private val next: HandlerChain? = null) : HandlerChain {
    override fun addHeader(inputHeader: String): String =
        "$inputHeader\nAuthentication: $token"
            .let {
                next?.addHeader(it) ?: it
            }

}

class ContentTypeHeader(private val contentType: String, private val next: HandlerChain? = null) : HandlerChain {
    override fun addHeader(inputHeader: String): String =
        "$inputHeader\nContentType: $contentType"
            .let {
                next?.addHeader(it) ?: it
            }
}

class BodyPayloadHeader(private val body: String, private val next: HandlerChain? = null) : HandlerChain {
    override fun addHeader(inputHeader: String): String =
        "$inputHeader\n$body"
            .let {
                next?.addHeader(it) ?: it
            }
}