package com.tutorials.kodecampgoals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.tutorials.kodecampgoals.GoalsViewModel.GoalEditMode
import com.tutorials.kodecampgoals.data.Goal
import com.tutorials.kodecampgoals.data.setPriorityColor
import com.tutorials.kodecampgoals.databinding.FragmentGoalDetailsBinding
import com.tutorials.kodecampgoals.databinding.PriorityLayoutBinding


class GoalDetailsFragment : Fragment() {
    private lateinit var binding: FragmentGoalDetailsBinding
    private val args by navArgs<GoalDetailsFragmentArgs>()
    private val viewModel by activityViewModels<GoalsViewModel>()
    private lateinit var mContainer: ViewGroup
    private val priorityLivedata = MutableLiveData<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mContainer = container!!
        binding = FragmentGoalDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goal = args.goal

        binding.apply {
            viewModel.updateEditMode(args.options)

            backBtn.setOnClickListener {
                findNavController().navigateUp()
            }

            deleteGoalBtn.setOnClickListener {
                viewModel.deleteUserGoal(goal!!)
                findNavController().popBackStack()
            }

            editBtn.setOnClickListener {
                viewModel.updateEditMode(GoalEditMode.EDIT)
            }

            priorityColor.setOnClickListener{
                showPriorityDialog()
            }

            viewModel.editMode.observe(viewLifecycleOwner){mode->
                editBtn.isVisible = mode == GoalEditMode.VIEW
                doneBtn.isVisible = mode == GoalEditMode.EDIT || mode == GoalEditMode.ADD
                deleteGoalBtn.isVisible = mode == GoalEditMode.EDIT

                titleText.isEnabled = mode == GoalEditMode.EDIT || mode == GoalEditMode.ADD
                descText.isEnabled = mode == GoalEditMode.EDIT || mode == GoalEditMode.ADD
                dateCreatedText.isEnabled = mode == GoalEditMode.EDIT || mode == GoalEditMode.ADD
                dateDueText.isEnabled = mode == GoalEditMode.EDIT || mode == GoalEditMode.ADD
                categoryText.isEnabled = mode == GoalEditMode.EDIT || mode == GoalEditMode.ADD
                priorityColor.isClickable = mode == GoalEditMode.EDIT || mode == GoalEditMode.ADD
                priorityColor.isEnabled = mode == GoalEditMode.EDIT || mode == GoalEditMode.ADD

                doneBtn.setOnClickListener {

                    val title = titleText.text.toString().trim()
                    val desc = descText.text.toString().trim()
                    val dateCreated = dateCreatedText.text.toString().trim()
                    val dateDue = dateDueText.text.toString().trim()
                    val category = categoryText.text.toString().trim()
                    val updateGoal = goal?.copy(
                        title = title,
                        desc = desc,
                        dateCreated = dateCreated,
                        dateDue = dateDue,
                        category = category,
                        priority = priorityLivedata.value ?: 1
                    )
                    val newGoal = Goal(
                        title = title,
                        desc = desc,
                        dateCreated = dateCreated,
                        dateDue = dateDue,
                        category = category,
                        priority = priorityLivedata.value ?: 1
                    )

                    if (mode == GoalEditMode.EDIT) {
                        viewModel.updateGoal(updateGoal!!)
                        viewModel.updateEditMode(GoalEditMode.ADD)
                    }else{
                        if (title.isEmpty()){
                            Toast.makeText(
                                requireContext(),
                                "Title can't be empty",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@setOnClickListener
                        }
                        viewModel.addGoal(newGoal)
                    }
                    findNavController().popBackStack()
                }

            }

            priorityLivedata.observe(viewLifecycleOwner){
                priorityColor.backgroundTintList = requireContext().setPriorityColor(it)
            }

            if (args.options == GoalEditMode.VIEW) {
                titleText.setText(goal?.title)
                descText.setText(goal?.desc)
                dateCreatedText.setText(goal?.dateCreated)
                dateDueText.setText(goal?.dateDue)
                categoryText.setText(goal?.category)
                priorityLivedata.value = goal?.priority
                priorityColor.backgroundTintList = requireContext().setPriorityColor(goal?.priority!!)
            }

        }

    }


    private fun showPriorityDialog() {
        val dialogView = LayoutInflater.from(requireContext())
            .inflate(R.layout.priority_layout, mContainer, false)
        val binding = PriorityLayoutBinding.bind(dialogView)
        val newDialog = MaterialAlertDialogBuilder(requireContext()).create()
        if (dialogView.parent != null) {
            (dialogView.parent as ViewGroup).removeView(binding.root)
        }
        newDialog.setView(binding.root)
        newDialog.show()

        binding.apply {
            doneBtn.setOnClickListener {
                newDialog.dismiss()
            }
            priorityGroup.setOnCheckedChangeListener { radioGroup, i ->
                when(radioGroup.checkedRadioButtonId){
                    R.id.low_prioriy->{
                        priorityLivedata.value = 1
                    }
                    R.id.medium_priority->{
                        priorityLivedata.value = 2
                    }
                    R.id.high_priority->{
                        priorityLivedata.value = 3
                    }
                }
            }
        }
    }

}