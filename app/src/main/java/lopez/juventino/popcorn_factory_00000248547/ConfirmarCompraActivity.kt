package lopez.juventino.popcorn_factory_00000248547

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ConfirmarCompraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmar_compra)

        val bundle = intent.extras
        val tvNombre: TextView = findViewById(R.id.tvNombre)
        val tvAsientoComprado: TextView = findViewById(R.id.tvAsientoComprado)
        val tvNombrePelicula: TextView = findViewById(R.id.tvNombrePelicula)
        val btnSalir: Button = findViewById(R.id.btnSalir)

        var nombreCliente = ""
        var posicion = -1
        var asientoComprado = -1
        if (bundle != null) {
            nombreCliente = bundle.getString("nombreCliente")!!
            posicion = bundle.getInt("posicion")
            asientoComprado = bundle.getInt("asientoSeleccionado")

            tvAsientoComprado.text = "$asientoComprado"
            tvNombrePelicula.text = bundle.getString("nombrePelicula")
            tvNombre.text = nombreCliente
        }

        btnSalir.setOnClickListener {
            var intent: Intent = Intent(this, MainActivity::class.java)

            this.startActivity(intent)
        }

    }
}