package com.learing.learntabl

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.learing.learntabl.home.FragmentOne

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val adapter = SampleAdapter(supportFragmentManager)

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_task,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_add) dialogAdd()
        return super.onOptionsItemSelected(item)

    }
    @SuppressLint("ResourceType")
    private fun dialogAdd(){
        val dialog= Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_add_task)

        val edContent: EditText = dialog.findViewById(R.id.et_content_task)
        val btnAdd : Button = dialog.findViewById(R.id.btn_add)
        val btnExit : Button = dialog.findViewById(R.id.btn_exit)
        btnExit.setOnClickListener {
            dialog.dismiss()
        }
        btnAdd.setOnClickListener {
            val content: String = edContent.text.toString()
            if(content == ""){
                Toast.makeText(this@MainActivity, "Vui long nhap lai", Toast.LENGTH_SHORT).show()
            }
            else{
                val bundle = Bundle()
                bundle.putString("content", content)
                val fragmentOne =  FragmentOne()

                fragmentOne.arguments = bundle
                fragmentOne.onRefresh()
                Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()

                dialog.dismiss()
            }
        }
        dialog.show()
    }
}
interface FragmentRefreshListener{
    fun onRefresh()
}
