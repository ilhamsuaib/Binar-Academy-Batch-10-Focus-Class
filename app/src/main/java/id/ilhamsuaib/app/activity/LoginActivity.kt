package id.ilhamsuaib.app.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.data.PreferenceManager
import id.ilhamsuaib.app.utils.extensions.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var pref: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        pref = PreferenceManager(this)
        setupView()
        checkLogin()
    }

    private fun checkLogin() {
        if (pref.hasLogin) {
            goToMain()
        }
    }

    private fun setupView() {
        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = edtUsername.text.toString()
        val password = edtPassword.text.toString()

        if (username.isBlank() || password.isBlank()) {
            toast("Username dan password harus diisi")
            return
        }

        toast("Login sukses")

        //menyimpan username ke shared pref
        pref.username = username
        pref.hasLogin = true

        goToMain()
    }

    private fun goToMain() {
        //berpindah ke halaman main dan membawa data username
        val gotoMain = Intent(this, MainActivity::class.java)
        startActivity(gotoMain)
        finish()
    }
}
