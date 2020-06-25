package jp.co.kuromitsukinako.kawasakitakeoutinfomation

import android.app.Application;
import android.content.Context
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.ApiModule
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.AppComponent
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.AppModule
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.di.DaggerAppComponent

class Application : Application() {

    companion object {
        lateinit var component: AppComponent private set
    }

    override fun onCreate() {
        super.onCreate()
        var context :Context = applicationContext
        var apiModule = ApiModule()
        apiModule.init(context)
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(apiModule)
            .build()
    }
}