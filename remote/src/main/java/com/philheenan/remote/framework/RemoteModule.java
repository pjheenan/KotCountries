package com.philheenan.remote.framework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.philheenan.core.IResourceWrapper;
import com.philheenan.remote.RequestHandler;
import com.philheenan.remote.client.RemoteClient;
import com.philheenan.remote.scenario.RemoteCountriesScenario;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
@Module(complete = false, library = true)
public class RemoteModule {

    private boolean isDebug;
    private String endPoint;

    public RemoteModule(boolean isDebug, String endPoint) {
        this.isDebug = isDebug;
        this.endPoint = endPoint;
    }

    @Provides
    RequestHandler provideRequestHandler(RemoteClient client) {
        return new RequestHandler(client);
    }

    @Provides
    @Singleton
    Client provideClient() {
        return new OkClient();
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    RemoteClient providesAdapter(Client client, Gson gson) {
        RestAdapter.Builder builder =
                new RestAdapter.Builder()
                        .setEndpoint(endPoint)
                        .setClient(client)
                        .setLogLevel((isDebug) ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                        .setConverter(new GsonConverter(gson));

        return builder.build().create(RemoteClient.class);
    }

    @Provides
    RemoteCountriesScenario provideCountriesScenario(Gson gson, RemoteClient remoteClient) {
        return new RemoteCountriesScenario(gson, new RequestHandler(remoteClient));
    }

}
