package com.philheenan.process.scenario;

import com.philheenan.core.IScenario;
import com.philheenan.core.Scenario;
import com.philheenan.core.model.*;
import com.philheenan.core.request.CountriesRequest;
import com.philheenan.core.model.country.Country;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class CountriesScenario extends Scenario<CountriesRequest, List<Country>, List<Country>> {

    IScenario<RemoteRequest, List<Country>> remoteScenario;
    RemoteRequest remoteRequest;

    @Override
    protected CountriesRequest preProcess(CountriesRequest request) {
        remoteRequest = new RemoteRequest();
        remoteRequest.type = HttpType.GET;
        remoteRequest.urlPath = "/all";
        remoteRequest.authHeader = "";
        return super.preProcess(request);
    }

    @Override
    public Observable<List<Country>> process(CountriesRequest request) {
        preProcess(request);
        return remoteScenario.process(remoteRequest).map(new Func1<List<Country>, List<Country>>() {
            @Override
            public List<Country> call(List<Country> countries) {
                return postProcess(countries);
            }
        });
    }

    @Override
    protected List<Country> postProcess(List<Country> input) {
        return super.postProcess(input);
    }
}
