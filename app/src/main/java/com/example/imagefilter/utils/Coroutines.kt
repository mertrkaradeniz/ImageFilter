package com.example.imagefilter.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coroutines {
    fun io(work: suspend (() -> Unit)) =
        CoroutineScope(Dispatchers.IO).launch { work() }
}