package de.claudioaltamura.springboot.javarecords.abstraction;

record VehicleRecord() implements Vehicle {
    @Override
    public boolean isPetrol() {
        return true;
    }
}
