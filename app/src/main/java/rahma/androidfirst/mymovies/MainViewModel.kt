package rahma.androidfirst.mymovies

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val API_KEY = "096dad21e614ff913e251c3c4ec79a90"
val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

class MainViewModel(appDao: AppDao) : ViewModel() {
    private val repository = Repository(appDao)
    val api = retrofit.create(Api::class.java)
    val listmovies = MutableStateFlow<List<Film>>(listOf())
    val searchQuery = MutableStateFlow("")

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            listmovies.value = api.lastmovies(api_key = API_KEY).results
        }
    }

    fun searchMovies(query: String) {
        viewModelScope.launch {
            searchQuery.value = query
            if (query.isNotEmpty()) {
                listmovies.value = api.searchMovies(api_key = API_KEY, query = query).results
            } else {
                getMovies()
            }
        }
    }

    val allFilms = repository.getAllFilms()
    val allSeries = repository.getAllSeries()
    val allActeurs = repository.getAllActeurs()

    fun insertFilm(film: FilmEntity) {
        viewModelScope.launch {
            repository.insertFilm(film)
        }
    }

    fun insertSerie(serie: SerieEntity) {
        viewModelScope.launch {
            repository.insertSerie(serie)
        }
    }

    fun insertActeur(acteur: ActeurEntity) {
        viewModelScope.launch {
            repository.insertActeur(acteur)
        }
    }

    fun toggleFavoriteFilm(film: FilmEntity) {
        viewModelScope.launch {
            if (film.isFav) {
                repository.deleteFilm(film)
            } else {
                repository.insertFilm(film.copy(isFav = true))
            }
        }
    }

    fun toggleFavoriteSerie(serie: SerieEntity) {
        viewModelScope.launch {
            if (serie.isFav) {
                repository.deleteSerie(serie)
            } else {
                repository.insertSerie(serie.copy(isFav = true))
            }
        }
    }

    fun toggleFavoriteActeur(acteur: ActeurEntity) {
        viewModelScope.launch {
            if (acteur.isFav) {
                repository.deleteActeur(acteur)
            } else {
                repository.insertActeur(acteur.copy(isFav = true))
            }
        }
    }

    fun toggleFavoriteView(showFavorites: Boolean) {
        // Update the lists of entities to show only favorites or all items
    }
}

class ViewModelserie(appDao: AppDao) : ViewModel() {
    private val repository = Repository(appDao)
    val api = retrofit.create(Api::class.java)
    val listtvs = MutableStateFlow<List<Tv>>(listOf())
    val searchQuery = MutableStateFlow("")

    init {
        getTvs()
    }

    fun getTvs() {
        viewModelScope.launch {
            listtvs.value = api.lasttvs(api_key = API_KEY).results
        }
    }

    fun searchSeries(query: String) {
        viewModelScope.launch {
            searchQuery.value = query
            if (query.isNotEmpty()) {
                listtvs.value = api.searchSeries(api_key = API_KEY, query = query).results
            } else {
                getTvs()
            }
        }
    }
}

class ViewModelperson(appDao: AppDao) : ViewModel() {
    private val repository = Repository(appDao)
    val api = retrofit.create(Api::class.java)
    val listpersons = MutableStateFlow<List<Persons>>(listOf())
    val searchQuery = MutableStateFlow("")

    init {
        getPersons()
    }

    fun getPersons() {
        viewModelScope.launch {
            listpersons.value = api.lastpersons(api_key = API_KEY).results
        }
    }

    fun searchPersons(query: String) {
        viewModelScope.launch {
            searchQuery.value = query
            if (query.isNotEmpty()) {
                listpersons.value = api.searchPersons(api_key = API_KEY, query = query).results
            } else {
                getPersons()
            }
        }
    }
}

class ViewModeldescfilm(savedStateHandle: SavedStateHandle, appDao: AppDao) : ViewModel() {
    private val repository = Repository(appDao)
    private val filmId: String = checkNotNull(savedStateHandle["filmId"])
    val api = retrofit.create(Api::class.java)
    val listDetailFilm = MutableStateFlow<DescFILM>(DescFILM())

    init {
        getDescFilm()
    }

    fun getDescFilm() {
        viewModelScope.launch {
            listDetailFilm.value = api.detailfilm(filmId, api_key = API_KEY)
        }
    }
}

class ViewModeldescserie(savedStateHandle: SavedStateHandle, appDao: AppDao) : ViewModel() {
    private val repository = Repository(appDao)
    private val serieId: String = checkNotNull(savedStateHandle["serieId"])
    val api = retrofit.create(Api::class.java)
    val listDetailserie = MutableStateFlow<DetailsSerie>(DetailsSerie())

    init {
        getDescserie()
    }

    fun getDescserie() {
        viewModelScope.launch {
            listDetailserie.value = api.detailserie(serieId, api_key = API_KEY)
        }
    }
}

class Repository(private val appDao: AppDao) {

    fun getAllFilms() = appDao.getAllFilms()
    fun getAllSeries() = appDao.getAllSeries()
    fun getAllActeurs() = appDao.getAllActeurs()

    suspend fun insertFilm(film: FilmEntity) {
        appDao.insertFilm(film)
    }

    suspend fun insertSerie(serie: SerieEntity) {
        appDao.insertSerie(serie)
    }

    suspend fun insertActeur(acteur: ActeurEntity) {
        appDao.insertActeur(acteur)
    }

    suspend fun deleteFilm(film: FilmEntity) {
        appDao.deleteFilm(film)
    }

    suspend fun deleteSerie(serie: SerieEntity) {
        appDao.deleteSerie(serie)
    }

    suspend fun deleteActeur(acteur: ActeurEntity) {
        appDao.deleteActeur(acteur)
    }
}