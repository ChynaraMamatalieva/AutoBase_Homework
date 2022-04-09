package com.company;

public class Driver {
    private int id;
    private String name;
    private String bus;

    public Driver() {
    }

    public Driver(int id, String name, String bus) {
        this.id = id;
        this.name = name;
        this.bus = bus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public static Driver driver(int id, String name, String bus) {
        Driver driver = new Driver();
        driver.id = id;
        driver.name = name;
        driver.bus = bus;
        return driver;
    }

    @Override
    public String toString() {
        return id + "   | " + name + "     |      " + bus + '\n';
    }
}
