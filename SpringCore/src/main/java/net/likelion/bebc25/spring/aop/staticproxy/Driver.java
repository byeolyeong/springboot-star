package net.likelion.bebc25.spring.aop.staticproxy;

public class Driver {
    private final Car car;

    // DI
    Driver(Car car){
        System.out.println("called Constructor Injection" + car);
        this.car = car; // car는 LogProxy
    }

    public void driveCar(){
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}
