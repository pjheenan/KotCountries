package com.philheenan.remote.model;

import com.google.gson.annotations.SerializedName;
import com.philheenan.core.model.country.Country;
import com.philheenan.core.model.country.Location;

import java.util.*;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class ApiCountry {

    @SerializedName("name") public String name;
    @SerializedName("capital") public String capital;
    @SerializedName("altSpellings") public String[] altSpellings;
    @SerializedName("relevance") public String relevance;
    @SerializedName("region") public String  region;
    @SerializedName("subregion") public String  subregion;
    @SerializedName("translations") public Map<String, String> translations;
    @SerializedName("population") public long population;
    @SerializedName("latlng") public float[] latlng;
    @SerializedName("demonym") public String  demonym;
    @SerializedName("area") public float area;
    @SerializedName("gini") public float gini;
    @SerializedName("timezones") public String[] timezones;
    @SerializedName("borders") public String[] borders;
    @SerializedName("nativeName") public String  nativeName;
    @SerializedName("callingCodes") public String[] callingCodes;
    @SerializedName("topLevelDomain") public String[] topLevelDomain;
    @SerializedName("alpha2Code") public String  alpha2Code;
    @SerializedName("alpha3Code") public String  alpha3Code;
    @SerializedName("currencies") public String[] currencies;
    @SerializedName("languages") public String[] languages;

    public Country getModel() {
        Country result = new Country();
        result.name = this.name;
        result.capital = this.capital;
        result.region = this.region;
        result.subRegion = this.subregion;
        result.area = this.area;
        result.iso2LetterCode = this.alpha2Code;
        result.iso3LetterCode = this.alpha3Code;
        result.population = this.population;

        result.borders = new ArrayList<>();
        for(String border : this.borders) {
            Country borderCountry = new Country();
            borderCountry.iso2LetterCode = border;
            result.borders.add(borderCountry);
        }

        result.location = new Location();
        if (this.latlng != null && this.latlng.length == 2) {
            result.location.latitude = this.latlng[0];
            result.location.longitude = this.latlng[1];
        }

        return result;
    }

    @Override
    public String toString() {
        return "ApiCountry{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", altSpellings=" + Arrays.toString(altSpellings) +
                ", relevance='" + relevance + '\'' +
                ", region='" + region + '\'' +
                ", subregion='" + subregion + '\'' +
                ", translations=" + translations +
                ", population=" + population +
                ", latlng=" + Arrays.toString(latlng) +
                ", demonym='" + demonym + '\'' +
                ", area=" + area +
                ", gini=" + gini +
                ", timezones=" + Arrays.toString(timezones) +
                ", borders=" + Arrays.toString(borders) +
                ", nativeName='" + nativeName + '\'' +
                ", callingCodes=" + Arrays.toString(callingCodes) +
                ", topLevelDomain=" + Arrays.toString(topLevelDomain) +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", alpha3Code='" + alpha3Code + '\'' +
                ", currencies=" + Arrays.toString(currencies) +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiCountry that = (ApiCountry) o;

        if (Float.compare(that.area, area) != 0) return false;
        if (Float.compare(that.gini, gini) != 0) return false;
        if (population != that.population) return false;
        if (alpha2Code != null ? !alpha2Code.equals(that.alpha2Code) : that.alpha2Code != null)
            return false;
        if (alpha3Code != null ? !alpha3Code.equals(that.alpha3Code) : that.alpha3Code != null)
            return false;
        if (!Arrays.equals(altSpellings, that.altSpellings)) return false;
        if (!Arrays.equals(borders, that.borders)) return false;
        if (!Arrays.equals(callingCodes, that.callingCodes)) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (!Arrays.equals(currencies, that.currencies)) return false;
        if (demonym != null ? !demonym.equals(that.demonym) : that.demonym != null) return false;
        if (!Arrays.equals(languages, that.languages)) return false;
        if (!Arrays.equals(latlng, that.latlng)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nativeName != null ? !nativeName.equals(that.nativeName) : that.nativeName != null)
            return false;
        if (region != null ? !region.equals(that.region) : that.region != null) return false;
        if (relevance != null ? !relevance.equals(that.relevance) : that.relevance != null)
            return false;
        if (subregion != null ? !subregion.equals(that.subregion) : that.subregion != null)
            return false;
        if (!Arrays.equals(timezones, that.timezones)) return false;
        if (!Arrays.equals(topLevelDomain, that.topLevelDomain)) return false;
        if (translations != null ? !translations.equals(that.translations) : that.translations != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (altSpellings != null ? Arrays.hashCode(altSpellings) : 0);
        result = 31 * result + (relevance != null ? relevance.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (subregion != null ? subregion.hashCode() : 0);
        result = 31 * result + (translations != null ? translations.hashCode() : 0);
        result = 31 * result + (int) (population ^ (population >>> 32));
        result = 31 * result + (latlng != null ? Arrays.hashCode(latlng) : 0);
        result = 31 * result + (demonym != null ? demonym.hashCode() : 0);
        result = 31 * result + (area != +0.0f ? Float.floatToIntBits(area) : 0);
        result = 31 * result + (gini != +0.0f ? Float.floatToIntBits(gini) : 0);
        result = 31 * result + (timezones != null ? Arrays.hashCode(timezones) : 0);
        result = 31 * result + (borders != null ? Arrays.hashCode(borders) : 0);
        result = 31 * result + (nativeName != null ? nativeName.hashCode() : 0);
        result = 31 * result + (callingCodes != null ? Arrays.hashCode(callingCodes) : 0);
        result = 31 * result + (topLevelDomain != null ? Arrays.hashCode(topLevelDomain) : 0);
        result = 31 * result + (alpha2Code != null ? alpha2Code.hashCode() : 0);
        result = 31 * result + (alpha3Code != null ? alpha3Code.hashCode() : 0);
        result = 31 * result + (currencies != null ? Arrays.hashCode(currencies) : 0);
        result = 31 * result + (languages != null ? Arrays.hashCode(languages) : 0);
        return result;
    }
}
