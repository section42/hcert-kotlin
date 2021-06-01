package ehn.techiop.hcert.kotlin.chain.impl

import ehn.techiop.hcert.kotlin.chain.CompressorService
import ehn.techiop.hcert.kotlin.chain.VerificationResult

/**
 * Compresses/decompresses input with ZLIB, [level] specifies the compression level (0-9)
 */
open class DefaultCompressorService(private val level: Int = 9) : CompressorService {

    private val adapter = CompressorAdapter()

    /**
     * Compresses input with ZLIB = deflating
     */
    override fun encode(input: ByteArray): ByteArray {
        return adapter.encode(input, level)
    }

    /**
     * Decompresses input with ZLIB = inflating.
     */
    override fun decode(input: ByteArray, verificationResult: VerificationResult): ByteArray {
        verificationResult.zlibDecoded = false
        return adapter.decode(input).also {
            verificationResult.zlibDecoded = true
        }
    }

}