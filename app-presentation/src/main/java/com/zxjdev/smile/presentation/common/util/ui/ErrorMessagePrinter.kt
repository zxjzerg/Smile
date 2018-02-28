package com.zxjdev.smile.presentation.common.util.ui

import android.content.Context
import android.widget.Toast

/**
 * Shows error messages to user
 */
class ErrorMessagePrinter(private val context: Context) {

    fun print(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
