package com.company;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlane (String name, Coordinates coordinates)
    {
        super(name, coordinates);
        super.type = "JetPlane";
    }



    public void updateConditions()
    {
        switch (weatherTower.getWeather(coordinates))
        {
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                writeMessage(this,"This is hot.");
                break;
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                writeMessage(this,"This is hot.");
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                writeMessage(this,"This is hot.");
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 7);
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
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }







}
