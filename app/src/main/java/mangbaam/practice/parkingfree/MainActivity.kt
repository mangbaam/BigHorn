package mangbaam.practice.parkingfree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import mangbaam.practice.parkingfree.databinding.ActivityMainBinding
import mangbaam.practice.parkingfree.util.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val campingListAdapter by lazy { CampingListAdapter() }
    private val viewModel: MainViewModel by viewModels { ViewModelFactory() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.rvList.adapter = campingListAdapter
    }
}