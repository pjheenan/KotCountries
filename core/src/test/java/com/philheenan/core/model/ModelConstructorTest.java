package com.philheenan.core.model;

import junit.framework.TestCase;

/**
 * @author phillip.heenan (phillip.heenan@viagogo.com)
 */
public class ModelConstructorTest extends TestCase {

    public void testConstructorEmpty() {
        Country country = new Country();

        assertNotNull(country);
        assertEquals("", country.getName());

        country.setName("name");
        assertEquals("name", country.getName());
    }

    public void testConstructorPartial() {
        Country country = new Country("name", "capital", "region", "subRegion", "NZ", "NZL", 4000000l, 10000000l, new Country[]{}, new Location());

        assertNotNull(country);
        country.setName("name");
        assertEquals("name", country.getName());
    }
}
