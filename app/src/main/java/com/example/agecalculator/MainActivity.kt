package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dobButton.setOnClickListener{view->
            printAge(view)
        }
    }

    private fun printAge(view: View) {
        var myCalendar= Calendar.getInstance();
        var year=myCalendar.get(Calendar.YEAR)
        var month=myCalendar.get(Calendar.MONTH)
        var day=myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
            view,year,month,day->
            val selectedDOB="$day/${month+1}/$year"
            numDob.text=selectedDOB

            var dob=Calendar.getInstance()
            dob.set(year,month,day)
            var age=myCalendar.get(Calendar.YEAR)-dob.get(Calendar.YEAR)
                if(myCalendar.get(Calendar.DAY_OF_YEAR)<dob.get(Calendar.DAY_OF_YEAR)){
                    age--
                }

            TVage.text="You are $age years old"

        }
            ,year,
            month,
            day).show()
    }
}
