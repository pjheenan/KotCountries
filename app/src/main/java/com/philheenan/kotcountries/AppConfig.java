package com.philheenan.kotcountries;

import com.philheenan.kotcountries.framework.AppModule;
import com.philheenan.remote.framework.RemoteModule;

import dagger.ObjectGraph;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class AppConfig {

    public static final String BASE_URL = "http://restcountries.eu/rest/v1";
    private static AppConfig modules;

    private ObjectGraph objectGraph;

    private AppConfig() {
    }

    public static AppConfig instance() {
        if (modules == null) {
            modules = new AppConfig();
        }
        return modules;
    }

    public static Object[] modulesForApp(CountriesApp app) {
        return new Object[]{
                new AppModule(),
                new RemoteModule(BuildConfig.DEBUG, AppConfig.BASE_URL)
        };
    }

    public void setObjectGraph(ObjectGraph objectGraph) {
        this.objectGraph = objectGraph;
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }

}
