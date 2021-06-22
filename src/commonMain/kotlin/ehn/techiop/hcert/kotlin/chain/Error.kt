package ehn.techiop.hcert.kotlin.chain

/**
 * From Swift ValidationCore
 */
enum class Error {
    GENERAL_ERROR,
    INVALID_SCHEME_PREFIX,
    DECOMPRESSION_FAILED,
    BASE_45_DECODING_FAILED,
    COSE_DESERIALIZATION_FAILED,
    CBOR_DESERIALIZATION_FAILED,
    SCHEMA_VALIDATION_FAILED, // not on iOS
    CWT_EXPIRED,
    QR_CODE_ERROR,
    CERTIFICATE_QUERY_FAILED,
    USER_CANCELLED,
    TRUST_SERVICE_ERROR,
    KEY_NOT_IN_TRUST_LIST,
    PUBLIC_KEY_EXPIRED,
    UNSUITABLE_PUBLIC_KEY_TYPE,
    KEY_CREATION_ERROR,
    KEYSTORE_ERROR,
    SIGNATURE_INVALID,
}