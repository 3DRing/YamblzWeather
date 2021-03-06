package com.ringov.yamblzweather.data.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_CITY_ID;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_CONDITION;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_HUMIDITY;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_ID;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_PRESSURE;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_TEMP_MAX;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_TEMP_MIN;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_TIME;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_WIND_DEGREE;
import static com.ringov.yamblzweather.data.database.DBContract.COLUMN_WIND_SPEED;
import static com.ringov.yamblzweather.data.database.DBContract.TABLE_FORECAST;

@Entity(tableName = TABLE_FORECAST)
public class DBWeather {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    private long _id;

    @ColumnInfo(name = COLUMN_CITY_ID)
    private int cityId;

    @ColumnInfo(name = COLUMN_TIME)
    private long time;

    @ColumnInfo(name = COLUMN_TEMP_MAX)
    private float tempMax;

    @ColumnInfo(name = COLUMN_TEMP_MIN)
    private float tempMin;

    @ColumnInfo(name = COLUMN_CONDITION)
    private int condition;

    @ColumnInfo(name = COLUMN_HUMIDITY)
    private int humidity;

    @ColumnInfo(name = COLUMN_PRESSURE)
    private float pressure;

    @ColumnInfo(name = COLUMN_WIND_SPEED)
    private float windSpeed;

    @ColumnInfo(name = COLUMN_WIND_DEGREE)
    private float windDegree;

    public DBWeather(int cityId, long time, float tempMax, float tempMin, int condition, int humidity, float pressure, float windSpeed, float windDegree) {
        this.cityId = cityId;
        this.time = time;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.condition = condition;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public int getCityId() {
        return cityId;
    }

    public long getTime() {
        return time;
    }

    public float getTempMax() {
        return tempMax;
    }

    public float getTempMin() {
        return tempMin;
    }

    public int getCondition() {
        return condition;
    }

    public int getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getWindDegree() {
        return windDegree;
    }
}
