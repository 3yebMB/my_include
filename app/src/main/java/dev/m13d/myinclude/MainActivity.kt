package dev.m13d.myinclude

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var frameLayoutContainer: LinearLayout
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayoutContainer = findViewById(R.id.frameLayoutContainer)

        findViewById<Button>(R.id.buttonChange).setOnClickListener {
            changeView(changeLayout(++counter))
        }
        changeView(changeLayout(++counter))
    }

    private fun changeLayout(count: Int): View =
        if (count % 2 == 0)
            LayoutInflater.from(this).inflate(R.layout.view_sub_sub, null, false)
        else
            LayoutInflater.from(this).inflate(R.layout.view_sub, null, false)

    private fun changeView(view: View) {
        frameLayoutContainer.removeAllViews()
        frameLayoutContainer.addView(view)
    }
}
