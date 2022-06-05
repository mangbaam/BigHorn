package mangbaam.practice.parkingfree

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mangbaam.practice.parkingfree.databinding.ItemCampingBinding
import mangbaam.practice.parkingfree.dto.Camping

class CampingListAdapter(private val viewModel: MainViewModel) : ListAdapter<Camping, CampingListAdapter.CampingViewHolder>(diffUtil) {

    inner class CampingViewHolder(private val binding: ItemCampingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Camping) {
            binding.data = data
            binding.vm = viewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampingViewHolder {
        return CampingViewHolder(
            ItemCampingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CampingViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Camping>() {
            override fun areItemsTheSame(oldItem: Camping, newItem: Camping): Boolean {
                return oldItem.contentId == newItem.contentId
            }

            override fun areContentsTheSame(
                oldItem: Camping,
                newItem: Camping
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}