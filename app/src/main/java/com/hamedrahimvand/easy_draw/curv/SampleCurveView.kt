package com.hamedrahimvand.easy_draw.curv

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.hamedrahimvand.easy_draw.R
import com.hamedrahimvand.easy_draw.extensions.dpToPx
import com.hamedrahimvand.easy_draw.utils.CustomViewHelperInterface


/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-23
 */
class SampleCurveView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
        FrameLayout(context, attrs, defStyleAttr), CustomViewHelperInterface {

    override fun artboardWidth(): Float = 414f

    override fun artboardHeight(): Float = 896f

    override fun targetWidth(): Float = measuredWidth.toFloat()

    override fun targetHeight(): Float = measuredHeight.toFloat()

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null, 0)

    private var path = Path()
    private val curvePaint = Paint()
    private val footerDashesPaint = Paint()
    private val upperDashesPaint = Paint()


    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawFooterGradientCurve(canvas)
        drawFooterDashesCurve(canvas)
        drawUpperDashesCurve(canvas)
        drawCircle(dpToPx(context, 10f), canvas)
        drawCircleWithDashPathEffect(
                dpToPx(context, 10f),
                canvas,
                floatArrayOf(dpToPx(context, 2f), dpToPx(context, 2f))
        )
        drawMultiplicationSign(canvas)
    }

    //Draw multiplication sign drawable
    private fun drawMultiplicationSign(canvas: Canvas?) {
        if (canvas == null) return
        val multiplicationSignDrawable = ContextCompat.getDrawable(context, R.drawable.ic_close)
        val startWidth = (343f.toResponsiveWidth() - (multiplicationSignDrawable?.intrinsicWidth ?: 0)).toInt()
        val startHeight = (234f.toResponsiveHeight() - (multiplicationSignDrawable?.intrinsicHeight ?: 0)).toInt()
        multiplicationSignDrawable?.setBounds(
                startWidth,
                startHeight,
                startWidth + multiplicationSignDrawable.intrinsicWidth,
                startHeight + multiplicationSignDrawable.intrinsicHeight
        )
        multiplicationSignDrawable?.draw(canvas)
    }

    private fun drawFooterGradientCurve(canvas: Canvas?) {
        curvePaint.strokeWidth = dpToPx(context, 1f)
        curvePaint.style = Paint.Style.FILL
        curvePaint.isAntiAlias = true
        curvePaint.shader = LinearGradient(
                0f,
                0f,
                0f,
                measuredHeight.toFloat(),
                ContextCompat.getColor(context, R.color.colorPurple3),
                ContextCompat.getColor(context, R.color.colorAccent),
                Shader.TileMode.MIRROR
        )
        path.reset()
        path.moveTo((-11.67f).toResponsiveWidth(), 435.17f.toResponsiveHeight())
        path.cubicTo(
                74.65f.toResponsiveWidth(),
                503.75f.toResponsiveHeight(),
                123.82f.toResponsiveWidth(),
                591.27f.toResponsiveHeight(),
                191.91f.toResponsiveWidth(),
                610.8f.toResponsiveHeight()
        )
        path.cubicTo(
                260f.toResponsiveWidth(),
                630.34f.toResponsiveHeight(),
                265.96f.toResponsiveWidth(),
                508.37f.toResponsiveHeight(),
                339.5f.toResponsiveWidth(),
                541.5f.toResponsiveHeight()
        )
        path.cubicTo(
                413.04f.toResponsiveWidth(),
                574.63f.toResponsiveHeight(),
                441.48f.toResponsiveWidth(),
                661.16f.toResponsiveHeight(),
                441.48f.toResponsiveWidth(),
                661.16f.toResponsiveHeight()
        )
        path.lineTo(measuredWidth.toFloat(), measuredHeight.toFloat())
        path.lineTo(0f, measuredHeight.toFloat())
        canvas?.drawPath(path, curvePaint)
    }

    private fun drawFooterDashesCurve(canvas: Canvas?) {
        footerDashesPaint.strokeWidth = dpToPx(context, 1f)
        footerDashesPaint.style = Paint.Style.STROKE
        footerDashesPaint.pathEffect =
                DashPathEffect(floatArrayOf(dpToPx(context, 1f), dpToPx(context, 7f)), 0f)
        footerDashesPaint.color = ContextCompat.getColor(context, R.color.colorWhite)
        footerDashesPaint.isAntiAlias = true
        path.reset()
        path.moveTo((-95.03).toResponsiveWidth(), 477.32.toResponsiveHeight())
        path.cubicTo(
                (-60.33).toResponsiveWidth(),
                450.15.toResponsiveHeight(),
                (-6.67).toResponsiveWidth(),
                450.17f.toResponsiveHeight(),
                28.01f.toResponsiveWidth(),
                477.71f.toResponsiveHeight()
        )
        path.cubicTo(
                79.65.toResponsiveWidth(),
                518.73f.toResponsiveHeight(),
                103.82f.toResponsiveWidth(),
                562.77f.toResponsiveHeight(),
                171.91f.toResponsiveWidth(),
                582.03f.toResponsiveHeight()
        )
        path.cubicTo(
                240.0.toResponsiveWidth(),
                601.84.toResponsiveHeight(),
                328.46f.toResponsiveWidth(),
                516.37f.toResponsiveHeight(),
                402f.toResponsiveWidth(),
                549.05f.toResponsiveHeight()
        )
        path.cubicTo(
                475.54.toResponsiveWidth(),
                582.63.toResponsiveHeight(),
                446.48f.toResponsiveWidth(),
                676.16f.toResponsiveHeight(),
                446.48f.toResponsiveWidth(),
                676.16f.toResponsiveHeight()
        )
        canvas?.drawPath(path, footerDashesPaint)
    }

    private fun drawUpperDashesCurve(canvas: Canvas?) {
        upperDashesPaint.strokeWidth = dpToPx(context, 3f)
        upperDashesPaint.style = Paint.Style.STROKE
        upperDashesPaint.pathEffect =
                DashPathEffect(floatArrayOf(dpToPx(context, 3f), dpToPx(context, 5f)), 0f)
        upperDashesPaint.color = Color.parseColor("#5744B5")
        upperDashesPaint.isAntiAlias = true
        path.reset()
        path.moveTo(29.toResponsiveWidth(), (-72).toResponsiveHeight())
        path.cubicTo(
                (109.63).toResponsiveWidth(),
                (-72).toResponsiveHeight(),
                175.toResponsiveWidth(),
                (-6.63).toResponsiveHeight(),
                175.toResponsiveWidth(),
                74.toResponsiveHeight()
        )
        path.cubicTo(
                175.toResponsiveWidth(),
                154.63.toResponsiveHeight(),
                123.63.toResponsiveWidth(),
                262.5.toResponsiveHeight(),
                43.toResponsiveWidth(),
                262.5.toResponsiveHeight()
        )
        path.cubicTo(
                (-37.63).toResponsiveWidth(),
                262.5.toResponsiveHeight(),
                (-117).toResponsiveWidth(),
                154.63.toResponsiveHeight(),
                (-117).toResponsiveWidth(),
                154.63.toResponsiveHeight()
        )
        canvas?.drawPath(path, upperDashesPaint)
    }

    private fun drawCircle(r: Float, canvas: Canvas?) {
        val paint = Paint()
        paint.color = ContextCompat.getColor(context, R.color.colorWhite)
        paint.strokeWidth = dpToPx(context, 1f)
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        canvas?.drawCircle(74.01.toResponsiveWidth(), 360.5.toResponsiveHeight(), r, paint)
    }

    private fun drawCircleWithDashPathEffect(
            r: Float,
            canvas: Canvas?,
            floatArray: FloatArray
    ) {
        val paint = Paint()
        paint.color = ContextCompat.getColor(context, R.color.colorWhite)
        paint.strokeWidth = dpToPx(context, 1f)
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.pathEffect = DashPathEffect(floatArray, 0f)
        canvas?.drawCircle(314.toResponsiveWidth(), 669.toResponsiveHeight(), r, paint)
    }

}