package com.faob.motionlayoutcarousel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val layoutList = arrayListOf(R.layout.demo1, R.layout.demo2)
        val demoList = arrayListOf<DemoAdapter.Demo>()
        for (i in 0 until layoutList.size) {
            demoList.add(DemoAdapter.Demo("DEMO ${i + 1}", layoutList[i]))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        recyclerView.layoutManager =
            LinearLayoutManager(this)
        recyclerView.adapter = DemoAdapter(demoList)
    }

    fun start(layoutFileId: Int) {
        val intent = Intent(this, CarouselActivity::class.java).apply {
            putExtra("layout_file_id", layoutFileId)
        }
        startActivity(intent)
    }
}
