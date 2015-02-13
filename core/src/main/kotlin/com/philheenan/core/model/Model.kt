package com.philheenan.core.model

/**
 * @author phillip.heenan (pjheenan@gmail.com)
 */
public data class Location(var latitude : Int, var longitude : Int)

public data class Country(
        var name: String = "",
        var capital: String = "",
        var region: String = "",
        var subRegion: String = "",
        var iso2LetterCode: String = "",
        var iso3LetterCode: String = "",
        var population: Long = 0,
        var area: Long = 0,
        var borders: Array<Country?> = arrayOfNulls(0),
        var location: Location? = null

)