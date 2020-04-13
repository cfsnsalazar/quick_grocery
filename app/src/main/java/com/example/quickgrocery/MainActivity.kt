package com.example.quickgrocery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    nvMenu.setNavigationItemSelectedListener(this)
    initToolbar()
  }

  private fun initToolbar() {
    setSupportActionBar(ctAppToolbar.tbAppToolbar)
    ctAppToolbar.tbAppToolbar.setNavigationOnClickListener {
      dlMain.openDrawer(GravityCompat.START)
      }
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when(item.itemId){
      R.id.nav_meal_schedule -> {

      }
      R.id.nav_shopping_list -> {

      }
    }

    nvMenu.setCheckedItem(item.itemId)
    dlMain.closeDrawer(GravityCompat.START)
    return true
  }

}
