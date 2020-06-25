package jp.co.kuromitsukinako.kawasakitakeoutinfomation.log

import android.util.Log
import androidx.databinding.library.BuildConfig


class Logger {

    companion object {

        /**
         * show Debug log.
         *
         * @param tag     タグ
         * @param message メッセージ
         */
        fun debug(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tag, String.format("[DEBUG](%d) %s", Thread.currentThread().id, message))
            }
        }

        /**
         * show Info log.
         *
         * @param tag     タグ
         * @param message メッセージ
         */
        fun info(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.i(tag, String.format("[INFO](%d) %s", Thread.currentThread().id, message))
            }
        }

        /**
         * show Error log.
         *
         * @param tag     タグ
         * @param message メッセージ
         */
        fun error(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, String.format("[ERROR](%d) %s", Thread.currentThread().id, message))
            }
        }

        /**
         * show Error log.
         *
         * @param tag     タグ
         * @param message メッセージ
         * @param error   例外
         */
        fun error(tag: String, message: String, error: Throwable) {
            if (BuildConfig.DEBUG) {
                Log.e(tag, String.format("[ERROR](%d) %s", Thread.currentThread().id, message), error)
            }
        }

        /**
         * show Warn log.
         *
         * @param tag     タグ
         * @param message メッセージ
         */
        fun warn(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.w(tag, String.format("[WARN](%d) %s", Thread.currentThread().id, message))
            }
        }

    }

}
