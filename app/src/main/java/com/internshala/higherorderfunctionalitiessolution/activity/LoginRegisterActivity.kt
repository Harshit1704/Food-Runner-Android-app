package com.internshala.higherorderfunctionalitiessolution.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.internshala.higherorderfunctionalitiessolution.*
import com.internshala.higherorderfunctionalitiessolution.fragment.LoginFragment

class LoginRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        val sharedPreferences = getSharedPreferences(
            getString(R.string.shared_preferences),
            Context.MODE_PRIVATE
        )

        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        } else {
            openLoginFragment()
        }
        /*Linking the view*/

    }

    fun openLoginFragment() {
        supportFragmentManager.beginTransaction().replace(
            R.id.frameLayout,
            LoginFragment(this)
        ).commit()

        supportActionBar?.title = "DashBoard"
    }

    override fun onBackPressed() {
        when (supportFragmentManager.findFragmentById(R.id.frameLayout)) {
            !is LoginFragment -> openLoginFragment()
            else -> super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                openLoginFragment()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
