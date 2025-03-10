package com.example.firebase

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebase.ui.theme.FirebaseTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            firebaseUI(LocalContext.current)

        }
    }
}


@Composable
fun firebaseUI(context: Context) {

    // on below line creating variable for course name,
    // course duration and course description.
    val courseName = remember {
        mutableStateOf("")
    }

    val courseDuration = remember {
        mutableStateOf("")
    }

    val courseDescription = remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        // on below line adding vertical and
        // horizontal alignment for column.
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TextField(
            // on below line we are specifying
            // value for our course name text field.
            value = courseName.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { courseName.value = it },

            // on below line we are adding place holder
            // as text as "Enter your course name"
            placeholder = { Text(text = "Enter your course name") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            // on below line we are specifying
            // value for our course duration text field.
            value = courseDuration.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { courseDuration.value = it },

            // on below line we are adding place holder
            // as text as "Enter your course duration"
            placeholder = { Text(text = "Enter your course duration") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            // on below line we are specifying
            // value for our course description text field.
            value = courseDescription.value,

            // on below line we are adding on
            // value change for text field.
            onValueChange = { courseDescription.value = it },

            // on below line we are adding place holder
            // as text as "Enter your course description"
            placeholder = { Text(text = "Enter your course description") },

            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

            // on below line we are adding
            // single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(10.dp))

        // on below line creating button to add data
        // to firebase firestore database.
        Button(
            onClick = {
                // on below line we are validating user input parameters.
                if (TextUtils.isEmpty(courseName.value.toString())) {
                    Toast.makeText(context, "Please enter course name", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(courseDuration.value.toString())) {
                    Toast.makeText(context, "Please enter course Duration", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(courseDescription.value.toString())) {
                    Toast.makeText(context, "Please enter course description", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // on below line adding data to firebase firestore database.
                    addDataToFirebase(courseName.value, courseDuration.value, courseDescription.value, context
                    )
                }
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Add Data", modifier = Modifier.padding(8.dp))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                // on below line opening course details activity.
                context.startActivity(Intent(context, CourseDetailsActivity::class.java))
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "View Courses", modifier = Modifier.padding(8.dp))
        }


    }
}


