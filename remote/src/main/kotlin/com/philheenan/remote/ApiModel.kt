package com.philheenan.remote

/**
 * @author phillip.heenan (phillip.heenan@viagogo.com)
 */
data class ApiTranslation(var language : String = "", var name : String = "")

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
        var languages : Array<String>

)

