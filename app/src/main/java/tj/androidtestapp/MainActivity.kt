package tj.androidtestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import tj.androidtestapp.adapter.DataAdapter
import tj.androidtestapp.model.DataModel
import tj.androidtestapp.model.TotalDataModel
import tj.androidtestapp.networking.ApiClient
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: DataAdapter
    private var mDatas: MutableList<DataModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_datas?.layoutManager = LinearLayoutManager(this)

        mAdapter = DataAdapter(this, mDatas)
        rv_datas?.adapter = mAdapter

        fetchDatas()

    }

    private fun fetchDatas() {
        val call = ApiClient.getApiService().fetchData()
        call.enqueue(object : retrofit2.Callback<TotalDataModel> {
            override fun onResponse(
                call: Call<TotalDataModel>,
                response: Response<TotalDataModel>
            ) {
                val datas = response.body()
                if (datas != null) {
                    mDatas.addAll(datas.data)
                    mAdapter.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<TotalDataModel>, t: Throwable) {}

        })
    }
}