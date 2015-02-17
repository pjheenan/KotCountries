package com.philheenan.core;

import rx.Observable;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public interface IScenario<A, C> {

    public Observable<C> process(A request);

}
