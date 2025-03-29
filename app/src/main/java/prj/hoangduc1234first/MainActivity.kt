package prj.hoangduc1234first
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Spinner
class MainActivity : AppCompatActivity() {
    private lateinit var inputAmount: EditText
    private lateinit var fromCurrency: Spinner
    private lateinit var toCurrency: Spinner
    private lateinit var resultTV: TextView
    private lateinit var convertButton: Button

    // Tỷ giá giả định
    private val exchangeRates = mapOf(
        "VND" to 1.0,
        "USD" to 0.000039,
        "EUR" to 0.000036,
        "JPY" to 0.0059,
        "YUAN" to 0.00028,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputAmount = findViewById(R.id.inputAmount)
        fromCurrency = findViewById(R.id.fromCurrency)
        toCurrency = findViewById(R.id.toCurrency)
        resultTV = findViewById(R.id.resultTV)
        convertButton = findViewById(R.id.convertButton)

        convertButton.setOnClickListener { convertCurrency() }
    }

    private fun convertCurrency() {
        val amount = inputAmount.text.toString().toDoubleOrNull() ?: return
        val from = exchangeRates[fromCurrency.selectedItem.toString()] ?: 1.0
        val to = exchangeRates[toCurrency.selectedItem.toString()] ?: 1.0

        val rate = to / from
        val convertedAmount = amount * rate

        resultTV.text = String.format("%.6f", convertedAmount)
    }
}
