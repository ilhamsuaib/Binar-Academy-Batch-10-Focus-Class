package id.ilhamsuaib.app.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.data.PreferenceManager
import id.ilhamsuaib.app.fragment.MaterialFragment
import id.ilhamsuaib.app.fragment.ProfileFragment
import id.ilhamsuaib.app.fragment.StudentFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {

        setFragment(StudentFragment(), getString(R.string.student))
        mainNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuNavStudent -> setFragment(StudentFragment(), getString(R.string.student))
                R.id.menuNavMaterial -> setFragment(MaterialFragment(), getString(R.string.material))
                R.id.menuNavProfile -> setFragment(ProfileFragment(), getString(R.string.profile))
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setFragment(frm: Fragment, title: String) {
        this.title = title
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, frm)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menuLogout) {
            val pref = PreferenceManager(this)
            pref.logOut()
            val goToLogin = Intent(this, LoginActivity::class.java)
            startActivity(goToLogin)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
