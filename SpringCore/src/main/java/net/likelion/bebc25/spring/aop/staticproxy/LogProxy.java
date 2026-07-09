package net.likelion.bebc25.spring.aop.staticproxy;

public class LogProxy implements Car {
    private final Car target;   // 진짜 Car 객체

    public LogProxy(Car target){    // target은 GasolineCar가 됨
        this.target = target;
    }
    @Override
    public void startEngine() { // LogProxy하는 대리객체를 전달함으로써 실제 타켓 객체의 메서드를 실행
        System.out.println("[메서드 실행 전] 엔진을 점검합니다.");
        target.startEngine();
    }

    @Override
    public void drive() {
        System.out.println("[메서드 실행 전] 안전벨트를 맵니다.");
        target.drive();
        System.out.println("[메서드 실행 전후] 안전벨트를 풉니다.");
    }

    @Override
    public void stopEngine() {
        target.stopEngine();
        System.out.println("[메서드 실행 후] 하차합니다.");
    }
}
