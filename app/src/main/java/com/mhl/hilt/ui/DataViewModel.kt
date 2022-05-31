package com.mhl.hilt.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhl.hilt.dataclasses.profession.Profession
import com.mhl.hilt.repository.local.LocalDataRepository
import com.mhl.hilt.repository.remote.RemoteDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val remoteRepository: RemoteDataRepository,
    private val localRepository: LocalDataRepository
) :
    ViewModel() {

    private val _remoteData = MutableLiveData<Profession>()
    private val _localData = MutableLiveData<Profession>()
    val remoteData = _remoteData
    val localData = _localData

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            remoteRepository.getProfession("AT").collect {
                _remoteData.value = it
            }
            localRepository.getProfession(remoteData.value!!.code).collect {
                _localData.value = it
            }

            if (_localData.value != remoteData.value){
                Log.d("LOCAL", _localData.value.toString())
                Log.e("REMOTE", remoteData.value.toString())

                localRepository.putProfession(remoteData.value!!)
            }
        }
    }

}