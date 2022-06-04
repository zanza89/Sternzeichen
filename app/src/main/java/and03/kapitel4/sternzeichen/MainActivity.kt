package and03.kapitel4.sternzeichen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.NumberPicker
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numberpicker = findViewById<NumberPicker>(R.id.numberpicker_tag)
        numberpicker.minValue = 1
        numberpicker.maxValue = 31
        //31.Februar etc. verhindern
        val spinner = findViewById<Spinner>(R.id.spinner_monat)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val tage = intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
                numberpicker.maxValue = tage[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun onButtonOkClick(view: View?) {
        val tag = findViewById<NumberPicker>(R.id.numberpicker_tag).value
        val monat = findViewById<Spinner>(R.id.spinner_monat).getSelectedItemPosition()
        val textView = findViewById<TextView>(R.id.textview_ausgabe)
        textView.text = "Dein Sternzeichen ist " + sternzeichen(tag, monat+1)
    }
}