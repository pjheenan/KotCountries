package com.philheenan.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        String json = stringResponse(stream);
        ApiCountry country = gson.fromJson(json, ApiCountry.class);

        assertNotNull(country);
        assertEquals("Colombia", country.getName());

        assertNotNull(country.getTranslations());
        assertEquals(5, country.getTranslations().size());

        assertTrue(country.getTranslations().containsKey("de"));
        assertTrue(country.getTranslations().containsValue("Colombie"));
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
