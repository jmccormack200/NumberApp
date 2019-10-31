package com.jdmccormack.mobile.android.numberflow.services.models

data class NumberFact(
    val text: String,
    val number: Number,
    val found: Boolean,
    val type: String
)
