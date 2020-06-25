package jp.co.kuromitsukinako.kawasakitakeoutinfomation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.R
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.databinding.FragmentHomeBinding
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel.HomeViewModel


class HomeFragment : Fragment() , OnMapReadyCallback {

    var mapView: MapView? = null
    var mMap: GoogleMap? = null

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        mapView = binding.mapView
        mapView?.onCreate(savedInstanceState);

        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(tag, "onActivityCreated: " )

        binding.apply {
            homeViewModel = homeViewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mapView?.apply {
            onCreate(savedInstanceState)
            getMapAsync(this@HomeFragment)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        createMapData()
    }

    fun createMapData(){

        homeViewModel.loadShopData()

        homeViewModel.shopListLiveData.observe(viewLifecycleOwner, Observer { shoplist ->
            println(shoplist)

            val bounds = LatLngBounds.builder()
                .include(LatLng(shoplist[0].lat, shoplist[0].lon)) // スタート地点
                .include(LatLng(shoplist[4].lat, shoplist[4].lon)) // ゴール地点
                .build()

            for (data in shoplist){
                val stLatLon = LatLng(data.lat, data.lon)
                val marker = mMap!!.addMarker(
                    MarkerOptions()
                        .title(data.shopname)
                        .draggable(false)
                        .snippet(data.Genre)
                        .position(stLatLon)
                )
                marker.showInfoWindow()
            }


            mMap?.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));

            mMap!!.setOnMarkerClickListener {
                Toast.makeText(
                    requireContext(),
                    "マーカーがタップされたよ:" + it.id,
                    Toast.LENGTH_LONG
                ).show()
                false
            }
        })
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }


}