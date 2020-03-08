package com.keywer.masterclass.spring.graphql.service;

import com.keywer.masterclass.spring.graphql.model.Family;
import com.keywer.masterclass.spring.graphql.repository.FamilyRepository;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class FamilyPublisher {

    private Flowable<Family> publisher;

    private FamilyRepository familyRepository;

    @Autowired
    public FamilyPublisher(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
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
        return () ->{
            Iterable<Family> iterable = familyRepository.findAll(Sort.by("id").descending());
            List<Family> family = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
            if(!family.isEmpty()){
                observableEmitter.onNext(family.get(0));
            }
        };
    }

    public Publisher<Family> getPublisher() {
        return publisher;
    }
}
