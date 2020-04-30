package com.example.quickgrocery.common.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.quickgrocery.R
import com.example.quickgrocery.common.fragment.BaseFragment
import com.example.quickgrocery.meals.activity.MealsActivity
import com.example.quickgrocery.settings.activity.SettingsActivity
import com.example.quickgrocery.shoppingList.activity.ShoppingListActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
abstract class BaseAuthenticatedActivity: BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    abstract fun getMenuItem():Int
    abstract fun getMainFragment(): BaseFragment<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nvMenu.setNavigationItemSelectedListener(this)
        initToolbar()
        initMainFragment()
    }

    private fun initMainFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.flContent, getMainFragment()).commit()
    }

    override fun onResume() {
        super.onResume()
        nvMenu.setCheckedItem(getMenuItem())
    }

    private fun initToolbar() {
        setSupportActionBar(ctAppToolbar.tbAppToolbar)
        ctAppToolbar.tbAppToolbar.setNavigationOnClickListener {
            dlMain.openDrawer(GravityCompat.START)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_meal_schedule -> {
                startActivity(MealsActivity.getBaseIntent(this))
                overridePendingTransition(0,0)
            }
            R.id.nav_shopping_list -> {
                startActivity(ShoppingListActivity.getBaseIntent(this))
                overridePendingTransition(0,0)
            }
            R.id.nav_settings -> {
                startActivity(SettingsActivity.getBaseIntent(this))
                overridePendingTransition(0,0)
            }
        }
        nvMenu.setCheckedItem(item.itemId)
        dlMain.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
        overridePendingTransition(0, 0)
    }
}