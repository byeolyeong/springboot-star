package net.likelion.bebc25.spring.di.constructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 컨테이너에 알려주는 앱 설정 클래스
@Configuration
public class AppConfig {
    @Bean   // 스프링 빈으로 등록(메서드명인 car가 빈의 이름이 됨)
    public Car car(){
        return new GasolineCar();
//        return new HybridCar();

    }

//    @Bean
//    public Car car2(){
////        return new GasolineCar();
//        return new HybridCar();
//
//    }

    @Bean
    public Driver driver222(Car car){
        return new Driver(car); // DI
    }
}

// 스프링 컨테이너가 하는 일
//AppConfig config = new AppConfig();
//Car car = config.car();
//Car car2 = config.car();
//Driver driver = config.driver(car);
