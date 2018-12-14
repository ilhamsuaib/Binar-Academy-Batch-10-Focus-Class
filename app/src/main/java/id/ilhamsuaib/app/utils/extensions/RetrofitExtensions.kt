package id.ilhamsuaib.app.utils.extensions

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by @ilhamsuaib on 14/12/18.
 * github.com/ilhamsuaib
 */

fun <T> Call<T>.sendRequest(onFailure: (t: Throwable) -> Unit,
                            onResponse: (data: T?) -> Unit) {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            onFailure(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            onResponse(response.body())
        }
    })
}