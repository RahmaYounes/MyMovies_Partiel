package rahma.androidfirst.mymovies

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): FilmsSemaineFR

    @GET("search/movie")
    suspend fun searchMovies(@Query("api_key") api_key: String, @Query("query") query: String): FilmsSemaineFR

    @GET("trending/tv/week")
    suspend fun lasttvs(@Query("api_key") api_key : String) : TvSemaineFR

    @GET("search/tv")
    suspend fun searchSeries(@Query("api_key") api_key: String, @Query("query") query: String): TvSemaineFR

    @GET("trending/person/week")
    suspend fun lastpersons(@Query("api_key") api_key : String) : PersonSemaineFr

    @GET("search/person")
    suspend fun searchPersons(@Query("api_key") api_key: String, @Query("query") query: String): PersonSemaineFr

    @GET("movie/{filmId}?append_to_response=credits&language=fr")
    suspend fun detailfilm(@Path("filmId") filmId : String?, @Query("api_key") api_key: String) : DescFILM

    @GET("tv/{serieId}?append_to_response=credits&language=fr")
    suspend fun detailserie(@Path("serieId") serieId : String?, @Query("api_key") api_key: String) : DetailsSerie
}