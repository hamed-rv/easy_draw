package com.hamedrahimvand.easy_draw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamedrahimvand.easy_draw.curv.SampleCurveView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(SampleCurveView(this))
    }
}
