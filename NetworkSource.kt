package com.thumbrealestate.network


import com.google.gson.JsonObject
import com.thumbrealestate.add_property.models.ResponseGetAmenities
import com.thumbrealestate.favorite.model.ResponseGetAllFavProp
import com.thumbrealestate.favorite.model.ResponseSaveSearchData
import com.thumbrealestate.favorite.model.ResponseSavedSearchList
import com.thumbrealestate.favorite.model.SaveSearchInfo
import com.thumbrealestate.home.model.*
import com.thumbrealestate.search.model.ResponseGetAllAgents
import com.thumbrealestate.signin.model.ResponseSignin
import com.thumbrealestate.signin.model.ResponseUploadFile
import com.thumbrealestate.signup.model.ResponseGetCities
import com.thumbrealestate.signup.model.ResponseGetRegions
import com.thumbrealestate.signup.model.ResponseSignup
import com.thumbrealestate.upload_listing.model.AddPropertyDM
import com.thumbrealestate.upload_listing.model.ResponseAddProperty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Multipart
import javax.inject.Inject


class SigninData @Inject constructor(private val api: ApiCalls) {


    suspend fun UploadFileProcess(
        file: MultipartBody.Part
    ):
            ResponseUploadFile? = withContext(Dispatchers.IO) {
        val data =
            api.UploadFile(file)
        data
    }


}


class SignUpData @Inject constructor(private val api: ApiCalls) {


    suspend fun UploadFileProcess(
        file: MultipartBody.Part
    ):
            ResponseUploadFile? = withContext(Dispatchers.IO) {
        val data =
            api.UploadFile(file)
        data
    }

    suspend fun GetRegionProcess(): ResponseGetRegions? = withContext(Dispatchers.IO) {
        val data = api.GetRegionsData()
        data
    }


    suspend fun GetCityProcess(
        regionId: String
    ):
            ResponseGetCities? = withContext(Dispatchers.IO) {
        val data =
            api.GetCitiesData(regionId)
        data
    }

}


class VerifyData @Inject constructor(private val api: ApiCalls) {


    suspend fun SigninProcess(
        jsonObject: JsonObject?

    ):
            ResponseSignin? = withContext(Dispatchers.IO) {
        val data =
            api.UserSignIn(
                jsonObject
            )
        data
    }


    suspend fun SignUpProcess(
        jsonObject: JsonObject?

    ):
            ResponseSignup? = withContext(Dispatchers.IO) {
        val data =
            api.UserSignUp(jsonObject)
        data
    }


}


class HomeData @Inject constructor(private val api: ApiCalls) {


    suspend fun GetHomeDataProcess(
        token: String?,
        jsonObject: JsonObject?

    ):
            ResponseHomeDM? = withContext(Dispatchers.IO) {
        val data =
            api.GetHomeData(
                token, jsonObject
            )
        data
    }

    suspend fun Favourite(
        token: String?,
        jsonObject: JsonObject?

    ):
            ResponseFavourite? = withContext(Dispatchers.IO) {
        val data =
            api.Favourite(
                token, jsonObject
            )
        data
    }


}


class AddCompanyDetailsData @Inject constructor(private val api: ApiCalls) {

    suspend fun UploadFileProcess(
        file: MultipartBody.Part
    ):
            ResponseUploadFile? = withContext(Dispatchers.IO) {
        val data =
            api.UploadFile(file)
        data
    }

    suspend fun SignUpProcess(
        jsonObject: JsonObject?

    ):
            ResponseSignup? = withContext(Dispatchers.IO) {
        val data =
            api.UserSignUp(jsonObject)
        data
    }


    /*
    *  added by navjot
    * */

    suspend fun GetRegionProcess(): ResponseGetRegions? = withContext(Dispatchers.IO) {
        val data = api.GetRegionsData()
        data
    }


    suspend fun GetCityProcess(
        regionId: String
    ):
            ResponseGetCities? = withContext(Dispatchers.IO) {
        val data =
            api.GetCitiesData(regionId)
        data
    }

    /*----*/


}


class GetAmenitiesList @Inject constructor(private val api: ApiCalls) {

    suspend fun GetAmenitiesProcess(
        token: String?
    ):
            ResponseGetAmenities? = withContext(Dispatchers.IO) {
        val data = token?.let { api.getAmenitiesData(it) }
        data
    }
}


class AddPropertyData @Inject constructor(private val api: ApiCalls) {

    suspend fun AddPropertyProcess(
        token: String?, jsonObject: AddPropertyDM?
    ):
            ResponseAddProperty? = withContext(Dispatchers.IO) {
        val data = api.AddProperty(token, jsonObject)
        data
    }
}

class FindPropertiesData @Inject constructor(private val api: ApiCalls) {


    suspend fun Favourite(
        token: String?,
        jsonObject: JsonObject?

    ):
            ResponseFavourite? = withContext(Dispatchers.IO) {
        val data =
            api.Favourite(
                token, jsonObject
            )
        data
    }

    suspend fun FindPropertiesProcess(
        jsonObject: FindPropertiesDM?
    ):
            ResponseFindProperties? = withContext(Dispatchers.IO) {
        val data =
            api.findProperties(jsonObject)
        data
    }


    suspend fun saveSearchProcess(
        token: String?, jsonObject: SaveSearchInfo?
    ):
            ResponseSaveSearchData? = withContext(Dispatchers.IO) {
        val data =
            api.saveSearchData(token, jsonObject)
        data
    }


    suspend fun getAllAgentsListProcess(
        limit: Int, skip: Int
    ):
            ResponseGetAllAgents? = withContext(Dispatchers.IO) {
        val data =
            api.getAllAgentsData(limit, skip)
        data
    }


    suspend fun GetRegionProcess(): ResponseGetRegions? = withContext(Dispatchers.IO) {
        val data = api.GetRegionsData()
        data
    }


    suspend fun GetCityProcess(
        regionId: String
    ):
            ResponseGetCities? = withContext(Dispatchers.IO) {
        val data =
            api.GetCitiesData(regionId)
        data
    }


}
