package com.dkgtech.studentmanagement

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "school.db"
        val DB_VERSION = 1

        //        for student table

        val TABLE_NAME = "student"
        val COLUMN_STUDENT_ID = "studentId"
        val COLUMN_STUDENT_NAME = "studentName"
        val COLUMN_STUDENT_CLASS = "studentClass"
        val COLUMN_STUDENT_SECTION = "studentSection"
        val COLUMN_STUDENT_EMAIL = "studentEmail"
        val COLUMN_STUDENT_RESULT = "studentResult"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
//            creating a table

            db.execSQL(
                "CREATE TABLE $TABLE_NAME( " +
                        "$COLUMN_STUDENT_ID integer primary key autoincrement, " +
                        "$COLUMN_STUDENT_NAME text, " +
                        "$COLUMN_STUDENT_CLASS text," +
                        "$COLUMN_STUDENT_SECTION text," +
                        "$COLUMN_STUDENT_EMAIL text unique, " +
                        "$COLUMN_STUDENT_RESULT boolean)"
            )
        }

    }

    fun addStudent(
        name: String,
        className: String,
        section: String,
        email: String,
        result: Boolean
    ) {
        val myDb = writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_STUDENT_NAME, name)
        cv.put(COLUMN_STUDENT_CLASS, className)
        cv.put(COLUMN_STUDENT_SECTION, section)
        cv.put(COLUMN_STUDENT_EMAIL, email)
        cv.put(COLUMN_STUDENT_RESULT, result)

        val check = myDb.insert(TABLE_NAME, null, cv)
    }


    fun getAllStudents(): ArrayList<StudentModel> {
        val myDb = readableDatabase
        val cursor = myDb.rawQuery("SELECT * FROM $TABLE_NAME", null, null)

        val arrStudents = ArrayList<StudentModel>()

//        for reading cursor
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val className = cursor.getString(2)
            val section = cursor.getString(3)
            val email = cursor.getString(4)
            val result = cursor.getString(5)

            val studentModel = StudentModel(id, name, className, section, email, result.toBoolean())
            arrStudents.add(studentModel)
        }

        return arrStudents
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}