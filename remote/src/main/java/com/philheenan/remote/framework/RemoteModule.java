package com.philheenan.remote.framework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.philheenan.core.IResourceWrapper;
import com.philheenan.remote.client.RemoteClient;

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
    @Singleton
    Client provideClient() {
        return new OkClient();
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    RemoteClient providesAdapter(Client client, Gson gson, final IResourceWrapper wrapper) {
        RestAdapter.Builder builder =
                new RestAdapter.Builder()
                        .setEndpoint(endPoint)
                        .setClient(client)
                        .setLogLevel((isDebug) ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                        .setConverter(new GsonConverter(gson))
//                        .setRequestInterceptor(new ClientRequestInterceptor(userAgent, wrapper))
                ;

        return builder.build().create(RemoteClient.class);
    }


}
