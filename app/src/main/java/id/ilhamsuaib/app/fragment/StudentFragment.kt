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
        studentList.add(Student(R.mipmap.ic_launcher, "Ilham Suaib", "ilhamsuaib10@gmail.com"))
        studentList.add(Student(R.mipmap.ic_launcher, "Rega", "ilhamsuaib10@gmail.com"))
        studentList.add(Student(R.mipmap.ic_launcher, "Bagus", "ilhamsuaib10@gmail.com"))
        studentList.add(Student(R.mipmap.ic_launcher, "Sandy", "ilhamsuaib10@gmail.com"))
        studentList.add(Student(R.mipmap.ic_launcher, "Ahmad", "ilhamsuaib10@gmail.com"))
        studentList.add(Student(R.mipmap.ic_launcher, "Putra", "ilhamsuaib10@gmail.com"))
        studentList.add(Student(R.mipmap.ic_launcher, "Putri", "putri@gmail.com"))

        (1..10).forEach {
            studentList.add(Student(R.mipmap.ic_launcher, "Student $it", "email$it@gmail.com"))
        }

        studentAdapter.notifyDataSetChanged()
    }
}