package id.ilhamsuaib.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

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
            //munculin pesan bahwa username dan password harus diisi
            return
        }

        if (username == "ilham" && password == "1") {
            //login sukses
            //menuju ke halaman main activity
        } else {
            //tampil pesan username dan password salah
        }

        /**
         * untuk menampilkan pesan : Toast
         * untuk berpindah halaman : Intent
         * */
    }
}
