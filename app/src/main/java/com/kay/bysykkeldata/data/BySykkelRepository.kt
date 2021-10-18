package com.kay.bysykkeldata.data

import com.kay.bysykkeldata.ui.BySykkelUiModel

class BySykkelRepository(val api: BySykkelApi) {
    suspend fun getData(): List<BySykkelUiModel> {
        val statusResponse = api.getStationStatus()
        val stationsResponse = api.getStations()
        val uiModels = stationsResponse.data.stations.map { station ->
            val status = statusResponse.data.stations.find { station.stationId == it.stationId }

            BySykkelUiModel(
                stationName = station.name,
                numberOfDocks = status?.numDocksAvailable ?: 0,
                numberOfBikes = status?.numBikesAvailable ?: 0,
            )
        }
        return uiModels
    }
}