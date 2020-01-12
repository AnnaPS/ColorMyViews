package com.novadev.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setListeners()
    }

    private fun initView(){
        tv_reset.visibility = View.INVISIBLE
        tv_reset.isClickable = false

    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            tv_box_one, tv_box_two, tv_box_three,
            tv_box_four, tv_box_five, clMain, tv_reset,
            bt_green,bt_red,bt_yellow
        )

        for (item in clickableViews) {
            if (item == tv_reset) {
                item.setOnClickListener {
                    resetView()
                }
            } else {
                item.setOnClickListener {
                    makeColored(it)
                }
            }

        }
    }

    private fun makeColored(view: View) {
        tv_reset.visibility = View.VISIBLE
        tv_reset.isClickable = true
        when (view) {

            // Boxes using Color class colors for background
            tv_box_one -> view.setBackgroundColor(Color.DKGRAY)
            tv_box_two -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            tv_box_three -> view.setBackgroundResource(android.R.color.holo_green_light)
            tv_box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            tv_box_five -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            bt_red-> tv_box_three.setBackgroundResource(R.color.my_red)
            bt_yellow -> tv_box_four.setBackgroundResource(R.color.my_yellow)
            bt_green -> tv_box_five.setBackgroundResource(R.color.my_green)


            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun resetView() {
        tv_box_one.setBackgroundColor(Color.WHITE)
        tv_box_two.setBackgroundColor(Color.WHITE)
        tv_box_three.setBackgroundColor(Color.WHITE)
        tv_box_four.setBackgroundColor(Color.WHITE)
        tv_box_five.setBackgroundColor(Color.WHITE)
        clMain.setBackgroundColor(Color.WHITE)
        tv_reset.visibility = View.INVISIBLE
        tv_reset.isClickable = false

    }
}
