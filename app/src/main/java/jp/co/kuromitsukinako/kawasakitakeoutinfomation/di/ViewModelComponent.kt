package jp.co.kuromitsukinako.kawasakitakeoutinfomation.di

import dagger.Component
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.scope.ScopeViewModel
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel.CityViewModel
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel.HomeViewModel
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.viewmodel.ShopListViewModel


@ScopeViewModel
@Component(dependencies = [AppComponent::class])
interface ViewModelComponent {
    fun inject(viewModel: HomeViewModel)
    fun inject(viewModel: ShopListViewModel)
    fun inject(viewModel: CityViewModel)

}