package lopez.juventino.popcorn_factory_00000248547

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get

class SeleccionAsientosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seleccion_asientos)

        var posicionPelicula = -1
        var nombrePelicula = ""
        val btnConfirmar: Button = findViewById(R.id.btnConfirmar)

        val bundle = intent.extras

        if (bundle != null) {
            posicionPelicula = bundle.getInt("id")
            nombrePelicula = bundle.getString("name").toString()
        }

        val rowOne: RadioGroup = findViewById(R.id.rowOne)
        val rowTwo: RadioGroup = findViewById(R.id.rowTwo)
        val rowThree: RadioGroup = findViewById(R.id.rowThree)
        val rowFour: RadioGroup = findViewById(R.id.rowFour)

        rowOne.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                rowTwo.clearCheck()
                rowThree.clearCheck()
                rowFour.clearCheck()

                rowOne.check(checkedId)
            }
        }

        rowTwo.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                rowOne.clearCheck()
                rowThree.clearCheck()
                rowFour.clearCheck()

                rowTwo.check(checkedId)
            }
        }

        rowThree.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                rowTwo.clearCheck()
                rowOne.clearCheck()
                rowFour.clearCheck()

                rowThree.check(checkedId)
            }
        }

        rowFour.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                rowTwo.clearCheck()
                rowThree.clearCheck()
                rowOne.clearCheck()

                rowFour.check(checkedId)
            }
        }

        btnConfirmar.setOnClickListener {
            var asientoSeleccionado = 0
            val etNombre: EditText = findViewById(R.id.etNombre)
            if (rowOne.checkedRadioButtonId-1 > -1) {
                asientoSeleccionado = (rowOne.get(rowOne.checkedRadioButtonId) as RadioButton).text.toString().toInt()
            } else if (rowTwo.checkedRadioButtonId > -1) {
                asientoSeleccionado = (rowTwo.get(rowTwo.checkedRadioButtonId-6) as RadioButton).text.toString().toInt()
            } else if (rowThree.checkedRadioButtonId > -1) {
                asientoSeleccionado = (rowThree.get(rowThree.checkedRadioButtonId-11) as RadioButton).text.toString().toInt()
            } else if (rowFour.checkedRadioButtonId > -1) {
                asientoSeleccionado = (rowFour.get(rowFour.checkedRadioButtonId-16) as RadioButton).text.toString().toInt()
            }
            var intent: Intent = Intent(this, ConfirmarCompraActivity::class.java)
            intent.putExtra("asientoSeleccionado", asientoSeleccionado)
            intent.putExtra("posicion", posicionPelicula)
            intent.putExtra("nombrePelicula", nombrePelicula)
            intent.putExtra("nombreCliente", etNombre.text.toString())

            this.startActivity(intent)
        }
    }
}