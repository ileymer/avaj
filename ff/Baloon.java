package com.company;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    private String type = "Balloon";

    Baloon (String name, Coordinates coordinates)
    {
        super(name, coordinates);
        super.type = "Balloon";
    }



    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather)
        {
            case "SUN":
                coordinates.setHeight(coordinates.getHeight() + 4);
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                writeMessage(this,"This is hot.");
                break;
            case "RAIN":
                coordinates.setHeight(coordinates.getHeight() - 5);
                writeMessage(this,"This is hot.");
                break;
            case "FOG":
                coordinates.setHeight(coordinates.getHeight() - 3);
                writeMessage(this,"This is hot.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 15);
                writeMessage(this,"This is hot.");
                break;
        }
        if (coordinates.getHeight() <= 0)
            weatherTower.unregister(this);
    }

    @Override
    public void registerTower(WeatherTower WeatherTower) {
        this.weatherTower = WeatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Balloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }




}
