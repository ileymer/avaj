package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    private static int simulationCycles;
    private static BufferedReader br;
    private static String currentLine;
    private static WeatherTower tower;

    private static void initSimulation(File file) {
        try {
            br = new BufferedReader(new FileReader(file));
            simulationCycles = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            br = null;
        }
    }

    private static void loadAircrafts()  {
        try {
            String info[];
            tower = new WeatherTower();
            while ((currentLine = br.readLine()) != null) {
                info = currentLine.split("\\s+");
                AircraftFactory.NewAircraft(info[0], info[1], Integer.parseInt(info[2]),
                        Integer.parseInt(info[3]), Integer.parseInt(info[4])).registerTower(tower);
            }
            br.close();
        } catch (IOException e) {
            int i = 1;        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            return;
        }

            initSimulation(new File(args[0]));
            loadAircrafts();


        while (simulationCycles-- > 0) {
            tower.changeWeather();
        }


    }


}
