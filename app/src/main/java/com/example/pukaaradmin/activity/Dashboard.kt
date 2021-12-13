package com.example.pukaaradmin.activity

import android.content.Intent
import com.example.pukaaradmin.Fragments.*
import com.example.pukaaradmin.Genral_Screens_Fragments.Setting_Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.example.pukaaradmin.R
import com.example.pukaaradmin.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {

    lateinit var dashboardBinding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashboardBinding.root)

// Bydefualt Fragment
        supportFragmentManager.beginTransaction().replace(R.id.container, Dashboard_Fragment())
            .commit()
        // DrawerNavigation CliclListner
        dashboardBinding.dehaze.setOnClickListener {
            dashboardBinding.drawerLayout.openDrawer(GravityCompat.START)
        }

        //Bottom Navigation item on click Listner

dashboardBinding.bottomNavigation1.setOnNavigationItemSelectedListener{
    when(it.itemId){
        R.id.bottom_home -> {
         val   dashboardFragment = Dashboard_Fragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, dashboardFragment).commit()
        }

        R.id.nav_room -> {
            val   userFragment = User_Fragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, userFragment).commit()

        }

        R.id.nav_therapist -> {
            val   therapistListFragment = Therapist_List_Fragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, therapistListFragment).commit()

        }


        R.id.bottom_settting -> {
            val   settingFragment = Setting_Fragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, settingFragment).commit()

        }
    }
    return@setOnNavigationItemSelectedListener true
}

        dashboardBinding.navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.left_session_summary ->{
                    val sessionSummary = Session_Summary()
                    supportFragmentManager.beginTransaction().replace(R.id.container, sessionSummary).commit()
                }
                R.id.left_setting ->{
                    val setting = Setting_Fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, setting).commit()
                }
                R.id.left_donated_sessions ->{
                    val donated_sessions = Donated_Sessions()
                    supportFragmentManager.beginTransaction().replace(R.id.container, donated_sessions).commit()
                }


                R.id.Logout ->{
                    val intent = Intent(applicationContext , Login::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                    finish()
                }
                R.id.left_special_offers ->{
                    val intent = Intent(applicationContext , Speacial_Offer_create::class.java)
                    startActivity(intent)

                }

            }
            dashboardBinding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }
}
