package mangbaam.practice.parkingfree.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("glide")
fun ImageView.glide(src: String) {
    Glide.with(this)
        .load(src)
        .centerCrop()
        .into(this)
}