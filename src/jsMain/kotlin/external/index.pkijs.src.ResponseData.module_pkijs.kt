@file:JsModule("pkijs/src/ResponseData")
@file:JsNonModule
@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")
package pkijs.src.ResponseData

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import pkijs.src.Extension.Extension
import pkijs.src.SingleResponse.SingleResponse

@JsName("default")
external open class ResponseData(params: Any = definedExternally) {
    open var tds: ArrayBuffer
    open var responderID: Any
    open var producedAt: Date
    open var responses: Array<SingleResponse>
    open var responseExtensions: Array<Extension>
    open fun toSchema(encodeFlag: Boolean = definedExternally): Any
    open fun fromSchema(schema: Any)
    open fun toJSON(): Any

    companion object {
        fun compareWithDefault(memberName: String, memberValue: Any): Boolean
        fun defaultValues(memberName: String): Any
        fun schema(parameters: Any = definedExternally): Any
    }
}