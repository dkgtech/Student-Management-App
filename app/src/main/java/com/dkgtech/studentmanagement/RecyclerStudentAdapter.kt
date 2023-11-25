package com.dkgtech.studentmanagement

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.studentmanagement.databinding.StudentsRowBinding

class RecyclerStudentAdapter(val context: Context, val arrStudents: ArrayList<StudentModel>) :
    RecyclerView.Adapter<RecyclerStudentAdapter.ViewHolder>() {
    class ViewHolder(val binding: StudentsRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(StudentsRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrStudents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val data = arrStudents[position]
            txtStudentId.text = data.id.toString()
            txtStudentName.text = data.name
            txtStudentClass.text = data.className
            txtStudentSection.text = data.section
            txtStudentEmail.text = data.email
        }
    }
}