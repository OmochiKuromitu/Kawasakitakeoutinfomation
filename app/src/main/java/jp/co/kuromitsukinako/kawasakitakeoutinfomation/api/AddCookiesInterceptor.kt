package jp.co.kuromitsukinako.kawasakitakeoutinfomation.api

import android.content.Context
import android.preference.PreferenceManager
import jp.co.kuromitsukinako.kawasakitakeoutinfomation.log.Logger
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class AddCookiesInterceptor : Interceptor {

    companion object {
        const val tag = "AddCookiesInterceptor"
        const val PREF_COOKIES = "PREF_COOKIES"
    }

    private var context: Context? = null

    fun init(context: Context) {
        this.context = context
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        val builder: Request.Builder = chain.request().newBuilder()
        val preferences =
            PreferenceManager.getDefaultSharedPreferences(context)
                .getStringSet(PREF_COOKIES, HashSet()) as HashSet<String>?

        // Use the following if you need everything in one line.
        // Some APIs die if you do it differently.
        /*String cookiestring = "";
        for (String cookie : preferences) {
            String[] parser = cookie.split(";");
            cookiestring = cookiestring + parser[0] + "; ";
        }
        builder.addHeader("Cookie", cookiestring);
        */for (cookie in preferences!!) {
            builder.addHeader("Cookie", cookie)
            Logger.debug(tag, "cookie:" + cookie)
        }
        return chain.proceed(builder.build())
    }
}