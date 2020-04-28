package com.example.quickgrocery.settings.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.example.quickgrocery.R
import com.example.quickgrocery.common.PREFERENCE_KEY_THEME
import com.example.quickgrocery.common.Theme
import com.example.quickgrocery.common.application.QuickGroceryApplication
import com.example.quickgrocery.common.di.QuickGroceryViewModelProvider
import com.example.quickgrocery.common.di.SHARED_PREFERENCES_NAME
import com.example.quickgrocery.common.fragment.BaseFragment
import com.example.quickgrocery.settings.viewModel.SettingsFragmentViewModel
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@FlowPreview
@ExperimentalCoroutinesApi
class SettingsFragment : BaseFragment<SettingsFragmentViewModel>() {
    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    interface FragmentListener {
        fun onThemeChanged(theme: Theme)
    }

    lateinit var fragmentListener: FragmentListener

    override fun provideViewModel(): SettingsFragmentViewModel? {
        activity ?: return null
        return QuickGroceryViewModelProvider(activity!!).get(SettingsFragmentViewModel::class.java)
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
        return inflater.inflate(R.layout.fragment_settings, null);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        val sharedPreferences = activity?.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        val themeName = sharedPreferences?.getString(
            PREFERENCE_KEY_THEME,
            null
        ) ?: Theme.LIGHT.name
        swDarkMode.isChecked = themeName == Theme.DARK.name
        rlDarkMode.setOnClickListener {
            swDarkMode.isChecked = !swDarkMode.isChecked
        }
        swDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                fragmentListener.onThemeChanged(Theme.DARK)
            }else{
                fragmentListener.onThemeChanged(Theme.LIGHT)
            }
        }
    }
}