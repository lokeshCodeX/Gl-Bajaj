package com.example.glbajaj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frameLayout: FrameLayout
    lateinit var toolbarLayout: Toolbar
    lateinit var navigationView: NavigationView

    var previousMenuItem:MenuItem?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        drawerLayout=findViewById(R.id.id_drawerLayout)
        coordinatorLayout=findViewById(R.id.id_coordinateLayout)
        frameLayout=findViewById(R.id.id_frameLayout)

        toolbarLayout=findViewById(R.id.id_toolbarLayout)
        navigationView=findViewById(R.id.id_navigationView)

        setUpToolber()
        openHomeFragment()


        val actionBarDrawerToggle=ActionBarDrawerToggle(this@MainActivity,drawerLayout,
            R.string.open_drawer,R.string.close_drawer)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            if(previousMenuItem!=null){
                previousMenuItem?.isCheckable=false
                it.isCheckable=true
                it.isChecked=true
                previousMenuItem=it
            }

            when(it.itemId){
                R.id.home -> {
                    supportFragmentManager.beginTransaction().
                    replace(R.id.id_frameLayout,HomeFragment())
                        .addToBackStack("Home")
                        .commit()

                    supportActionBar?.title="Home"
                    drawerLayout.closeDrawers()

                }

                R.id.campus_dacilities->{


                    supportFragmentManager.beginTransaction().
                    replace(R.id.id_frameLayout,CampusFragment())

                        .commit()
                    supportActionBar?.title="Campus/Facilities"

                    drawerLayout.closeDrawers()
                }
                R.id.academics ->{

                    supportFragmentManager.beginTransaction().
                    replace(R.id.id_frameLayout,AcedemicsFragment())

                        .commit()
                    supportActionBar?.title="Acedemics"

                    drawerLayout.closeDrawers()


                }


                R.id.course_admission->{


                    supportFragmentManager.beginTransaction().
                    replace(R.id.id_frameLayout,CourseFragment())

                        .commit()

                    supportActionBar?.title="Course/Adimission"
                    drawerLayout.closeDrawers()

                }

                R.id.training_placement ->{


                    supportFragmentManager.beginTransaction().
                    replace(R.id.id_frameLayout,TrainingFragment())

                        .commit()

                    supportActionBar?.title="Training/Placement"
                    drawerLayout.closeDrawers()

                }


                R.id.research_development ->{


                    supportFragmentManager.beginTransaction().
                    replace(R.id.id_frameLayout,ResearchFragment())

                        .commit()

                    supportActionBar?.title="Research"
                    drawerLayout.closeDrawers()


                }


                R.id.events ->{


                    supportFragmentManager.beginTransaction().
                    replace(R.id.id_frameLayout,EventsFragment())

                        .commit()
                    supportActionBar?.title="Events"

                    drawerLayout.closeDrawers()

                }


                R.id.about_us ->{

                    supportFragmentManager.beginTransaction().
                    replace(R.id.id_frameLayout,AboutUsFragment())

                        .commit()
                    supportActionBar?.title="AboutUs"

                    drawerLayout.closeDrawers()


                }


            }
            return@setNavigationItemSelectedListener true
        }

    }
    fun setUpToolber(){
        setSupportActionBar(toolbarLayout)

        supportActionBar?.title="Gl Bajaj"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }


    fun openHomeFragment(){

        val fragment=HomeFragment()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.id_frameLayout,fragment).commit()
        supportActionBar?.title="Home"
        navigationView?.setCheckedItem(R.id.home)
    }


    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.id_frameLayout)
        when (frag){
            !is HomeFragment->openHomeFragment()
            else-> super.onBackPressed()

        }
    }
}

