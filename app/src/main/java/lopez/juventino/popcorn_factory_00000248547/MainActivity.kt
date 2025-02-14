package lopez.juventino.popcorn_factory_00000248547

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        cargarPeliculas()

        adapter = PeliculaAdapter(this, peliculas)
        var gridView: GridView = findViewById(R.id.gridView)
        gridView.adapter = adapter
    }

    fun cargarPeliculas() {
        peliculas.add(Pelicula("1917", R.drawable.a1917, R.drawable.a1917header, "WW1"))
        peliculas.add(Pelicula("1917", R.drawable.a1917, R.drawable.a1917header, "WW1"))
        peliculas.add(Pelicula("1917", R.drawable.a1917, R.drawable.a1917header, "WW1"))
        peliculas.add(Pelicula("1917", R.drawable.a1917, R.drawable.a1917header, "WW1"))
        peliculas.add(Pelicula("1917", R.drawable.a1917, R.drawable.a1917header, "WW1"))
        peliculas.add(Pelicula("1917", R.drawable.a1917, R.drawable.a1917header, "WW1"))
        peliculas.add(Pelicula("1917", R.drawable.a1917, R.drawable.a1917header, "WW1"))
    }
}

class PeliculaAdapter(var context: Context, var peliculas: ArrayList<Pelicula>) : BaseAdapter() {

    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(position: Int): Any {
        return peliculas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var pelicula = peliculas[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.pelicula, null)
        var ivPelicula: ImageView = vista.findViewById(R.id.ivPelicula)
        var tvNombrePelicua: TextView = vista.findViewById(R.id.tvNombrePelicula)

        ivPelicula.setImageResource(pelicula.image)
        tvNombrePelicua.setText(pelicula.titulo)

        ivPelicula.setOnClickListener {
            var intent = Intent(context, DetallePelicula::class.java)
            intent.putExtra("titulo", pelicula.titulo)
            intent.putExtra("image", pelicula.image)
            intent.putExtra("header", pelicula.header)
            intent.putExtra("sinopsis", pelicula.sinopsis)
            context!!.startActivity(intent)
        }

        return vista
    }

}