package lopez.juventino.popcorn_factory_00000248547

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetallePelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras

        val ivPelicula: ImageView = findViewById(R.id.ivPelicula)
        val tvNombrePelicula: TextView = findViewById(R.id.tvNombrePelicula)
        val tvDescPelicula: TextView = findViewById(R.id.tvDescPelicla)
        val seatsLeft: TextView = findViewById(R.id.seatsLeft)
        val buyTickets: Button = findViewById(R.id.buyTickets)

        if (bundle != null) {
            ivPelicula.setImageResource(bundle.getInt("header"))
            tvNombrePelicula.setText(bundle.getString("titulo"))
            tvDescPelicula.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("${bundle.getInt("numeroAsientos")} asientos disponibles")

            if (bundle.getInt("numeroAsientos") == 0) {
                buyTickets.isEnabled = false
            } else {
                buyTickets.setOnClickListener {
                    val intent: Intent = Intent(this, SeleccionAsientosActivity::class.java)

                    intent.putExtra("movie", bundle.getInt("posicion"))
                    intent.putExtra("name", bundle.getString("titulo"))

                    this.startActivity(intent)
                }
            }
        }
    }
}