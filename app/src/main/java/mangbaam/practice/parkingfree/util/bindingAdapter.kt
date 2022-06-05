package mangbaam.practice.parkingfree.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import mangbaam.practice.parkingfree.R

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(url)
        .error(R.drawable.image_null)
        .centerCrop()
        .into(imageView)
}

@BindingAdapter("simpleAddress")
fun applySimpleAddress(view: TextView, addr: String) {
    view.text = addr
}

@BindingAdapter("address1", "address2")
fun applyAddress(view: TextView, addr1: String?, addr2: String?) {
    val a1 = addr1 ?: ""
    val a2 = addr2 ?: ""
    if (a1.isEmpty() && a2.isEmpty()) view.visibility = View.GONE
    else view.text = a1 + a2
}