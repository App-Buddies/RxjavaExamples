package com.example.admin.rxjavaexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

public class FlowableActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        textView=findViewById(R.id.text);
        doSomeWork();
    }

    private void doSomeWork() {
        Flowable<Integer> integerFlowable= Flowable.just(1,2,3,4);
        integerFlowable.reduce(50,new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return integer+integer2;
            }
        }).subscribe(getObserver());

    }

    private SingleObserver<? super Integer> getObserver() {
        return new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Integer integer) {
                textView.append(String.valueOf(integer));

            }

            @Override
            public void onError(Throwable e) {

            }
        };
    }

}
