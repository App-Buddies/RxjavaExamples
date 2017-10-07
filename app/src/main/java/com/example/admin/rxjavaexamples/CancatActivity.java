package com.example.admin.rxjavaexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CancatActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        textView=findViewById(R.id.text);
        doSomeWork();
    }

    private void doSomeWork() {
        String arrayone[]={"one","two","three"};
        String arraytwo[]={"four","five","sex"};

        final io.reactivex.Observable<String> observableone= io.reactivex.Observable.fromArray(arrayone);
        final io.reactivex.Observable<String> observabletwo= io.reactivex.Observable.fromArray(arraytwo);
        io.reactivex.Observable.concat(observableone,observabletwo).subscribe(getObserver());

    }

    private Observer<? super String> getObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                textView.append(s);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
