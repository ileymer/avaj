package com.company;

public class WeatherProvider {
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int value = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        int i = value % 4;

        return weather[i];
    }
}
