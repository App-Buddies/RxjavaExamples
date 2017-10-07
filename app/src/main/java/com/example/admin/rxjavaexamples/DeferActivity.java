package com.example.admin.rxjavaexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class DeferActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        textView=findViewById(R.id.text);
        doSomeWork();
    }

    private void doSomeWork() {
        Car c=new Car();
        Observable<String> brandObservable=c.getObservab();
        c.setBrand("BMW");
        brandObservable.subscribe(getObserver());

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

    public class Car{
        String brand="tata";

        public void setBrand(String brand){
            this.brand=brand;
        }

        Observable<String> getObservab(){
            return Observable.defer(new Callable<ObservableSource<? extends String>>() {
                @Override
                public ObservableSource<? extends String> call() throws Exception {
                    return Observable.just(brand);
                }
            });
        }
    }
}
