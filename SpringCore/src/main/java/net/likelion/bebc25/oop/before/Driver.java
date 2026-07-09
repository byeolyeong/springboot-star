package net.likelion.bebc25.oop.before;

public class Driver {
    // Driver 는 GasolineCar를 의존하는중
//    private GasolineCar car = new GasolineCar();
    private HybridCar car = new HybridCar();

    public void driveCar(){
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}
