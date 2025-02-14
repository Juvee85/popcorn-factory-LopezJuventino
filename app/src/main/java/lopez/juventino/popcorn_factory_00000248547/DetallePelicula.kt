package lopez.juventino.popcorn_factory_00000248547

import android.os.Bundle
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

        var ivPelicula: ImageView = findViewById(R.id.ivPelicula)
        var tvNombrePelicula: TextView = findViewById(R.id.tvNombrePelicula)
        var tvDescPelicula: TextView = findViewById(R.id.tvDescPelicla)

        if (bundle != null) {
            ivPelicula.setImageResource(bundle.getInt("header"))
            tvNombrePelicula.setText(bundle.getString("titulo"))
            tvDescPelicula.setText(bundle.getString("sinopsis"))
        }
    }
}