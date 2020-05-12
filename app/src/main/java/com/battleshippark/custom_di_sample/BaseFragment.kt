package com.battleshippark.custom_di_sample

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    protected val depInjector: DepInjector by lazyDepInjector()
}