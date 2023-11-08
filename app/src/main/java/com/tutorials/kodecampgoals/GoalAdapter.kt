package com.tutorials.kodecampgoals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tutorials.kodecampgoals.data.Goal
import com.tutorials.kodecampgoals.data.setPriorityColor
import com.tutorials.kodecampgoals.databinding.GoalViewHolderBinding

class GoalAdapter : ListAdapter<Goal, GoalAdapter.ViewHolder>(diffObject) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = GoalViewHolderBinding.bind(view)
        fun bind(goal: Goal) {
            binding.apply {
                titleText.text = goal.title
                descText.text = goal.desc
                dateDueText.text = goal.dateDue
                priorityColor.backgroundTintList = itemView.context.setPriorityColor(goal.priority)
                root.setOnClickListener {
                    listener?.let {
                        it(goal)
                    }
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.goal_view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = getItem(position)
        if (pos != null)
            holder.bind(pos)

    }

    companion object {
        val diffObject = object : DiffUtil.ItemCallback<Goal>() {
            override fun areItemsTheSame(oldItem: Goal, newItem: Goal): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Goal, newItem: Goal): Boolean {
                return oldItem.title == newItem.title && oldItem.id == newItem.id
            }
        }
    }

    private var listener: ((Goal) -> Unit)? = null

    fun adapterClickListener(listener: (Goal) -> Unit) {
        this.listener = listener
    }


}
