package com.blundell.tut

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = CommentAdapter(layoutInflater, TimeStampFormatter())
        val comments: ArrayList<Comment> = MockBackend.loadComments()
        comments.addAll(MockBackend.loadIsoComments())
        adapter.updateWith(comments)
        mainComments.adapter = adapter
    }

}
