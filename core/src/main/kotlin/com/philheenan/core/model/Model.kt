package com.philheenan.core.model

/**
 * @author phillip.heenan (pjheenan@gmail.com)
 */
public data class Location(var latitude : Int, var longitude : Int)

public data class Country(
        public var name: String = "",
        public var capital: String = "",
        public var region: String = "",
        public var subRegion: String = "",
        public var iso2LetterCode: String = "",
        public var iso3LetterCode: String = "",
        public var population: Long = 0,
        public var area: Long = 0,
        public var borders: Array<Country?> = arrayOfNulls(0),
        public var location: Location? = null

)