package mangbaam.practice.parkingfree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import mangbaam.practice.parkingfree.databinding.ActivityMainBinding
import mangbaam.practice.parkingfree.util.Constants.KEY_CAMPING_DETAIL
import mangbaam.practice.parkingfree.util.ViewModelFactory
import mangbaam.practice.parkingfree.util.repeatOnStarted

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels { ViewModelFactory() }
    private val campingListAdapter by lazy { CampingListAdapter(viewModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.rvList.adapter = campingListAdapter

        viewModel.campingList.observe(this) { list ->
            campingListAdapter.submitList(list)
        }

        viewModel.count.observe(this) { count ->
            binding.count = count
            binding.executePendingBindings()
        }

        binding.etSearch.setOnEditorActionListener { _, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || keyEvent.action == KeyEvent.ACTION_DOWN) {
                viewModel.page.value = 1
                viewModel.searchMode.value = true
                viewModel.getSearchList()
            }
            true
        }

        viewModel.keyword.observe(this) {
            viewModel.searchMode.value = it.isBlank()
            viewModel.page.value = 1
        }

        repeatOnStarted {
            viewModel.selectedCamping.collect { event ->
                if (event is MainViewModel.Event.CampingClickEvent) {
                    val intent = Intent(this@MainActivity, DetailActivity::class.java)
                    intent.putExtra(KEY_CAMPING_DETAIL, event.camping)
                    startActivity(intent)
                }
            }
        }
    }
}