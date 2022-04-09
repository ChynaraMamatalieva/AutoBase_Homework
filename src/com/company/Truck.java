package com.company;

public class Truck {
    private int id;
    private String trucksName;
    private String driver;
    private State state;

    public Truck(int id, String trucksName, String driver, State state) {
        this.id = id;
        this.trucksName = trucksName;
        this.driver = driver;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrucksName() {
        return trucksName;
    }

    public void setTrucksName(String trucksName) {
        this.trucksName = trucksName;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static void changeDriver(Truck truckkk, Driver[] drivers) {
        for (Driver dr : drivers) {
            if (dr.getBus().matches("[^a-zA-Z]*")) {
                truckkk.setDriver(dr.getName());
                dr.setBus(truckkk.getTrucksName());
                break;
            }
        }
        try {
            if (truckkk.state.equals(State.ROUTE)) {
                throw new ChangeException();
            }
        } catch (ChangeException c) {
            System.out.printf("There is no free Driver\n, the Truck[%s] is on the Route", truckkk.getTrucksName());
        }
        try {
            if (truckkk.state.equals(State.REPAIR)) {
                throw new ChangeException();
            }
        } catch (ChangeException c) {
            System.out.printf("There is no free Driver\n, the Truck(%s) is on the Repair", truckkk.getTrucksName());
        }

    }
    public static void startDriving(Truck truck) {
        if (truck.state.equals(State.BASE)) {
            truck.setState(State.ROUTE);
        }
        try {
            if (truck.getDriver().matches("[^a-zA-Z]*")) {
                throw new ChangeException();
            }
        } catch (ChangeException e) {
            System.out.printf("The Truck(%s) has no Driver\n", truck.getTrucksName());
        }
        try{
            if (truck.state.equals(State.REPAIR)){
                throw new ChangeException();
            }
        }catch (ChangeException e){
            System.out.printf("The Truck (%s) is on Repair\n", truck.getTrucksName());
        }
    }
    public static  void startRepair(Truck truck){
        try{
            if (truck.state.equals(State.REPAIR)) {
                throw new ChangeException();
            }
            }catch (ChangeException e){
            System.out.printf("The Truck(%s) is on the Repair\n", truck.getTrucksName());
        }
        try{
            if (truck.state.equals(State.ROUTE)){
                throw new ChangeException();
            }
        }catch (ChangeException e){
            System.out.printf("The Truck(%s) is on the Route\n");
        }if (truck.state.equals(State.BASE)){
            truck.state = State.REPAIR;
        }
    }



    @Override
    public String toString() {
        return id + "   |" + trucksName + "  |    " + driver + "     | " + state + '\n';
    }
}
