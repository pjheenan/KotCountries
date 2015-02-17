package com.philheenan.remote;

import com.philheenan.remote.client.LocalApiClient;
import com.philheenan.remote.scenario.BaseTest;
import com.philheenan.remote.scenario.RemoteCountriesScenarioTest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.client.Client;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
@Module(
        library = true
        , complete = false
        , addsTo = RemoteModule.class
        , overrides = true
        , injects = {
        BaseTest.class
        , RemoteCountriesScenarioTest.class
}
)
public class TestApiModule {

    public TestApiModule() {
    }

    @Provides
    @Singleton
    Client provideClient() {
        return new LocalApiClient();
    }

}
