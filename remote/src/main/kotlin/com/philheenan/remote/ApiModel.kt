package com.philheenan.remote

import com.philheenan.core.model.*

/**
 * @author phillip.heenan (pjheenan@gmail.com)
 */
trait ApiMapping<out T> {
    fun modelFromMap(): T
}

fun mapBorders(alpha3LetterCode: String): Country {
    var country = Country()
    country.iso3LetterCode = alpha3LetterCode
    return country
}

data class ApiCountry(
        var name : String = "",
        var capital : String = "",
        var altSpellings : Array<String>,
        var relevance : String = "",
        var region : String = "",
        var subregion : String = "",
        var translations : Map<String, String>,
        var population : Long = 0,
        var latlng : Array<Int>,
        var demonym : String = "",
        var area : Long = 0,
        var gini : Float = 0f,
        var timezones : Array<String>,
        var borders : Array<String>,
        var nativeName : String,
        var callingCodes : Array<String>,
        var topLevelDomain : Array<String>,
        var alpha2Code : String = "",
        var alpha3Code : String = "",
        var currencies : Array<String>,
        var languages : Array<String>) : ApiMapping<Country> {

    override fun modelFromMap(): Country = Country(
        this.name, this.capital, this.region, this.subregion, this.alpha2Code, this.alpha3Code, this.population, this.area,
        Array<Country?>(borders.size(), { i -> mapBorders(borders[i])}), Location(latlng[0], latlng[1]))
}