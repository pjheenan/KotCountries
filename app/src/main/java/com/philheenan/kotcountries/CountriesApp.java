package com.philheenan.kotcountries;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class CountriesApp extends Application {

    private static CountriesApp appContext;

    public static CountriesApp get() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        buildObjectGraph();
    }

    private void buildObjectGraph() {
        Object[] modules = AppConfig.modulesForApp(this);
        ObjectGraph objectGraph = ObjectGraph.create(modules);
        AppConfig.instance().setObjectGraph(objectGraph);
        AppConfig.instance().getObjectGraph().inject(this);
    }

    public void inject(Object obj) {
        AppConfig.instance().getObjectGraph().inject(obj);
    }

}
