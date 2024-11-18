package rahma.androidfirst.mymovies

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import rahma.androidfirst.mymovies.DescFILM
import rahma.androidfirst.mymovies.DetailsSerie
import rahma.androidfirst.mymovies.Film
import rahma.androidfirst.mymovies.Persons
import rahma.androidfirst.mymovies.Tv
import rahma.androidfirst.mymovies.Api


// Déclaration de la clé API une seule fois


val API_KEY = "096dad21e614ff913e251c3c4ec79a90"
val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build();

class MainViewModel : ViewModel() {



    val api = retrofit.create(Api::class.java)

    val listmovies = MutableStateFlow<List<Film>>(listOf())

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            listmovies.value =
                api.lastmovies(api_key = API_KEY ).results
        }
    }
}

class ViewModelserie : ViewModel() {

    val api = retrofit.create(Api::class.java)

    val listtvs = MutableStateFlow<List<Tv>>(listOf())

    init {
        getTvs()
    }

    fun getTvs() {
        viewModelScope.launch {
            listtvs.value =
                api.lasttvs(api_key = API_KEY ).results
        }
    }

}
class ViewModelperson : ViewModel() {

    val api = retrofit.create(Api::class.java)

    val listpersons = MutableStateFlow<List<Persons>>(listOf())

    init {
        getPersons()
    }

    fun getPersons() {
        viewModelScope.launch {
            listpersons.value =
                api.lastpersons(api_key = API_KEY ).results
        }
    }
}


class ViewModeldescfilm (savedStateHandle: SavedStateHandle): ViewModel() {

    private val filmId : String = checkNotNull(savedStateHandle["filmId"])
    val api = retrofit.create(Api::class.java)

    val listDetailFilm = MutableStateFlow<DescFILM>(DescFILM())

    init {
        getDescFilm()
    }
    fun getDescFilm(){
        viewModelScope.launch {
            listDetailFilm.value = api.detailfilm(filmId, api_key = API_KEY)
        }
    }
}


class ViewModeldescserie (savedStateHandle: SavedStateHandle): ViewModel() {

    private val serieId : String = checkNotNull(savedStateHandle["serieId"])
    val api = retrofit.create(Api::class.java)

    val listDetailserie = MutableStateFlow<DetailsSerie>(DetailsSerie())

    init {
        getDescserie()
    }
    fun getDescserie(){
        viewModelScope.launch {
            listDetailserie.value = api.detailserie(serieId, api_key = API_KEY)
        }
    }
}