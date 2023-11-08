package com.tutorials.kodecampgoals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tutorials.kodecampgoals.data.getAllGoals
import com.tutorials.kodecampgoals.databinding.FragmentGoalsBinding


class GoalsFragment : Fragment() {
    private lateinit var binding: FragmentGoalsBinding
    private val goalAdapter by lazy { GoalAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            goalsRv.adapter = goalAdapter
            goalAdapter.submitList(getAllGoals())
            goalAdapter.adapterClickListener {
                val route = GoalsFragmentDirections.actionGoalsFragmentToGoalDetailsFragment(it)
                findNavController().navigate(route)
            }
        }
    }
}