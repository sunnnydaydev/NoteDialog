package com.sunnyday.notedialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.UiContext

/**
 * Create by SunnyDay /04/23 18:06:24
 */
class BottomDialog @JvmOverloads constructor(
    @UiContext mContext: Context,
    dialogStyle: Int = R.style.BottomDialog,
    @LayoutRes layoutId: Int
) : Dialog(mContext, dialogStyle) {
    init {
        setContentView(layoutId)
        makeDialogBottom()
    }

    private fun makeDialogBottom() {
        window?.apply {
            setGravity(Gravity.BOTTOM)
            attributes.apply {
                width = ViewGroup.LayoutParams.MATCH_PARENT
                height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
        }
    }

    fun <T : View> getViewById(resId: Int): T {
        return findViewById<View>(resId) as T
    }

    companion object{
        const val BG_DEFAULT = R.drawable.shape_bg_bottom_dialog
    }
}