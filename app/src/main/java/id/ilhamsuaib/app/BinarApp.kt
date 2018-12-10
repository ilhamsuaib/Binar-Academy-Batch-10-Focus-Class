package id.ilhamsuaib.app

import android.app.Application
import id.ilhamsuaib.app.data.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by @ilhamsuaib on 10/12/18.
 * github.com/ilhamsuaib
 */

class BinarApp : Application() {

    companion object {
        lateinit var apiService: ApiService
    }

    override fun onCreate() {
        super.onCreate()

        setupRetrofit()
    }

    private fun setupRetrofit() {
        val studentRetrofit = Retrofit.Builder()
                .baseUrl("kotlinspringcrud.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()

        apiService = studentRetrofit.create(ApiService::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val timeOut = 60L
        return OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .addInterceptor(getInterceptor())
                .build()
    }

    private fun getInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}