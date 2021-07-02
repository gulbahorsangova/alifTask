package tj.androidtestapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tj.androidtestapp.R
import tj.androidtestapp.model.DataModel
import kotlinx.android.synthetic.main.item_data.view.*

class DataAdapter(private val context: Context, private val mDatas: List<DataModel>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.name.text = mDatas[position].name
        holder.endDate.text = mDatas[position].endDate
        Glide.with(context)
            .load(mDatas[position].icon)
            .centerCrop()
            .into(holder.imageIcon)
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    class DataViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
        val name: TextView = containerView.text_name;
        val endDate: TextView = containerView.text_end_date
        val imageIcon: ImageView = containerView.image_icon
    }
}
