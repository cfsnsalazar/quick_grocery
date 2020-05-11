package com.example.quickgrocery.settings.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatDelegate
import com.example.quickgrocery.R
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.fragment.BaseFragment
import com.example.quickgrocery.settings.viewModel.SettingsFragmentViewModel
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class SettingsFragment : BaseFragment() {
    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    interface FragmentListener {
        fun onThemeChanged(theme: Theme)
    }

    lateinit var fragmentListener: FragmentListener

    override val viewModel: SettingsFragmentViewModel by lazy {
        QuickGroceryViewModelProvider(activity!!).get(SettingsFragmentViewModel::class.java)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as FragmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        val theme = Theme.fromAppCompatDelegate(
            appCompatDelegateValue = AppCompatDelegate.getDefaultNightMode()
        )
        val spinnerAdapter = ArrayAdapter.createFromResource(
            spDarkMode.context,
            R.array.Themes,
            R.layout.spinner_item_dark_mode
        )
        spDarkMode.adapter = spinnerAdapter
        spDarkMode.setSelection(theme.ordinal)
        spDarkMode.onItemSelectedListener = selectedListener
    }

    private val selectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) = Unit

        override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, resource: Long) {
            fragmentListener.onThemeChanged(Theme.values()[position])
        }
    }
}
