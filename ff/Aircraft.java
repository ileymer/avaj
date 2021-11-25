package com.company;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected String type;
    protected Coordinates coordinates;
    private static long idCounter = 0;


    public Aircraft(String name,  Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId()
    {
       // idCounter++;
        return (idCounter++);
    }

    public void writeMessage(Aircraft obj, String message)
    {
        System.out.println(obj.type + "#" + obj.name + "(" + obj.id + ")" + ": " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight());
    }

}
