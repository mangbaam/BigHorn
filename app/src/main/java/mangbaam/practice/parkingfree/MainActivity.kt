package mangbaam.practice.parkingfree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import mangbaam.practice.parkingfree.databinding.ActivityMainBinding
import mangbaam.practice.parkingfree.util.Constants.TAG
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

        viewModel.campingList.observe(this) { list ->
            val campingList = list.map { it.toSimple() }
            campingListAdapter.submitList(campingList)
        }

        viewModel.count.observe(this) { count ->
            binding.count = count
            binding.executePendingBindings()
        }

        binding.etSearch.setOnEditorActionListener { _, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || keyEvent.action == KeyEvent.ACTION_DOWN) {
                viewModel.getSearchList()
            }
            true
        }
    }
}