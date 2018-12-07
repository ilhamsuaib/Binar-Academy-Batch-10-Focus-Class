package id.ilhamsuaib.app.utils.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}