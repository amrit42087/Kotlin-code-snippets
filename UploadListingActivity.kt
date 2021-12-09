package com.thumbrealestate.listing.view

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thumbrealestate.R
import com.thumbrealestate.add_property.models.ListItem
import com.thumbrealestate.common.base.activity.BaseDataBindingActivity
import com.thumbrealestate.databinding.UploadListingActivityDataBinding
import com.thumbrealestate.di.DaggerProvider
import com.thumbrealestate.di.modules.ViewModules.ViewModelFactory
import com.thumbrealestate.home.model.RecentlyAddedItem
import com.thumbrealestate.listing.adapter.UploadListingAdapter
import com.thumbrealestate.listing.callbacks.UploadListingViewCallbacks
import com.thumbrealestate.listing.model.PojoModel
import com.thumbrealestate.network.Status
import com.thumbrealestate.signup.fragments.UserSignUpFragment
import com.thumbrealestate.signup.viewmodel.UserSignupVM
import com.thumbrealestate.upload_listing.UploadAmenitiesVM
import com.thumbrealestate.upload_listing.adapter.PropertyTypeAdapter
import com.thumbrealestate.util.CommonUtilities
import com.thumbrealestate.util.Constants
import javax.inject.Inject

class UploadListingActivity :
    BaseDataBindingActivity<UploadListingActivityDataBinding>(R.layout.activity_upload_listing),
    UploadListingViewCallbacks {

    @Inject
    lateinit var viewModFactory: ViewModelFactory
    lateinit var vm: UploadAmenitiesVM

    private val TAG = UploadListingActivity::class.java.simpleName
    var backToTheForm = false
    var listingAdapter: UploadListingAdapter? = null
    var list: MutableList<ListItem> = ArrayList()
    var selectedAmenitiesList: MutableList<ListItem> = ArrayList()
    var AmenitiesIdList: ArrayList<String?>?=null
    var AmenitiesNameList: ArrayList<String?>?=null


    override fun onDataBindingCreated() {
        binding.callback = this
        binding.lifecycleOwner = this
        AmenitiesIdList =
            intent.getStringArrayListExtra(Constants.AMENITIES_ID_LIST) as ArrayList<String?>?
        Log.d("getSelectedList",AmenitiesIdList.toString())
        var token =CommonUtilities.getString(this, Constants.ACCESS_TOKEN)!!
        vm.getAmenetiesList(token)
        setupObserver()
        initListingAdapter()
    }

    override fun injectDaggerComponent() {
        DaggerProvider.getAppComponent()?.inject(this)
        vm = ViewModelProvider(this, viewModFactory).get(UploadAmenitiesVM::class.java)
    }

    override fun doneClick() {
        AmenitiesIdList?.clear()
        for (i in 0 until selectedAmenitiesList.size) {
            if (selectedAmenitiesList.get(i).isSelected == true) {
                AmenitiesIdList?.add(selectedAmenitiesList.get(i).id.toString())
                AmenitiesNameList?.add(selectedAmenitiesList.get(i).amenityName.toString())
            }
        }
        backToTheForm = true
        onBackPressed()
    }

    override fun onBackPressed() {
        if (backToTheForm == true) {
            var intent = getIntent()
            intent.putStringArrayListExtra(Constants.AMENITIES_ID_LIST, AmenitiesIdList)
            intent.putStringArrayListExtra(Constants.AMENITIES_NAME_LIST, AmenitiesNameList)
            setResult(RESULT_OK, intent)
        }
        else{

            var intent = getIntent()
            intent.putStringArrayListExtra(Constants.AMENITIES_ID_LIST, AmenitiesIdList)
            setResult(RESULT_OK, intent)
        }
        super.onBackPressed()
    }


    override fun backClick() {
        onBackPressed()
    }

    override fun skipClick() {

    }

    fun initListingAdapter() {
        listingAdapter =
            UploadListingAdapter(this!!, list)
        binding?.rvListing?.apply {
            layoutManager = GridLayoutManager(
                context,
                3
            )
            adapter = listingAdapter
        }
    }

    private fun setupObserver() {

        vm.responseGetAmenities.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {

                    CommonUtilities.hideLoader()

                    Log.e("TAG", "SUCCESS")


                    if (it.data!!.statusCode == 200) {

                        if (it.data.data != null) {
                            list.addAll(it.data.data.list as Collection<ListItem>)
                            selectedAmenitiesList.addAll(it.data.data.list as Collection<ListItem>)
                            if (!AmenitiesIdList?.isEmpty()!!) {
                                for (i in 0 until AmenitiesIdList?.size!!) {
                                    for (j in 0 until list.size) {
                                        if (list.get(j).id == AmenitiesIdList?.get(i)) {
                                            list.get(j).isSelected = true
                                        }
                                    }
                                }
                                selectedAmenitiesList.clear()
                                selectedAmenitiesList = list
                            }
                            listingAdapter!!.notifyDataSetChanged()

                            Log.d(
                                "listingAdapter",
                                list.toString()
                            )


                        }
                    } else {
                        CommonUtilities.showToast(this, it.data.message.toString())
                    }


                }
                Status.LOADING -> {
                    Log.e("TAG", "LOADING")
                    //   CommonUtilities.showLoader(this!!)

                }
                Status.ERROR -> {

                    CommonUtilities.hideLoader()
                    Log.e("TAG", "ERROR ")

                    CommonUtilities.showToast(this, it?.message.toString())
                }
            }
        })

    }


}