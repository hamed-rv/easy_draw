package com.hamedrahimvand.easy_draw.extensions

import android.content.Context
import android.util.TypedValue

/**
 *
 *@author Hamed.Rahimvand
 *@since 2019-12-08
 */
fun dpToPx(context: Context, dp: Float) =
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.resources.displayMetrics
    )