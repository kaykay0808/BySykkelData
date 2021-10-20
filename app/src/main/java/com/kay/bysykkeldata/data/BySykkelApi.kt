package com.kay.bysykkeldata.data

import retrofit2.http.GET

interface BySykkelApi {
    //Tilgjengelighet på sykler og stasjoner
    @GET("station_status.json")
    suspend fun getStationStatus(): StationStatusResponse

    //Informasjon om alle stasjoner, med adresser og beskrivelse.
    @GET("station_information.json")
    suspend fun getStations(): StationsResponse
}