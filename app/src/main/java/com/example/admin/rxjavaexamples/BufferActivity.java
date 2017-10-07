package com.example.admin.rxjavaexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BufferActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        textView = findViewById(R.id.text);
        doSomeWork();
    }

    private void doSomeWork() {
        io.reactivex.Observable<List<String>> buffered = getObservable().buffer(3, 1);
        buffered.subscribe(getObserver());
    }

    private Observer<? super List<String>> getObserver() {
        return new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {
                for (String value : strings) {
                    textView.append(value);
                }

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    private io.reactivex.Observable<String> getObservable() {
        return io.reactivex.Observable.just("one", "two", "three", "four", "five");
    }
}
