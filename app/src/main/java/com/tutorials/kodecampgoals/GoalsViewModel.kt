package com.tutorials.kodecampgoals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tutorials.kodecampgoals.data.Goal
import com.tutorials.kodecampgoals.data.addNewGoal
import com.tutorials.kodecampgoals.data.deleteGoal
import com.tutorials.kodecampgoals.data.getAllGoals
import com.tutorials.kodecampgoals.data.updateGoalList

class GoalsViewModel:ViewModel(){

    private val _userGoals = MutableLiveData<List<Goal>>()
    val userGoals:LiveData<List<Goal>> = _userGoals

    private val _editMode = MutableLiveData<GoalEditMode>()
    val editMode: LiveData<GoalEditMode> = _editMode

    private val _priority = MutableLiveData<GoalEditMode>()
    val priority: LiveData<GoalEditMode> = _priority

    init {
        loadAllUserGoals()
    }

    private fun loadAllUserGoals(){
        _userGoals.value = getAllGoals()
    }

    fun updateGoal(goal: Goal){
       updateGoalList(goal)
        loadAllUserGoals()
    }

    fun updateEditMode(mode: GoalEditMode){
        _editMode.value = mode
    }

    fun addGoal(goal:Goal){
        addNewGoal(goal)
        loadAllUserGoals()
    }

    fun deleteUserGoal(goal: Goal){
        deleteGoal(goal)
        loadAllUserGoals()
    }

    enum class GoalEditMode{
        ADD,
        VIEW,
        EDIT
    }


}