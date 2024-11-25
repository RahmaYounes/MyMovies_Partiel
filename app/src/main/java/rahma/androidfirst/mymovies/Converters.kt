package rahma.androidfirst.mymovies

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi

class Converters(private val moshi: Moshi) {

    @TypeConverter
    fun fromFilm(film: Film): String {
        return moshi.adapter(Film::class.java).toJson(film)
    }

    @TypeConverter
    fun toFilm(json: String): Film {
        return moshi.adapter(Film::class.java).fromJson(json)!!
    }

    @TypeConverter
    fun fromTv(tv: Tv): String {
        return moshi.adapter(Tv::class.java).toJson(tv)
    }

    @TypeConverter
    fun toTv(json: String): Tv {
        return moshi.adapter(Tv::class.java).fromJson(json)!!
    }

    @TypeConverter
    fun fromPersons(persons: Persons): String {
        return moshi.adapter(Persons::class.java).toJson(persons)
    }

    @TypeConverter
    fun toPersons(json: String): Persons {
        return moshi.adapter(Persons::class.java).fromJson(json)!!
    }
}