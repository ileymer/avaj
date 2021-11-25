package com.company;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    private String type = "Helicopter";

    Helicopter (String name, Coordinates coordinates)
    {
        super(name, coordinates);
        super.type = "Helicopter";
    }




    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather)
        {
            case "SUN":
                coordinates.setHeight(coordinates.getHeight() + 2);
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                writeMessage(this,"This is hot.");
                break;
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                writeMessage(this,"This is hot.");
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                writeMessage(this,"This is hot.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 12);
                writeMessage(this,"This is hot.");
                break;
        }
        if (coordinates.getHeight() <= 0)
            weatherTower.unregister(this);
        if (coordinates.getHeight() > 100)
            coordinates.setHeight(100);
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        this.weatherTower = WeatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }



}
