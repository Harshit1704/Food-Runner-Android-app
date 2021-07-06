package com.internshala.higherorderfunctionalitiessolution.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.internshala.higherorderfunctionalitiessolution.*
class SplashActivity : AppCompatActivity() {

    lateinit var topAnim: Animation
    lateinit var txtAppName: TextView
    lateinit var imgAppIcon: ImageView

    /*Life-cycle method of the activity*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash)

        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        txtAppName = findViewById(R.id.txtAppName)
        imgAppIcon = findViewById(R.id.imgAppIcon)

        txtAppName.animation = topAnim
        imgAppIcon.animation = topAnim

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, LoginRegisterActivity::class.java))
            finish()
        }, 2000)
    }
}
