package com.company;

public class AircraftFactory {
    public static Flyable NewAircraft(String type, String name, int longitude, int latitude, int height)
    {
        switch (type)
        {
            case "Baloon":
                return new Baloon(name, new Coordinates(longitude, latitude, height));
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "JetPlane":
                return new JetPlane(name, new Coordinates(longitude, latitude, height));
            default:
                return null;
        }
    }
}
