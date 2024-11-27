package rahma.androidfirst.mymovies

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.JsonAdapter

class Converters {

    // Créer un instance Moshi sans KotlinJsonAdapterFactory
    private val moshi = Moshi.Builder().build()

    // Utilisation de l'adaptateur générique pour Film, Tv, et Person
    private val filmAdapter: JsonAdapter<Film> = moshi.adapter(Film::class.java)
    private val tvAdapter: JsonAdapter<Tv> = moshi.adapter(Tv::class.java)
    private val personsAdapter: JsonAdapter<Persons> = moshi.adapter(Persons::class.java)

    @TypeConverter
    fun fromFilm(film: Film): String? = filmAdapter.toJson(film)

    @TypeConverter
    fun toFilm(json: String?): Film? = json?.let { filmAdapter.fromJson(it) }

    @TypeConverter
    fun fromTv(tv: Tv): String? = tvAdapter.toJson(tv)

    @TypeConverter
    fun toTv(json: String?): Tv? = json?.let { tvAdapter.fromJson(it) }

    @TypeConverter
    fun fromPersons(persons: Persons): String? = personsAdapter.toJson(persons)

    @TypeConverter
    fun toPersons(json: String?): Persons? = json?.let { personsAdapter.fromJson(it) }
}
