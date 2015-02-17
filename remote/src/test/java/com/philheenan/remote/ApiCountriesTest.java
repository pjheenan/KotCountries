package com.philheenan.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.philheenan.remote.model.ApiCountry;
import com.philheenan.remote.util.ApiUtils;

import junit.framework.TestCase;

import java.io.InputStream;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class ApiCountriesTest extends TestCase {

    Gson gson = new GsonBuilder().create();

    public void testCountriesList() {
        InputStream stream = ApiCountriesTest.class.getResourceAsStream("/country/countries.json");
        assertNotNull(stream);
        ApiCountry[] countries = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry[].class);

        assertNotNull(countries);
        assertTrue(countries.length > 0);
        for (ApiCountry country : countries) {
            assertNotNull(country.name);
            assertTrue(country.name.length() > 0);
        }
    }

    public void testSingleCountriesList() {
        InputStream stream = ApiCountriesTest.class.getResourceAsStream("/country/singleCountriesList.json");
        assertNotNull(stream);
        ApiCountry[] countries = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry[].class);

        assertNotNull(countries);
        assertEquals(1, countries.length);
    }
}
