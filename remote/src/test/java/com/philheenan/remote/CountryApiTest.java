package com.philheenan.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.philheenan.core.model.Country;
import com.philheenan.remote.util.ApiUtils;

import junit.framework.TestCase;

import java.io.*;

/**
 * @author phillip.heenan (pjheenan@gmail.com)
 */
public class CountryApiTest extends TestCase {

    Gson gson = new GsonBuilder().create();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCountryParser() {
        InputStream stream = CountryApiTest.class.getResourceAsStream("/country/country.json");
        assertNotNull(stream);
        ApiCountry country = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry.class);

        assertNotNull(country);
        assertEquals("Colombia", country.getName());

        assertNotNull(country.getTranslations());
        assertEquals(5, country.getTranslations().size());

        assertTrue(country.getTranslations().containsKey("de"));
        assertTrue(country.getTranslations().containsValue("Colombie"));
        assertNotNull(country.getBorders());
        assertEquals("PAN", country.getBorders()[2]);
        assertNotNull(country.getCallingCodes());
        assertEquals("57", country.getCallingCodes()[0]);
    }

    public void testParsingNulls() {
        InputStream stream = CountryApiTest.class.getResourceAsStream("/country/countryAland.json");
        assertNotNull(stream);
        ApiCountry country = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry.class);

        assertNotNull(country);
        assertEquals("Åland Islands", country.getName());
    }

    public void testParsingNullsAfg() {
        InputStream stream = CountryApiTest.class.getResourceAsStream("/country/countryAfghanistan.json");
        assertNotNull(stream);
        ApiCountry country = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry.class);

        assertNotNull(country);
        assertEquals("Afghanistan", country.getName());
    }

    public void testTransform() {
        InputStream stream = CountryApiTest.class.getResourceAsStream("/country/country.json");
        ApiCountry api = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry.class);

        Country model = api.modelFromMap();
        assertNotNull(model);
        assertEquals("Colombia", model.getName());
        assertNotNull(model.getBorders());
        assertEquals(5, model.getBorders().length);
        for (Country item : model.getBorders()) {
            assertNotNull(item.getIso3LetterCode());
        }
    }

}
