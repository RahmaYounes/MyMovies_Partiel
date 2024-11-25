package rahma.androidfirst.mymovies

import androidx.room.*

@Dao
interface AppDao {
    // FilmEntity methods
    @Query("SELECT * FROM FilmEntity")
    fun getAllFilms(): List<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: FilmEntity)

    @Delete
    fun deleteFilm(film: FilmEntity)

    // SerieEntity methods
    @Query("SELECT * FROM SerieEntity")
    fun getAllSeries(): List<SerieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSerie(serie: SerieEntity)

    @Delete
    fun deleteSerie(serie: SerieEntity)

    // ActeurEntity methods
    @Query("SELECT * FROM ActeurEntity")
    fun getAllActeurs(): List<ActeurEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertActeur(acteur: ActeurEntity)

    @Delete
    fun deleteActeur(acteur: ActeurEntity)
}