package com.jdmccormack.mobile.android.numberflow.services.models

data class NumberFactRaw(
    val text: String,
    val number: Number,
    val found: Boolean,
    val type: String
)

fun NumberFactRaw.toNumberFact(): NumberFact {
    return NumberFact(this.number.toInt(), this.text)
}
