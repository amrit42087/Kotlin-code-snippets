package com.thumbrealestate.di.modules.ViewModules

import androidx.lifecycle.ViewModel
import com.thumbrealestate.favorite.viewmodel.SavedPropVM
import com.thumbrealestate.favorite.viewmodel.SavedSearchFragVM
import com.thumbrealestate.home.viemodel.FindPropVM
import com.thumbrealestate.home.viemodel.HomeVM
import com.thumbrealestate.home.viemodel.PropertyPlotDetailVM
import com.thumbrealestate.home.viemodel.SeeMoreNearbyVM
import com.thumbrealestate.home.viemodel.SeeMoreRecentVM
import com.thumbrealestate.signin.viewmodel.AddCompantDetailsVM
import com.thumbrealestate.signin.viewmodel.SigninVM
import com.thumbrealestate.signin.viewmodel.VerifyVM
import com.thumbrealestate.signup.viewmodel.AgentSignupVM
import com.thumbrealestate.signup.viewmodel.UserSignupVM
import com.thumbrealestate.upload_listing.AddPropertyVM
import com.thumbrealestate.upload_listing.UploadAmenitiesVM
import com.thumbrealestate.util.ViewModelKey


import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {



//    @Binds
//    @IntoMap
//    @ViewModelKey(CreateAccountFragVM::class)
//     abstract fun bindCreateAccountViewModel(myCreateAccountFragVM: CreateAccountFragVM): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(SigninVM::class)
    internal abstract fun bindSigninVM(mySigninVM: SigninVM): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(VerifyVM::class)
    internal abstract fun bindVerifyVM(myVerifyVM: VerifyVM): ViewModel



    @Binds
    @IntoMap
    @ViewModelKey(AgentSignupVM::class)
    internal abstract fun bindAgentSignupVM(mySignupVM: AgentSignupVM): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(UserSignupVM::class)
    internal abstract fun bindUserSignupVM(myUserSignupVM: UserSignupVM): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(AddCompantDetailsVM::class)
    internal abstract fun bindAddCompantDetailsVM(myAddCompantDetailsVM: AddCompantDetailsVM): ViewModel



    @Binds
    @IntoMap
    @ViewModelKey(HomeVM::class)
    internal abstract fun bindHomeVM(myHomeVM: HomeVM): ViewModel



    @Binds
    @IntoMap
    @ViewModelKey(UploadAmenitiesVM::class)
    internal abstract fun bindUploadAmenitiesVM(myUploadAmenitiesVM:UploadAmenitiesVM): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(AddPropertyVM::class)
    internal abstract fun bindAddPropertyVM(myAddPropertyVM: AddPropertyVM): ViewModel




    @Binds
    @IntoMap
    @ViewModelKey(SeeMoreRecentVM::class)
    internal abstract fun bindSeeMoreRecentVM(mySeeMoreRecentVM: SeeMoreRecentVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SeeMoreNearbyVM::class)
    internal abstract fun bindSeeMoreNearbyVM(mySeeMoreNearbyVM: SeeMoreNearbyVM): ViewModel



    @Binds
    @IntoMap
    @ViewModelKey(PropertyPlotDetailVM::class)
    internal abstract fun bindPropertyPlotDetailVM(myPropertyPlotDetailVM: PropertyPlotDetailVM): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(FindPropVM::class)
    internal abstract fun bindFindPropVM(myFindPropVM: FindPropVM): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(SavedSearchFragVM::class)
    internal abstract fun bindSavedSearchVM(mySavedSearchFragVM: SavedSearchFragVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SavedPropVM::class)
    internal abstract fun bindSavedPropVM(mySavedPropVM: SavedPropVM): ViewModel
}
