package com.philheenan.remote.scenario;

import com.google.gson.Gson;
import com.philheenan.core.model.RemoteRequest;
import com.philheenan.core.model.country.Country;
import com.philheenan.remote.RemoteScenario;
import com.philheenan.remote.RequestHandler;
import com.philheenan.remote.model.ApiCountry;
import com.philheenan.remote.util.ApiUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.client.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class RemoteCountriesScenario extends RemoteScenario<List<Country>> {

    RequestHandler handler;
    Gson gson;

    public RemoteCountriesScenario(Gson gson, RequestHandler handler) {
        this.gson = gson;
        this.handler = handler;
    }

    @Override
    protected RemoteRequest preProcess(RemoteRequest request) {
        return super.preProcess(request);
    }

    @Override
    public Observable<List<Country>> process(final RemoteRequest request) {
        return Observable.create(new Observable.OnSubscribe<List<Country>>() {
            @Override
            public void call(Subscriber<? super List<Country>> subscriber) {
                subscriber.onNext(postProcess(handler.process(request)));
                subscriber.onCompleted();
            }
        });
    }

    @Override
    protected List<Country> postProcess(Response input) {
        List<Country> result = new ArrayList<>();
        try {
            String json = ApiUtils.stringResponse(input.getBody().in());
            ApiCountry[] countries = gson.fromJson(json, ApiCountry[].class);
            for (ApiCountry country : countries) {
                result.add(country.getModel());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
