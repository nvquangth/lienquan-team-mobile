package com.hackathon.lienquan.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hackathon.lienquan.R

object DialogUtils {

    fun createLoadingDialog(
        context: Context?, cancelable: Boolean = false,
        canceledOnTouchOutside: Boolean = false
    ): AlertDialog? {
        if (context == null) return null
        return MaterialAlertDialogBuilder(context)
            .setView(R.layout.layout_loading_dialog)
            .create().apply {
                setCancelable(cancelable)
                setCanceledOnTouchOutside(canceledOnTouchOutside)
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
    }

    fun showLoadingDialog(
        context: Context?, cancelable: Boolean = false,
        canceledOnTouchOutside: Boolean = false
    ): AlertDialog? {
        if (context == null) return null
        val dialog: AlertDialog? = createLoadingDialog(context, cancelable)
        dialog?.show()
        return dialog
    }

    fun showMessage(
        context: Context?, title: String? = null, message: String? = null,
        textPositive: String? = null, positiveListener: (() -> Unit)? = null,
        textNegative: String? = null, negativeListener: (() -> Unit)? = null,
        cancelable: Boolean = false, canceledOnTouchOutside: Boolean = false
    ): AlertDialog? {
        if (context == null) return null
        return MaterialAlertDialogBuilder(context).apply {
            setTitle(title)
            setMessage(message)
            setPositiveButton(textPositive) { _, _ ->
                positiveListener?.invoke()
            }
            setNegativeButton(textNegative) { _, _ ->
                negativeListener?.invoke()
            }
            setCancelable(cancelable)
        }.create().apply {
            setCanceledOnTouchOutside(canceledOnTouchOutside)
            show()
        }
    }

    fun showMessage(
        context: Context?, title: Int? = null, message: Int? = null,
        textPositive: Int? = null, positiveListener: (() -> Unit)? = null,
        textNegative: Int? = null, negativeListener: (() -> Unit)? = null,
        cancelable: Boolean = false, canceledOnTouchOutside: Boolean = false
    ): AlertDialog? {
        if (context == null) return null
        return MaterialAlertDialogBuilder(context).apply {
            if (title != null) setTitle(title)
            if (message != null) setMessage(message)
            if (textPositive != null) {
                setPositiveButton(textPositive) { _, _ ->
                    positiveListener?.invoke()
                }
            }
            if (textNegative != null) {
                setNegativeButton(textNegative) { _, _ ->
                    negativeListener?.invoke()
                }
            }
            setCancelable(cancelable)
        }.create().apply {
            setCanceledOnTouchOutside(canceledOnTouchOutside)
            show()
        }
    }
}