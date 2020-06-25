package jp.co.kuromitsukinako.kawasakitakeoutinfomation.ui.shoplist

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Looper.getMainLooper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.R
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.adapter.UserListAdapter
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.databinding.FragmentGalleryBinding
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel.ShopListViewModel


class ShopListFragment : Fragment() {

    private lateinit var shopListViewModel: ShopListViewModel
    private lateinit var binding: FragmentGalleryBinding
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shopListViewModel =
            ViewModelProviders.of(this).get(ShopListViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)

        userListAdapter = UserListAdapter()
        userListAdapter.init(requireActivity())

        val separateLine = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.shopList.addItemDecoration(separateLine)

        binding.apply {
            shopList.adapter = userListAdapter
        }


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.apply {
            viewModel = shopListViewModel
        }
        loadUserList()
    }

    private fun loadUserList() {
        shopListViewModel.loadShopData()
        shopListViewModel.shopListLiveData.observe(viewLifecycleOwner, Observer { userList ->
            println("##loadUserList" + userList)
            userListAdapter.setUserList(userList)

        })
    }
}