package jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.DaggerViewModelComponent
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.model.DummyDataCreate
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.model.ShopData
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : BaseViewModel(application) {

    companion object {
        const val tag = "HomeViewModel"
    }

    var shopListLiveData: MutableLiveData<List<ShopData>> = MutableLiveData()

    fun loadShopData() {
        Log.d(tag, "loadShopData start!! :")
        viewModelScope.launch {
            var item  = DummyDataCreate()
            shopListLiveData.postValue(item.createData())
        }

    }

    class Factory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(
                application
            ) as T
        }
    }
}