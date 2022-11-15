package sv.edu.udb.beautyapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.time.MonthDay
import android.content.Context
//Clase para el calendario
class DatePickerFragment(val listener:(date:Int , month:Int,year:Int)->Unit):DialogFragment(),
    DatePickerDialog.OnDateSetListener{

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month  = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)
        val picker =DatePickerDialog(activity as Context,R.style.TimePicker,this,year,month,day)
        return picker
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day:Int) {
       listener(day,month,year)
    }

}

