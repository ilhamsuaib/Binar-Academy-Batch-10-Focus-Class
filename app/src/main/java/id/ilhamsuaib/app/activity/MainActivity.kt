package id.ilhamsuaib.app.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.ilhamsuaib.app.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mengambil data dari intent
        val username: String = intent.getStringExtra(LoginActivity.USERNAME)

        tvUseranme.text = username
    }
}
