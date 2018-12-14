package id.ilhamsuaib.app.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ilhamsuaib.app.BinarApp
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.activity.NewStudentActivity
import id.ilhamsuaib.app.activity.ViewStudentActivity
import id.ilhamsuaib.app.adapter.StudentAdapter
import id.ilhamsuaib.app.model.GeneralResponse
import id.ilhamsuaib.app.model.Student
import id.ilhamsuaib.app.utils.extensions.toast
import kotlinx.android.synthetic.main.fragment_student.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentFragment : Fragment() {

    private val studentList = mutableListOf<Student>()
    private val studentAdapter = StudentAdapter(studentList, this::onItemClick)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    override fun onResume() {
        super.onResume()
        getStudents()
    }

    private fun setupView() = view?.apply {
        rvStudent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = studentAdapter
        }

        fabNewStudent.setOnClickListener {
            startActivity(Intent(context, NewStudentActivity::class.java))
        }
    }

    private fun onItemClick(student: Student) {
        val options = arrayOf("View", "Edit", "Delete")
        AlertDialog.Builder(requireContext())
            .setItems(options) { dialog, which ->
                when (which) {
                    0 -> {
                        val viewStudentIntent = Intent(context, ViewStudentActivity::class.java)
                        viewStudentIntent.putExtra(Student.STUDENT, student)
                        startActivity(viewStudentIntent)
                    }
                    1 -> {
                        val editStudentIntent = Intent(context, NewStudentActivity::class.java)
                        editStudentIntent.putExtra(Student.STUDENT, student)
                        startActivity(editStudentIntent)
                    }
                    2 -> {
                        askForDelete(student)
                    }
                }
                dialog.dismiss()
            }
            .show()
    }

    private fun askForDelete(student: Student) {
        AlertDialog.Builder(requireContext())
            .setTitle("Hapus")
            .setMessage("Anda yakin akan menghapus data siswa ${student.name}")
            .setPositiveButton("Tidak") { dialog, which ->
                dialog.dismiss()
            }
            .setNegativeButton("Ya") { dialog, which ->
                deleteStudent(student)
            }
            .show()
    }

    private fun deleteStudent(student: Student) {
        BinarApp.apiService
            .deleteStudent(student.id.toString())
            .enqueue(object : Callback<GeneralResponse<Student>> {
                override fun onFailure(call: Call<GeneralResponse<Student>>, t: Throwable) {
                    toast("Gagal menghapus siswa ${student.name}, periksa koneksi Anda")
                }

                override fun onResponse(
                    call: Call<GeneralResponse<Student>>,
                    response: Response<GeneralResponse<Student>>
                ) {
                    toast("Data siswa ${student.name} telah dihapus")
                    getStudents()
                }
            })
    }

    private fun getStudents() {
        showProgress(true)
        BinarApp.apiService
            .getAllStudents()
            .enqueue(object : Callback<GeneralResponse<List<Student>>> {

                override fun onFailure(call: Call<GeneralResponse<List<Student>>>, t: Throwable) {
                    toast(t.localizedMessage)
                    showProgress(false)
                }

                override fun onResponse(
                    call: Call<GeneralResponse<List<Student>>>,
                    response: Response<GeneralResponse<List<Student>>>
                ) {
                    showProgress(false)
                    val students: List<Student>? = response.body()?.data

                    onResponseSuccess(students ?: emptyList())
                }
            })
    }

    private fun showProgress(show: Boolean) {
        view?.progress?.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun onResponseSuccess(students: List<Student>) {
        studentList.clear()
        studentList.addAll(students)
        studentAdapter.notifyDataSetChanged()
    }
}