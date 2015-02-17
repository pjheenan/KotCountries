package com.philheenan.core.model.country;

import java.util.List;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class Country {

    public String name;
    public String capital;
    public String region;
    public String subRegion;
    public String iso2LetterCode;
    public String iso3LetterCode;
    public long population;
    public float area;
    public List<Country> borders;
    public Location location;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", subRegion='" + subRegion + '\'' +
                ", iso2LetterCode='" + iso2LetterCode + '\'' +
                ", iso3LetterCode='" + iso3LetterCode + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", borders=" + borders +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (Float.compare(country.area, area) != 0) return false;
        if (population != country.population) return false;
        if (borders != null ? !borders.equals(country.borders) : country.borders != null)
            return false;
        if (capital != null ? !capital.equals(country.capital) : country.capital != null)
            return false;
        if (iso2LetterCode != null ? !iso2LetterCode.equals(country.iso2LetterCode) : country.iso2LetterCode != null)
            return false;
        if (iso3LetterCode != null ? !iso3LetterCode.equals(country.iso3LetterCode) : country.iso3LetterCode != null)
            return false;
        if (location != null ? !location.equals(country.location) : country.location != null)
            return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (region != null ? !region.equals(country.region) : country.region != null) return false;
        if (subRegion != null ? !subRegion.equals(country.subRegion) : country.subRegion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (subRegion != null ? subRegion.hashCode() : 0);
        result = 31 * result + (iso2LetterCode != null ? iso2LetterCode.hashCode() : 0);
        result = 31 * result + (iso3LetterCode != null ? iso3LetterCode.hashCode() : 0);
        result = 31 * result + (int) (population ^ (population >>> 32));
        result = 31 * result + (area != +0.0f ? Float.floatToIntBits(area) : 0);
        result = 31 * result + (borders != null ? borders.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
