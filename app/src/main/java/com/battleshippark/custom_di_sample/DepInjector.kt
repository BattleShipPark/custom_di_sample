package com.battleshippark.custom_di_sample

import android.content.Context
import androidx.fragment.app.Fragment

class DepInjector(private val fragment: Fragment) {
    private val context: Context
        get() = fragment.context!!

    fun navigator(): Lazy<Navigator> {
        return LazyFactory { Navigator(fragment) }
    }

    fun validator(): Lazy<Validator> {
        return LazyFactory { Validator() }
    }

    fun downloader(): Lazy<Downloader> {
        return LazyFactory {
            Downloader(
                context,
                navigator().value,
                validator().value
            )
        }
    }
}


fun Fragment.lazyDepInjector() = LazyFactory {
    DepInjector(this)
}

class LazyFactory<T>(private val factory: () -> T) : Lazy<T> {
    private var cached: T? = null

    override val value: T
        get() {
            if (cached == null) {
                cached = factory()
            }
            return cached!!
        }

    override fun isInitialized() = cached != null
}