package com.philheenan.remote.test;

import com.philheenan.remote.TestApiModule;
import com.philheenan.remote.framework.RemoteModule;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class TestModule {

    public static Object[] modulesForTest() {
        return new Object[]{
                new RemoteModule(true, "test.api"),
                new TestApiModule()
        };
    }
}
