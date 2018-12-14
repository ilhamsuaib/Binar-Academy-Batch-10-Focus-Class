package id.ilhamsuaib.app.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.model.Student

class ViewStudentActivity : AppCompatActivity() {

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student)

        student = intent.getParcelableExtra(Student.STUDENT)
    }
}
