package com.battleshippark.custom_di_sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainFragment : BaseFragment() {
    private val navigator: Navigator by depInjector.navigator()
    private val validator: Validator by depInjector.validator()
    private val downloader: Downloader by depInjector.downloader()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}
