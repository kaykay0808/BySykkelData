package com.kay.bysykkeldata.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationsResponse(
    val data: StationsApiModel,
    @SerialName("last_updated")
    val lastUpdated: Int
)

@Serializable
data class StationApiModel(
    val address: String,
    val capacity: Int,
    val lat: Double,
    val lon: Double,
    val name: String,
    @SerialName("station_id")
    val stationId: String
)

@Serializable
data class StationsApiModel(
    val stations: List<StationApiModel>
)