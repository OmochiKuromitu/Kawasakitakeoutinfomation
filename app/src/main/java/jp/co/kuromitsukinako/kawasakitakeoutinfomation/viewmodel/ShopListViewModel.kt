package jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.model.DummyDataCreate
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.model.ShopData
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

class ShopListViewModel : ViewModel() {

    var shopListLiveData: MutableLiveData<List<ShopData>> = MutableLiveData()

    fun loadShopData() {
        Log.d(HomeViewModel.tag, "loadShopData start!! :")
        viewModelScope.launch {
            var item = DummyDataCreate()
            shopListLiveData.postValue(item.createData())
        }

    }
}