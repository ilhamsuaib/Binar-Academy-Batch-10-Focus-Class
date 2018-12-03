package id.ilhamsuaib.app.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.extensions.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        const val USERNAME: String = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupView()
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

        if (username == "ilham" && password == "1") {
            toast("Login sukses")

            //berpindah ke halaman main dan membawa data username
            val gotoMain = Intent(this, MainActivity::class.java)
            gotoMain.putExtra(USERNAME, username)
            startActivity(gotoMain)
            finish()
        } else {
            toast("Username atau password salah")
        }
    }
}
