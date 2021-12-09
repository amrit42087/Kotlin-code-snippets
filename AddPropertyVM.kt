package com.thumbrealestate.upload_listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.thumbrealestate.add_property.models.ResponseGetAmenities
import com.thumbrealestate.home.model.ResponseHomeDM
import com.thumbrealestate.network.AddPropertyData
import com.thumbrealestate.network.GetAmenitiesList
import com.thumbrealestate.network.Result
import com.thumbrealestate.upload_listing.model.AddPropertyDM
import com.thumbrealestate.upload_listing.model.ResponseAddProperty
import com.tribu.errorProvider.ErrorProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPropertyVM  @Inject constructor(
    private val data: AddPropertyData,
    private val errorProvider: ErrorProvider
) : ViewModel() {

    private var _responseAddProperty = MutableLiveData<Result<ResponseAddProperty>>()
    val responseAddProperty: LiveData<Result<ResponseAddProperty>>
        get() = _responseAddProperty




    fun addPropertyApiFunc(
        token: String,  jsonObject: AddPropertyDM?
    ) {
        viewModelScope.launch {
            try {
                _responseAddProperty.postValue(Result.loading())
                val response = data.AddPropertyProcess(token,jsonObject)
                _responseAddProperty.postValue(Result.success(response))
            } catch (exception: Exception) {
                _responseAddProperty.postValue(
                    Result.error(
                        errorProvider.getErrorMessage(
                            exception
                        )
                    )
                )
            }
        }
    }
}
