package com.tt;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

public class TULTests {

    private static final Logger log = LoggerFactory.getLogger(TULTests.class);

    void print(Object obj) {
        log.info("Got: {}", obj);
    }

    @Test
    public void wjug_36() throws Exception {
        final Observable<String> obs = Observable.just("42");

        obs.subscribe(this::print);
    }
}
