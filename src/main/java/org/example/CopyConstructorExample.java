package org.example;

import java.util.ArrayList;
import java.util.List;

class Engine {
    int power;

    Engine(int power) {
        this.power = power;
    }

    Engine(Engine other) {  // Copy constructor
        this.power = other.power;
    }
}

class Car {
    String model;
    Engine engine;

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    Car(Car other) {  // Copy constructor
        this.model = other.model;
        this.engine = new Engine(other.engine);
    }
}

public class CopyConstructorExample {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", new Engine(200));
        Car car2 = new Car(car1); // Deep Copy using Copy Constructor

        car2.engine.power = 300;

        System.out.println(car1.engine.power);  // 200
        System.out.println(car2.engine.power);  // 300

        List list = new ArrayList();  // No generics
        list.add("Hello");
        list.add(123); // No compile-time error
        System.out.println(list);
        for (Object obj : list) {
            String str = (String) obj;  // Throws `ClassCastException` at runtime
            System.out.println(str);
        }
    }
}
