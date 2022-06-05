package mangbaam.practice.parkingfree

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mangbaam.practice.parkingfree.databinding.ActivityDetailBinding
import mangbaam.practice.parkingfree.dto.Camping
import mangbaam.practice.parkingfree.util.Constants.KEY_CAMPING_DETAIL

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        binding.lifecycleOwner = this
        val camping = intent.getSerializableExtra(KEY_CAMPING_DETAIL) as Camping
        binding.data = camping

        binding.tvReserveUrl.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse(camping.reservation))
        }
    }
}