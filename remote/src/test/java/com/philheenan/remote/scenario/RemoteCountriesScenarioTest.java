package com.philheenan.remote.scenario;

import com.philheenan.core.model.HttpType;
import com.philheenan.core.model.RemoteRequest;
import com.philheenan.core.model.country.Country;

import org.mockito.Mock;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import rx.Observer;

import static org.mockito.Mockito.*;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class RemoteCountriesScenarioTest extends BaseTest {

    @Inject
    RemoteCountriesScenario scenario;

    @Mock
    Observer<List<Country>> mockObserver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SuppressWarnings("unchecked")
    public void testProcess() {
        setScenario("country/countries.json");

        RemoteRequest req = new RemoteRequest();
        req.type = HttpType.GET;
        req.authHeader = "";
        req.urlPath = "/path";
        req.queryParams = new HashMap();

        scenario.process(req).subscribe(mockObserver);

        verify(mockObserver).onNext(any(List.class));
    }
}
