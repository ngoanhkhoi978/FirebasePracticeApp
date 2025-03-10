package com.example.firebase.model

import com.google.firebase.firestore.Exclude

data class Course(
    @Exclude var courseID: String? = "",
    var courseName: String? = "",
    var courseDuration: String? = "",
    var courseDescription: String? = ""
)
