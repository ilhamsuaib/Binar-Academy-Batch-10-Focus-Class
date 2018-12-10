package id.ilhamsuaib.app.data

import id.ilhamsuaib.app.model.GeneralResponse
import id.ilhamsuaib.app.model.Student
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by @ilhamsuaib on 10/12/18.
 * github.com/ilhamsuaib
 */

interface ApiService {

    @GET("api/v1/student/all")
    fun getAllStudents(): Call<GeneralResponse<List<Student>>>

    @GET("api/v1/student/{id}")
    fun getStudentById(@Path("id") studentId: String): Call<GeneralResponse<Student>>

    @DELETE("api/v1/student/{id}")
    fun deleteStudent(@Path("id") studentId: String): Call<GeneralResponse<Student>>

    //todo: setup request for UPDATE and SAVE
}