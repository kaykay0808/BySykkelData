package com.kay.bysykkeldata.data

import retrofit2.http.GET

interface BySykkelApi {
    @GET("station_information.json")
    suspend fun getStations(): StationsResponse

    @GET("station_status.json")
    suspend fun getStationStatus(): StationStatusResponse
}