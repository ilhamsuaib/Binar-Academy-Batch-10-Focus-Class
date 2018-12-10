package id.ilhamsuaib.app.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.data.PreferenceManager
import kotlinx.android.synthetic.main.fragment_profile.view.*

/**
 * Created by @ilhamsuaib on 05/12/18.
 * github.com/ilhamsuaib
 */

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
    }

    private fun setupView(v: View) {
        val pref = PreferenceManager(v.context)
        v.tvUsername.text = pref.username
    }
}