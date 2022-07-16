package com.example.pro.data

class Weather {
    var temp= 0.0
    var feelsLike= 0.0
    var pressure= 0
    var humidity= 0
    var minTemp= 0.0
    var maxTemp= 0.0



    constructor(temp: Double, feelsLike:Double,pressure:Int,humidity:Int,minTemp:Double,maxTemp:Double){
        this.temp = temp
        this.feelsLike = feelsLike
        this.pressure=pressure
        this.humidity=humidity
        this.minTemp=minTemp
        this.maxTemp=maxTemp
    }
}