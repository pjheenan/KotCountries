package com.philheenan.core;

import rx.Observable;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class Scenario<A, B, C> implements IScenario<A, C> {

    protected A preProcess(A request) {
        throw new UnsupportedOperationException();
    }

    public Observable<C> process(A request) {
        return null;
    }

    protected C postProcess(B input) {
        throw new UnsupportedOperationException();
    }
}
