package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path PATH = Paths.get("./truck.json");
    public static final Path PATH1 = Paths.get("./driver.json");

    public static void main(String[] args) {

        Driver driver1 = new Driver(1, "Sasha", "");
        Driver driver2 = new Driver(2, "Petya", "");
        Driver driver3 = new Driver(3, "Vasya", "");
        Driver[] drivers = {driver1, driver2, driver3};


        Truck truck1 = new Truck(1, "Mercedes", "", State.BASE);
        Truck truck2 = new Truck(2, "Toyota", "", State.BASE);
        Truck truck3 = new Truck(3, "Lexus", "", State.BASE);
        Truck[] trucks = {truck1, truck2, truck3};

        String json = GSON.toJson(trucks);
        String json2 = GSON.toJson(drivers);

        write(json);
        writeDrivers(json2);


        System.out.println("--------------*BUS*----------------");
        System.out.println("#   | Bus     | Driver   | State   ");
        System.out.println("____+_________+__________+__________");
        for (Truck truck : trucks) {
            System.out.println(truck);
        }
        System.out.println();
        System.out.println("------------*DRIVER*--------");
        System.out.println("#   | Driver     | Bus      ");
        System.out.println("____+____________+__________");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose one id number of trucks:  ");
            int input = scanner.nextInt();

            for (Truck tr : trucks) {
                if (input == tr.getId()) {
                    System.out.println("*******Truck-INFO*********");
                    System.out.println("N: " + tr.getId());
                    System.out.println("Bus: " + tr.getTrucksName());
                    System.out.println("Driver: " + tr.getDriver());
                    System.out.println("Bus State: " + tr.getState());

                    System.out.println("Press 1 to change Driver");
                    System.out.println("Press 2 to send to the Route");
                    System.out.println("Press 3 ot send to the Repairing");

                    int input2 = scanner.nextInt();
                    try {
                        if (input2 == 1) {
                            Truck.changeDriver(tr, drivers);
                            System.out.println();
                            System.out.println("Driver changed successfully");
                            Info(trucks, drivers);
                        } else if (input2 == 2) {
                            Truck.startDriving(tr);
                            System.out.println();
                            System.out.println("You have successfully entered the route");
                            Info(trucks, drivers);
                        } else if (input2 == 3) {
                            Truck.startDriving(tr);
                            System.out.println();
                            System.out.println("You are successfully sent  to the repair");
                            Info(trucks, drivers);
                        } else {
                            throw new ChangeException();
                        }
                    } catch (ChangeException e) {
                        System.out.println("There is no such an ID!!!");
                    }
                }
            }
        }
    }

    public static void write(String object) {
        try {
            Path write = Paths.get(String.valueOf(PATH));
            Files.writeString(write, object, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDrivers(String drivers) {
        Path write = Paths.get(String.valueOf(PATH1));
        try {
            Files.writeString(write, drivers, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Info(Truck[] trucks, Driver[] drivers) {
        Arrays.stream(trucks).forEach(System.out::println);
        System.out.println("****************************");
        Arrays.stream(drivers).forEach(System.out::println);
    }
}
