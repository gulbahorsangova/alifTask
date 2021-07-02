package tj.androidtestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TotalDataModel(
    @SerializedName("data")
    @Expose
    val data: List<DataModel>,
    @SerializedName("total")
    @Expose
    val total: String
)