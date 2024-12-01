package com.example.criminalintent

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment : DialogFragment() {

    interface Callbacks {
        fun onDateSelected(date: Date)
    }

    companion object {
        const val RESULT_KEY = "date"
        const val RESULT_DATE = "date_result"

        fun newInstance(date: Date): DatePickerFragment {
            val args = Bundle().apply {
                putSerializable(RESULT_DATE, date)
            }
            return DatePickerFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): android.app.Dialog {
        val date = arguments?.getSerializable(RESULT_DATE) as Date
        val calendar = Calendar.getInstance()
        calendar.time = date
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val listener = DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = GregorianCalendar(selectedYear, selectedMonth, selectedDay).time
            parentFragmentManager.setFragmentResult(RESULT_KEY, Bundle().apply {
                putSerializable(RESULT_DATE, selectedDate)
            })
        }

        return DatePickerDialog(requireContext(), listener, year, month, day)
    }
}
