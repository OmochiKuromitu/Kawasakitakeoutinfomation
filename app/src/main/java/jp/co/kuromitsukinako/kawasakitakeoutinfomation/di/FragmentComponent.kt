package jp.co.kuromitsukinako.kawasakitakeoutinfomation.di

import dagger.Component
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.AppComponent
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.scope.ScopeFragment
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.ui.BaseFragment

@ScopeFragment
@Component(dependencies = [AppComponent::class])
interface FragmentComponent {
    fun inject(baseFragment: BaseFragment)
}