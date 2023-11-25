package com.dkgtech.studentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.studentmanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            val dbHelper = DbHelper(this@MainActivity)

            /*dbHelper.addStudent("Dipesh", "X", "B", "d@gmail.com", true)
            dbHelper.addStudent("Sachin", "VII", "A", "s@gmail.com", true)*/

            val arrStudents = dbHelper.getAllStudents()
            Log.d("students", "onCreate: $arrStudents")

            binding.rcViewStudents.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rcViewStudents.adapter = RecyclerStudentAdapter(this@MainActivity, arrStudents)
        }

    }
}