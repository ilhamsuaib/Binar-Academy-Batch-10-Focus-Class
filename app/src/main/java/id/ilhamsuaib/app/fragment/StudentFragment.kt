package id.ilhamsuaib.app.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.adapter.StudentAdapter
import id.ilhamsuaib.app.model.Student
import id.ilhamsuaib.app.utils.extensions.toast
import kotlinx.android.synthetic.main.fragment_student.view.*
import id.ilhamsuaib.app.BinarApp
import id.ilhamsuaib.app.model.GeneralResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentFragment : Fragment() {

    private val studentList = mutableListOf<Student>()
    private val studentAdapter = StudentAdapter(studentList) {
        //pindah ke halaman detail, sambil ngirim data
        toast("View student : ${it.name}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        getStudents()
    }

    private fun setupView() = view?.apply {
        rvStudent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }
    }

    private fun getStudents() {
        BinarApp.apiService.getAllStudents()
                .enqueue(object : Callback<GeneralResponse<List<Student>>> {

                    override fun onFailure(call: Call<GeneralResponse<List<Student>>>, t: Throwable) {
                        toast("No internet connection")
                    }

                    override fun onResponse(call: Call<GeneralResponse<List<Student>>>, response: Response<GeneralResponse<List<Student>>>) {
                        val students: List<Student>? = response.body()?.data

                        onResponseSuccess(students ?: emptyList())
                    }
                })
    }

    private fun onResponseSuccess(students: List<Student>) {
        //todo : menampilkan data ke recycler view
    }
}