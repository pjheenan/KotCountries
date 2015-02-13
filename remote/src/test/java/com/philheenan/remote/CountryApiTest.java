package com.philheenan.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.philheenan.core.model.Country;

import junit.framework.TestCase;

import java.io.*;

/**
 * @author phillip.heenan (phillip.heenan@viagogo.com)
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
        ApiCountry country = gson.fromJson(stringResponse(stream), ApiCountry.class);

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

    public void testTransform() {
        InputStream stream = CountryApiTest.class.getResourceAsStream("/country/country.json");
        ApiCountry api = gson.fromJson(stringResponse(stream), ApiCountry.class);

        Country model = api.modelFromMap();
        assertNotNull(model);
        assertEquals("Colombia", model.getName());
        assertNotNull(model.getBorders());
        assertEquals(5, model.getBorders().length);
        for (Country item : model.getBorders()) {
            assertNotNull(item.getIso3LetterCode());
        }
    }

    private static String stringResponse(InputStream response) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(response));

        String line;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
