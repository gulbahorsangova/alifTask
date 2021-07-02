package tj.androidtestapp.networking

import retrofit2.Call
import retrofit2.http.GET
import tj.androidtestapp.model.TotalDataModel

interface ApiService {
    @GET("service/v2/upcomingGuides/")
    fun fetchData(): Call<TotalDataModel>
}