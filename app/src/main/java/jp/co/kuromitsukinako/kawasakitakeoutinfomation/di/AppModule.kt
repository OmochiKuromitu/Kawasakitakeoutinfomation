package jp.co.kuromitsukinako.kawasakitakeoutinfomation.di

import dagger.Module
import dagger.Provides
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.Application
import javax.inject.Singleton

@Module
class AppModule(app: Application) {

    val app: Application = app

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }
}