package mangbaam.practice.parkingfree

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mangbaam.practice.parkingfree.databinding.ItemCampingBinding
import mangbaam.practice.parkingfree.dto.SimpleCamping

class CampingListAdapter: ListAdapter<SimpleCamping, CampingListAdapter.CampingViewHolder>(diffUtil) {

    class CampingViewHolder(binding: ItemCampingBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SimpleCamping) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampingViewHolder {
        return CampingViewHolder(ItemCampingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CampingViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<SimpleCamping>() {
            override fun areItemsTheSame(oldItem: SimpleCamping, newItem: SimpleCamping): Boolean {
                return oldItem.contentId == newItem.contentId
            }

            override fun areContentsTheSame(oldItem: SimpleCamping, newItem: SimpleCamping): Boolean {
                return oldItem == newItem
            }
        }
    }
}