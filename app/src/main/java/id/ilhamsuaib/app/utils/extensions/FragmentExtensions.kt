package id.ilhamsuaib.app.utils.extensions

import android.support.v4.app.Fragment

/**
 * Created by @ilhamsuaib on 10/12/18.
 * github.com/ilhamsuaib
 */

fun Fragment.toast(message: String) = this.requireContext().toast(message)