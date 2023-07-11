package com.tah.housewarming.ui.dashboard

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tah.housewarming.R
import com.tah.housewarming.data.pinterest.Pin
import com.tah.housewarming.data.pinterest.PinInfo
import com.tah.housewarming.databinding.ItemUserPinBinding
import java.nio.charset.StandardCharsets

class UserPinsAdapter(private val data: List<Pin>) :
    RecyclerView.Adapter<UserPinsAdapter.ViewHolder>() {

    private var binding: ItemUserPinBinding? = null
    var onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemUserPinBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        binding?.let {
            return ViewHolder(it.root)
        } ?: throw IllegalStateException("Binding unavailable")
    }

    override fun getItemCount(): Int = data.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val card = binding?.card
        private val image = binding?.image
        private val text = binding?.description

        fun bind(item: Pin) {

            text?.let {
                it.text = item.board.name
                it.contentDescription = java.net.URLDecoder.decode(item.board.name, StandardCharsets.UTF_8.name())
            }

            image?.let {
                it.load(item.images.image564x.url) {
                    placeholder(R.drawable.ic_image)
                    error(R.drawable.ic_image_error)
                }
            }

            card?.let { _card ->
                _card.setOnClickListener {
                    onItemClick?.invoke(item.id)
                }
            }

        }
    }

}