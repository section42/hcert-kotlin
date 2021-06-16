package ehn.techiop.hcert.kotlin.chain

import ehn.techiop.hcert.kotlin.chain.impl.*
import kotlinx.datetime.Clock
import kotlin.js.JsName


object DefaultChain {
    @JsName("buildCreationChain")
    fun buildCreationChain(cryptoService: CryptoService) = Chain(
        DefaultCborService(),
        DefaultCwtService(),
        DefaultCoseService(cryptoService),
        DefaultContextIdentifierService(),
        DefaultCompressorService(),
        DefaultBase45Service(),
        DefaultSchemaValidationService(), DefaultHigherOrderValidationService()
    )

    /**
     * Builds a "default" chain for verifying, i.e. one with the implementation according to spec.
     */
    @JsName("buildVerificationChain")
    fun buildVerificationChain(repository: CertificateRepository, clock: Clock = Clock.System) = Chain(
        DefaultCborService(),
        DefaultCwtService(clock = clock),
        VerificationCoseService(repository),
        DefaultContextIdentifierService(),
        DefaultCompressorService(),
        DefaultBase45Service(),
        DefaultSchemaValidationService(),
        DefaultHigherOrderValidationService()
    )
}