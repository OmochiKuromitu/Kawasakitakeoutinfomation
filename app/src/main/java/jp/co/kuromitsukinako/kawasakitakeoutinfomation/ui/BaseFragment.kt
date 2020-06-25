package jp.co.kuromitsukinako.kawasakitakeoutinfomation.ui

import androidx.fragment.app.Fragment
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.Application.Companion.component
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.DaggerFragmentComponent

open class BaseFragment : Fragment() {

    init {
        val fragmentComponent = DaggerFragmentComponent.builder()
            .appComponent(jp.co.kuromitsukinako.kawasakitakeoutinfomation.Application.component)
            .build()
        fragmentComponent.inject(this)
    }
}