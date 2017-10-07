package com.example.admin.rxjavaexamples;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "rXJAVA";
    Button button, publish;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        publish = (Button) findViewById(R.id.publish);
        textView = (TextView) findViewById(R.id.text);
    }

    public void simpleActivity(View view) {
        startActivity(new Intent(this, SimpleActivity.class));
    }

    public void publishActivity(View view) {
        startActivity(new Intent(this, PublishActivity.class));
    }

    public void replayActivity(View view) {
        startActivity(new Intent(this, ReplayActivity.class));
    }

    public void behaviourActivity(View view) {
        startActivity(new Intent(this, BehaviourActivity.class));
    }

    public void asyncActivity(View view) {
        startActivity(new Intent(this, AsyncActivity.class));
    }

    public void singleActivity(View view) {
        startActivity(new Intent(this, SingleActivity.class));
    }

    public void deferActivity(View view) {
        startActivity(new Intent(this, DeferActivity.class));
    }
    public void bufferActivity(View view) {
        startActivity(new Intent(this, BufferActivity.class));
    }

    public void cancatActivity(View view) {
        startActivity(new Intent(this, CancatActivity.class));
    }
    public void debounceActivity(View view) {
        startActivity(new Intent(this, DebounceActivity.class));
    }
    public void delayActivity(View view) {
        startActivity(new Intent(this, DelayActivity.class));
    }
    public void disposableActivity(View view) {
        startActivity(new Intent(this, DisposableActivity.class));
    }
    public void distinctActivity(View view) {
        startActivity(new Intent(this, DistinctActivity.class));
    }
    public void filterActivity(View view) {
        startActivity(new Intent(this, FilterActivity.class));
    }

    public void flowableActivity(View view) {
        startActivity(new Intent(this, FlowableActivity.class));
    }

}
