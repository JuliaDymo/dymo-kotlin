package com.example.sociablenetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sociablenetwork.fragments.AddFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.sociablenetwork.fragments.HomeFragment
import com.example.sociablenetwork.fragments.LikeFragment
import com.example.sociablenetwork.fragments.SearchFragment
import com.example.sociablenetwork.fragments.PersonFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //comment
        setContentView(R.layout.activity_main)
        val homeFragment = HomeFragment()
        val likeFragment = LikeFragment()
        val searchFragment = SearchFragment()
        val addFragment = AddFragment()
        val personFragment = PersonFragment()
        makeCurrentFragment(homeFragment)
        navmenu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.like -> makeCurrentFragment(likeFragment)
                R.id.add -> makeCurrentFragment(addFragment)
                R.id.search -> makeCurrentFragment(searchFragment)
                R.id.person -> makeCurrentFragment(personFragment)
            }
            true

        }
    }

    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.wrapper, fragment)
            commit()
        }
    }
}