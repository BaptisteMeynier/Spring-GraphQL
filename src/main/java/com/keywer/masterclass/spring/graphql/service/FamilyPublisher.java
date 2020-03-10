package com.keywer.masterclass.spring.graphql.service;

import com.keywer.masterclass.spring.graphql.model.Family;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class FamilyPublisher {

    private Flowable<Family> publisher;

    @Autowired
    public FamilyPublisher() {
        this.initSubscriber();
    }

    private void initSubscriber() {
        Observable<Family> familyObservable = Observable.create(observableEmitter -> {
                    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                    executorService.scheduleAtFixedRate(newFamilyTick(observableEmitter), 0, 2, TimeUnit.SECONDS);
                }
        );
        ConnectableObservable<Family> connectableObservable = familyObservable.share().publish();
        connectableObservable.connect();

        this.publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    private Runnable newFamilyTick(ObservableEmitter<Family> observableEmitter) {
        return () -> {
            observableEmitter.onNext(Family.builder().name("Discus").build());
        };
    }

    public Publisher<Family> getPublisher() {
        return publisher;
    }
}
