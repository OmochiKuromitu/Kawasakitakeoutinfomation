package jp.co.kuromitsukinako.kawasakitakeoutinfomation.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.R
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.databinding.FragmentGalleryBinding
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.databinding.FragmentSlideshowBinding
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel.CityViewModel

class CityFragment : Fragment() {

    private lateinit var cityViewModel: CityViewModel
    private lateinit var binding:FragmentSlideshowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cityViewModel =
            ViewModelProviders.of(this).get(CityViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_slideshow, container, false)


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.apply {
            viewModel = cityViewModel
        }
        binding.webview.loadUrl("http://www.city.kawasaki.jp/280/page/0000116918.html")

    }
}