package com.example.medicinedeliveryapp

import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.example.medicinedeliveryapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.parcelize.Parcelize

@Parcelize
class MainActivity : Parcelable, AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var homeFragment: HomeFragment
    lateinit var workFragment: WorkFragment
    lateinit var schoolFragment: SchoolFragment
    lateinit var timelineFragment: TimelineFragment
    lateinit var settingFragment: SettingFragment
    lateinit var logoutFragment: LogoutFragment
    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val toolBar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val navView = findViewById<NavigationView>(R.id.nav_view)


        val actionBar = supportActionBar
        actionBar?.title = "Medicine Delivery App"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle (
            this,
            drawerLayout,
            toolBar,
            (R.string.nav_app_bar_open_drawer_description),
            (R.string.nav_app_bar_navigate_up_description)
        ){

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        workFragment = WorkFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, workFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        when (menuItem.itemId){
            R.id.home -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.work -> {
                workFragment = WorkFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, workFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }R.id.school -> {
            schoolFragment = SchoolFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, schoolFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
            }
            R.id.timeline -> {
                timelineFragment = TimelineFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, timelineFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.setting -> {
                settingFragment = SettingFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, settingFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.logout -> {
                logoutFragment = LogoutFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, logoutFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }
}