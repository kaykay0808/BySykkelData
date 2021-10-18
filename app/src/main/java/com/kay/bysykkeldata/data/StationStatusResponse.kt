package com.kay.bysykkeldata.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationStatusResponse(
    val data: StationStatusesApiModel,
    @SerialName("last_updated")
    val lastUpdated: Int
)

@Serializable
data class StationStatusesApiModel(
    val stations: List<StationStatusApiModel>
)

@Serializable
data class StationStatusApiModel(
    @SerialName("is_installed")
    val isInstalled: Int,
    @SerialName("is_renting")
    val isRenting: Int,
    @SerialName("is_returning")
    val isReturning: Int,
    @SerialName("last_reported")
    val lastReported: Int,
    @SerialName("num_bikes_available")
    val numBikesAvailable: Int,
    @SerialName("num_docks_available")
    val numDocksAvailable: Int,
    @SerialName("station_id")
    val stationId: String
)