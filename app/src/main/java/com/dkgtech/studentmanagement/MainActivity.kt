package com.dkgtech.studentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DbHelper(this@MainActivity)

        /*dbHelper.addStudent("Dipesh", "X", "B", "d@gmail.com", true)
        dbHelper.addStudent("Sachin", "VII", "A", "s@gmail.com", true)*/

        val arrStudents = dbHelper.getAllStudents()
        Log.d("students", "onCreate: $arrStudents")

    }
}