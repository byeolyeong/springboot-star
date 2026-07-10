package net.likelion.bebc25.spring.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Driver {
    @Autowired  // Field Injection
    private Car car;

//    Driver(){
//        System.out.println("Driver 기본 생성자 호출됨 : ");
//    }
//
//    // DI
//    @Autowired // DI(의존성 자동 주입 어노테이션. 생성자가 하나만 있을 경우에는 생략이 가능함)
//    // @Qualifier("해당 클래스를 소문자로 입력") 을 사용하면 Primary를 무시하고 사용함.
//    Driver(@Qualifier("gasolineCar") Car car){ // 필요한 Bean을 직접 사용함
//        System.out.println("Constructor Injection 호출됨: " + car);
//        this.car = car;
//    }

//    @Autowired
//    public void setCar(Car car){
//        System.out.println("Setter Injection 호출됨.");
//        this.car = car;
//    }



    public void driveCar(int maxSpeed){
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}
