package com.philheenan.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.philheenan.core.model.country.Country;
import com.philheenan.remote.model.ApiCountry;
import com.philheenan.remote.util.ApiUtils;

import junit.framework.TestCase;

import java.io.InputStream;

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
        assertEquals("Colombia", country.name);

        assertNotNull(country.translations);
        assertEquals(5, country.translations.size());

        assertTrue(country.translations.containsKey("de"));
        assertTrue(country.translations.containsValue("Colombie"));
        assertNotNull(country.borders);
        assertEquals("PAN", country.borders[2]);
        assertNotNull(country.callingCodes);
        assertEquals("57", country.callingCodes[0]);
    }

    public void testParsingNulls() {
        InputStream stream = CountryApiTest.class.getResourceAsStream("/country/countryAland.json");
        assertNotNull(stream);
        ApiCountry country = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry.class);

        assertNotNull(country);
        assertEquals("Åland Islands", country.name);
    }

    public void testParsingNullsAfg() {
        InputStream stream = CountryApiTest.class.getResourceAsStream("/country/countryAfghanistan.json");
        assertNotNull(stream);
        ApiCountry country = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry.class);

        assertNotNull(country);
        assertEquals("Afghanistan", country.name);
    }

    public void testTransform() {
        InputStream stream = CountryApiTest.class.getResourceAsStream("/country/country.json");
        ApiCountry api = gson.fromJson(ApiUtils.stringResponse(stream), ApiCountry.class);

        Country model = api.getModel();
        assertNotNull(model);
        assertEquals("Colombia", model.name);
        assertNotNull(model.borders);
        assertEquals(5, model.borders.size());
        for (Country item : model.borders) {
            assertNotNull(item.iso2LetterCode);
        }
    }

}
