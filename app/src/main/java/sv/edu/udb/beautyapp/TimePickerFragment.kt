package sv.edu.udb.beautyapp

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.time.MonthDay

class TimePickerFragment (val listener:(String)->Unit):DialogFragment(),TimePickerDialog.OnTimeSetListener{
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar:Calendar =Calendar.getInstance()
        val hour =calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val dialog = TimePickerDialog(activity as Context,R.style.TimePicker,this , hour, minute,false)
        return dialog
    }

    override fun onTimeSet(view:TimePicker?, hourofDay:Int, minute:Int) {
        listener("$hourofDay:$minute")
    }

}