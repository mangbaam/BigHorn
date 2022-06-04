package mangbaam.practice.parkingfree.util.extension

import kotlin.String

object String {
    fun String?.isJsonObject(): Boolean = this?.startsWith("{") == true && this.endsWith("}")
    fun String?.isJsonArray(): Boolean = this?.startsWith("[") == true && this.endsWith("]")
}