package com.dkgtech.studentmanagement

data class StudentModel(
    val id: Int,
    val name: String,
    val className: String,
    val section: String,
    val email: String,
    val result: Boolean
) {
}