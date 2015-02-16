package com.philheenan.remote

import com.philheenan.core.model.Country
import com.philheenan.core.model.Location

/**
 * @author phillip.heenan (pjheenan@gmail.com)
 */
trait ApiMapping<out T> {
    fun modelFromMap(): T
}

fun mapBorders(alpha3LetterCode: String?): Country {
    var country = Country()
    country.iso3LetterCode = alpha3LetterCode
    return country
}

data class ApiCountry(
        var name : String? = "",
        var capital : String? = "",
        var altSpellings : Array<String?> = arrayOfNulls(0),
        var relevance : String? = "",
        var region : String? = "",
        var subregion : String? = "",
        var translations : Map<String, String>,
        var population : Long? = 0,
        var latlng : Array<Float?> = arrayOfNulls(0),
        var demonym : String? = "",
        var area : Float? = 0f,
        var gini : Float? = 0f,
        var timezones : Array<String?> = arrayOfNulls(0),
        var borders : Array<String?> = arrayOfNulls(0),
        var nativeName : String? = "",
        var callingCodes : Array<String?> = arrayOfNulls(0),
        var topLevelDomain : Array<String?> = arrayOfNulls(0),
        var alpha2Code : String? = "",
        var alpha3Code : String? = "",
        var currencies : Array<String?> = arrayOfNulls(0),
        var languages : Array<String?> = arrayOfNulls(0)) : ApiMapping<Country> {

    override fun modelFromMap(): Country = Country(
        this.name, this.capital, this.region, this.subregion, this.alpha2Code, this.alpha3Code, this.population, this.area,
        Array<Country?>(this.borders.size(), { i -> mapBorders(this.borders[i])}), Location(latlng[0], latlng[1]))
}

