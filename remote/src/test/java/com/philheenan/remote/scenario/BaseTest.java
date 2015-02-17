package com.philheenan.remote.scenario;

import com.philheenan.remote.client.LocalApiClient;
import com.philheenan.remote.test.TestModule;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;

import dagger.ObjectGraph;
import retrofit.client.Client;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class BaseTest extends TestCase {

    @Inject
    Client localApiClient;

    public void setScenario(String scenario) {
        if (localApiClient != null) {
            ((LocalApiClient) localApiClient).setScenario(scenario);
        } else {
            fail("client has not been initialised");
        }
    }

    private ObjectGraph objectGraph;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        objectGraph = ObjectGraph.create(TestModule.modulesForTest());
        objectGraph.inject(this);
    }

    @Test
    public void testObjectGraph() throws Exception {
        assertNotNull(objectGraph);
    }
}
