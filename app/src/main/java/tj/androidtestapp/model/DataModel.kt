package tj.androidtestapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("endDate")
    @Expose
    val endDate: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("icon")
    @Expose
    val icon: String
)