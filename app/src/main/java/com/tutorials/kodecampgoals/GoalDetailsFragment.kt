package com.tutorials.kodecampgoals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tutorials.kodecampgoals.data.setPriorityColor
import com.tutorials.kodecampgoals.databinding.FragmentGoalDetailsBinding


class GoalDetailsFragment : Fragment() {
    private lateinit var binding: FragmentGoalDetailsBinding
    private val args by navArgs<GoalDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGoalDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goal = args.goal

        binding.apply {
            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }
            titleText.text = goal.title
            descText.text = goal.desc
            dateCreatedText.text = goal.dateCreated
            dateDueText.text = goal.dateDue
            categoryText.text = goal.category
            priorityColor.backgroundTintList = requireContext().setPriorityColor(goal.priority)
        }

    }
}