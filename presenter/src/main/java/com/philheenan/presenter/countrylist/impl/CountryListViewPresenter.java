package com.philheenan.presenter.countrylist.impl;

import com.philheenan.core.IScenario;
import com.philheenan.core.model.country.Country;
import com.philheenan.core.request.CountriesRequest;
import com.philheenan.presenter.countrylist.CountryListPresenter;
import com.philheenan.presenter.countrylist.CountryListViewModel;

import java.util.List;

import rx.Observer;
import rx.Subscription;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class CountryListViewPresenter implements CountryListPresenter<CountryListViewModel, List<Country>> {

    CountryListViewModel viewModel;
    IScenario<CountriesRequest, List<Country>> scenario;
    Subscription sub;

    public CountryListViewPresenter(IScenario<CountriesRequest, List<Country>> scenario) {
        this.scenario = scenario;
    }

    @Override
    public void start() {
        fetchData();
    }

    @Override
    public void finish() {
        if (sub != null && !sub.isUnsubscribed()) {
            sub.unsubscribe();
        }
    }

    @Override
    public void setViewModel(CountryListViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void setData(List<Country> data) {

    }

    void fetchData() {
        scenario.process(new CountriesRequest())
                .subscribe(getObserver());
    }

    Observer<List<Country>> getObserver() {
        return new Observer<List<Country>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Country> countries) {
            }
        };
    }
}
