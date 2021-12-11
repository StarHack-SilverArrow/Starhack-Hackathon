package com.example.silverarrowmobileapp.Model;

public class Car {
    private final String model;
    private final String age;
    private final String type;
    private final int capacity;

    public Car(String model, String age, String type, int capacity) {
        this.model = model;
        this.age = age;
        this.type = type;
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public String getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}
