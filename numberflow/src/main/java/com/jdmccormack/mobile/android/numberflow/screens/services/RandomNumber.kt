package com.jdmccormack.mobile.android.numberflow.screens.services

import com.jdmccormack.mobile.android.commonui.StringResource

//{
//    "type": "uint8",
//    "length": 1,
//    "data": [
//    123
//    ],
//    "success": true
//}
data class RandomNumber(
    val type: String,
    val length: Number,
    val data: Array<Number>,
    val success: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RandomNumber

        if (type != other.type) return false
        if (length != other.length) return false
        if (!data.contentEquals(other.data)) return false
        if (success != other.success) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + length.hashCode()
        result = 31 * result + data.contentHashCode()
        result = 31 * result + success.hashCode()
        return result
    }
}
