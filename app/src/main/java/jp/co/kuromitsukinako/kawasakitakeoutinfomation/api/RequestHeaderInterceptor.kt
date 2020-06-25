package jp.co.kuromitsukinako.kawasakitakeoutinfomation.api
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException


class RequestHeaderInterceptor: Interceptor {
    private var context: Context? = null

    fun init(context: Context) {
        this.context = context
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {

        /*
        val request = chain.request().newBuilder()
            .header("Content-Type", "application/json")
            .build()
        val response = chain.proceed(request)
        val rawJson = response.body()!!.string()
        Logger.debug("raw json", String.format("raw JSON response is: %s", rawJson))*/

        val originalResponse = chain.proceed(chain.request())
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            val cookies =
                PreferenceManager.getDefaultSharedPreferences(context).getStringSet(
                    "PREF_COOKIES",
                    HashSet()
                ) as HashSet<String>?
            for (header in originalResponse.headers("Set-Cookie")) {
                cookies!!.add(header)
            }
            val memes =
                PreferenceManager.getDefaultSharedPreferences(context).edit()
            memes.putStringSet("PREF_COOKIES", cookies).apply()
            memes.commit()

        }

        /*
        return response.newBuilder().body(ResponseBody.create(response.body()!!.contentType(), rawJson)).build()
         */
        return originalResponse
    }


}