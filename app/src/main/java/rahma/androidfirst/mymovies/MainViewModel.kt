package rahma.androidfirst.mymovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val API_KEY = "096dad21e614ff913e251c3c4ec79a90"
val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

class MainViewModel : ViewModel() {
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




}

class ViewModelserie : ViewModel() {
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

class ViewModelperson : ViewModel() {
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

class ViewModelPlaylist : ViewModel() {

    val listPlaylist = MutableStateFlow<List<Playlist>>(listOf())

    init {
        getPlaylist()
    }

    fun getPlaylist():Playlist {
        val moshi= Moshi.Builder().build()
        return moshi.adapter(Playlist::class.java).fromJson(playlistjson)!!
    }


}




class ViewModeldescfilm(savedStateHandle: SavedStateHandle) : ViewModel() {
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

class ViewModeldescserie(savedStateHandle: SavedStateHandle) : ViewModel() {
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