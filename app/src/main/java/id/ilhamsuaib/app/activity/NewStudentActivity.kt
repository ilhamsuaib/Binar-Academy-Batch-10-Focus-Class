package id.ilhamsuaib.app.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.ilhamsuaib.app.BinarApp
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.model.GeneralResponse
import id.ilhamsuaib.app.model.Student
import id.ilhamsuaib.app.utils.extensions.sendRequest
import id.ilhamsuaib.app.utils.extensions.toast
import kotlinx.android.synthetic.main.activity_new_student.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewStudentActivity : AppCompatActivity() {

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        student = intent.getParcelableExtra(Student.STUDENT)
        setupView()
    }

    private fun setupView() {
        btnSaveStudent.setOnClickListener {
            saveStudent()
        }
    }

    private fun saveStudent() {

        val name = edtName.text.toString()
        val email = edtEmail.text.toString()

        if (name.isBlank() || email.isBlank()) {
            toast(getString(R.string.nama_dan_email_harus_diisi))
            return
        }

        val studentMap = mutableMapOf<String, String>()
        studentMap["name"] = name
        studentMap["email"] = email

        if (student != null) {
            updateStudent(studentMap)
            return
        }

        BinarApp.apiService
            .saveStudent(studentMap)
            .enqueue(object : Callback<GeneralResponse<Student>> {

                override fun onFailure(call: Call<GeneralResponse<Student>>, t: Throwable) {
                    toast("Gagal menyimpan data siswa, periksa koneksi Anda")
                }

                override fun onResponse(
                    call: Call<GeneralResponse<Student>>,
                    response: Response<GeneralResponse<Student>>
                ) {
                    toast("Sukses menyimpan data siswa")
                    finish()
                }
            })
    }

    private fun updateStudent(studentMap: Map<String, String>) {
        BinarApp.apiService
            .updateStudent(studentMap)
            .sendRequest(this::onErrorUpdate, this::onSuccessUpdate)
    }

    private fun onSuccessUpdate(data: GeneralResponse<Student>?) {
        /*jika update berhasil*/
        finish()
    }

    private fun onErrorUpdate(t: Throwable) {
        /*jika update gagal*/
    }
}
