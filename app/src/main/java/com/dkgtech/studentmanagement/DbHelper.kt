package com.dkgtech.studentmanagement

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

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}