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
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiCalls {


    //SignUp
    @Headers("Content-Type: application/json")
    @POST("auth/signIn")
    suspend fun UserSignIn(
        @Body jsonObject: JsonObject?
    ): ResponseSignin


    //SignUp
    @Headers("Content-Type: application/json")
    @POST("auth/signUp")
    suspend fun UserSignUp(
        @Body jsonObject: JsonObject?
    ): ResponseSignup

    //upload image
    @Multipart
    // @Headers("Content-Type: application/json")
    @POST("auth/upload")
    suspend fun UploadFile(
        @Part postmedia: MultipartBody.Part
    ): ResponseUploadFile


    //get home data
    @POST("auth/getHomeData")
    suspend fun GetHomeData(
        @Header("token") token: String?,
        @Body jsonObject: JsonObject?
    ): ResponseHomeDM


    //see more recently sdded
    @POST("auth/seeMoreForRecentalyAdded")
    suspend fun SeeMoreRecentlyAdded(
        @Header("token") token: String?,
        @Body jsonObject: JsonObject?
    ): ResponseRecentSeeAll

    //see more nearby
    @POST("auth/seeMoreForNearBy")
    suspend fun SeeMoreNearby(
        @Header("token") token: String?,
        @Body jsonObject: JsonObject?
    ): ResponseNearbySeeAll


    //get property detials
    @POST("auth/getPropertyFromId")
    suspend fun GetPropertyDetail(
        @Header("token") token: String?,
        @Body jsonObject: JsonObject?
    ): ResponsePropertyById



    //add favourite
    @POST("auth/addFavouriteProperty")
    suspend fun Favourite(
        @Header("token") token: String?,
        @Body jsonObject: JsonObject?
    ): ResponseFavourite





    //get Amenities
    @GET("auth/getAmenitiesForUser")
    suspend fun getAmenitiesData(
        @Header("token")token: String
    ): ResponseGetAmenities


    //Add Property
    @POST("auth/addProperties")
    suspend fun AddProperty(
        @Header("token") token: String?
        , @Body jsonObject: AddPropertyDM?
    ): ResponseAddProperty


    //Find Properties
    @POST("auth/findProperties")
    suspend fun findProperties(
        @Body jsonObject: FindPropertiesDM?
    ): ResponseFindProperties


    //get regions
    @GET("auth/findAllRegions")
    suspend fun GetRegionsData(): ResponseGetRegions


    //get cities
    @GET("auth/findAllCities")
    suspend fun GetCitiesData(
        @Query("regionId") regionId : String
    ): ResponseGetCities


    //Get All Agents
    @GET("auth/getAllAgentsList")
    suspend fun getAllAgentsData(
        @Query("limit") limit : Int,
        @Query("skip") skip : Int
    ): ResponseGetAllAgents


    // save Search
    @POST("auth/addUserSearchData")
    suspend fun saveSearchData(
        @Header("token") token: String?,
        @Body jsonObject:SaveSearchInfo?
    ): ResponseSaveSearchData


    //get All saved searches List
    @GET("auth/getAllUserSearchHistory")
    suspend fun getAllSavedSearchList(
        @Header("token") token: String?,
        @Query("limit") limit : Int,
        @Query("skip") skip : Int
    ): ResponseSavedSearchList



    //get All saved searches List
    @GET("auth/getAllFavouritePropertyOfUser")
    suspend fun getAllFavPropList(
        @Header("token") token: String?,
        @Query("limit") limit : Int,
        @Query("skip") skip : Int
    ): ResponseGetAllFavProp





    //add favourite agents
    @POST("auth/addFavouriteAgent")
    suspend fun FavouriteAgent(
        @Header("token") token: String?,
        @Body jsonObject: JsonObject?
    ): ResponseFavourite
}