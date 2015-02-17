package com.philheenan.remote;

import com.philheenan.core.Scenario;
import com.philheenan.core.model.RemoteRequest;

import retrofit.client.Response;
import rx.Observable;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class RemoteScenario<C> extends Scenario<RemoteRequest, Response, C> {

    protected RemoteRequest preProcess(RemoteRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Observable<C> process(RemoteRequest request) {
        return null;
    }

    protected C postProcess(Response input) {
        throw new UnsupportedOperationException();
    }
}
