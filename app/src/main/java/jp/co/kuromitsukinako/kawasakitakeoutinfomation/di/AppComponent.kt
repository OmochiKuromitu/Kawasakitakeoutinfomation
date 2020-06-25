package jp.co.kuromitsukinako.kawasakitakeoutinfomation.di
import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Component
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.Application
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {
    fun retrofit(): Retrofit
    fun okHttpClient(): OkHttpClient
    fun application(): Application
}