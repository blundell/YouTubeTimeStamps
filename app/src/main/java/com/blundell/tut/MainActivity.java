package com.blundell.tut;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listWidget = (ListView) findViewById(R.id.main_comments);
        CommentAdapter adapter = new CommentAdapter(getLayoutInflater(), new TimeStampFormatter());
        List<Comment> comments = MockBackend.loadComments();
        comments.addAll(MockBackend.loadIsoComments());
        adapter.updateWith(comments);
        listWidget.setAdapter(adapter);
    }

}
