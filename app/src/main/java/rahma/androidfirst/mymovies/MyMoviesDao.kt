package rahma.androidfirst.mymovies

import androidx.room.*

@Dao
interface MyMoviesDao {
    // Gestion des films
    @Query("SELECT * FROM FilmEntity")
    fun getFavoriteFilms(): List<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: FilmEntity)

    @Delete
    suspend fun deleteFilm(film: FilmEntity)

    // Gestion des séries
    @Query("SELECT * FROM SerieEntity")
    fun getFavoriteSeries(): List<SerieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSerie(serie: SerieEntity)

    @Delete
    suspend fun deleteSerie(serie: SerieEntity)

    // Gestion des acteurs
    @Query("SELECT * FROM ActeurEntity")
    fun getFavoriteActors(): List<ActeurEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActor(actor: ActeurEntity)

    @Delete
    suspend fun deleteActor(actor: ActeurEntity)
}
