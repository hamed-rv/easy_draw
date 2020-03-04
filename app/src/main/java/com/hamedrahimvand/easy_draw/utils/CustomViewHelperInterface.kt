package com.hamedrahimvand.easy_draw.utils

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-23
 */
interface CustomViewHelperInterface {

    /**
     * Width of design's artboard.
     */
    fun artboardWidth(): Float

    /**
     * Height of design's artboard.
     */
    fun artboardHeight(): Float

    /**
     * Width of target frame that you will draw on it.
     */
    fun targetWidth():Float

    /**
     * Height of target frame that you will draw on it.
     */
    fun targetHeight():Float

    /**
     * Convert design's px to responsive width.
     * @return Responsive width from design
     */
    fun Float.toResponsiveWidth(): Float {
        return calculateWidth(
            getWidthPercentFromDesign(
                this
            ), targetWidth()
        )
    }

    /**
     * Convert design's px to responsive height.
     * @return Responsive height from design
     */
    fun Float.toResponsiveHeight(): Float {
        return calculateHeight(
            getHeightPercentFromDesign(
                this
            ), targetHeight()
        )
    }
    /**
     * Convert Design px to responsive width.
     * @return Responsive width from design
     */
    fun Double.toResponsiveWidth(): Float {
        return calculateWidth(
            getWidthPercentFromDesign(
                this.toFloat()
            ), targetWidth()
        )
    }

    /**
     * Convert design's px to responsive height.
     * @return Responsive height from design
     */
    fun Double.toResponsiveHeight(): Float {
        return calculateHeight(
            getHeightPercentFromDesign(
                this.toFloat()
            ), targetHeight()
        )
    }
     /**
     * Convert design's px to responsive width.
     * @return Responsive width from design
     */
    fun Int.toResponsiveWidth(): Float {
        return calculateWidth(
            getWidthPercentFromDesign(
                this.toFloat()
            ), targetWidth()
        )
    }

    /**
     * Convert design's px to responsive height.
     * @return Responsive height from design
     */
    fun Int.toResponsiveHeight(): Float {
        return calculateHeight(
            getHeightPercentFromDesign(
                this.toFloat()
            ), targetHeight()
        )
    }


    private fun calculateWidth(xp: Float, totalWidth: Float): Float {
        return totalWidth * xp / 100
    }

    private fun calculateHeight(yp: Float, totalHeight: Float): Float {
        return totalHeight * yp / 100
    }

    private fun getWidthPercentFromDesign(px: Float): Float {
        return px * 100 / artboardWidth()
    }

    private fun getHeightPercentFromDesign(px: Float): Float {
        return px * 100 / artboardHeight()
    }
}