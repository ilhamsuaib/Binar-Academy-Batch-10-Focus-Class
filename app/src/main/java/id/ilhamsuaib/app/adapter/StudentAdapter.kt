package id.ilhamsuaib.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ilhamsuaib.app.R
import id.ilhamsuaib.app.model.Student
import kotlinx.android.synthetic.main.item_student.view.*

/**
 * Created by @ilhamsuaib on 10/12/18.
 * github.com/ilhamsuaib
 */

class StudentAdapter(private val studentList: List<Student>,
                     private val onClickListener: (student: Student) -> Unit) : RecyclerView.Adapter<StudentAdapter.StudentHolder>() {

    override fun onCreateViewHolder(group: ViewGroup, viewType: Int): StudentHolder {
        val inflater = LayoutInflater.from(group.context)
        val view: View = inflater.inflate(R.layout.item_student, group, false)
        return StudentHolder(view)
    }

    override fun getItemCount(): Int = studentList.size

    override fun onBindViewHolder(holder: StudentHolder, i: Int) {
        val student = studentList[i]
        holder.bind(student)
        holder.itemView.setOnClickListener {
            onClickListener(student)
        }
    }

    inner class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(student: Student) = with(itemView) {
            tvStudentName.text = student.name
            tvStudentEmail.text = student.email
            imgStudent.setImageResource(R.mipmap.ic_launcher)
        }
    }
}