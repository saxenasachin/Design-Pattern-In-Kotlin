package behavioural

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ChainOfResponsibilityTest {

    @Test
    fun testChainOfResponsibility() {
        val bodyPayloadHeader = BodyPayloadHeader("Body: {\"username\" + \"sachin\"}")
        val contentTypeHeader = ContentTypeHeader("json", bodyPayloadHeader)
        val authenticationHeader = AuthenticationHeader("123456", contentTypeHeader)

        val messageWithAuthentication = authenticationHeader.addHeader("Headers with authentication")
        println(messageWithAuthentication)

        println("------------------------------")

        val messageWithoutAuthentication = contentTypeHeader.addHeader("Headers without authentication")
        println(messageWithoutAuthentication)

        assertEquals(
            messageWithAuthentication,
            """
                    Headers with authentication
                    Authentication: 123456
                    ContentType: json
                    Body: {"username" + "sachin"}
                """.trimIndent()
        )

        assertEquals(
            messageWithoutAuthentication,
            """
                    Headers without authentication
                    ContentType: json
                    Body: {"username" + "sachin"}
                """.trimIndent()
        )
    }
}