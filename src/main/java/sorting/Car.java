package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Define a Car class
public class Car {
    public String brand;
    public String model;
    public int year;

    public Car(String b, String m, int y) {
        brand = b;
        model = m;
        year = y;
    }
}

// Create a comparator
class SortByYear implements Comparator {
    public int compare(Object obj1, Object obj2) {
        // Make sure that the objects are Car objects
        Car a = (Car) obj1;
        Car b = (Car) obj2;


        if (a.year < b.year) return -1; // The first car has a smaller year
        if (a.year > b.year) return 1;  // The first car has a larger year
        return 0; // Both cars have the same year
    }
}

class Main {
    public static void main(String[] args) {
        // Create a list of cars
        ArrayList<Car> myCars = new ArrayList<Car>();
        myCars.add(new Car("BMW", "X5", 1999));
        myCars.add(new Car("Honda", "Accord", 2006));
        myCars.add(new Car("Ford", "Mustang", 1970));

        // Use a comparator to sort the cars
        Comparator myComparator = (Object x, Object y)->{
            Car a = (Car) x;
            Car b = (Car) y;
            if( a.year<b.year) return -1;
            if( a.year>b.year) return 1;
            return 0;

        };

        Collections.sort(myCars, (Object x, Object y)->{
            Car a = (Car) x;
            Car b = (Car) y;
            if( a.year<b.year) return -1;
            if( a.year>b.year) return 1;
            return 0;

        });

        // Display the cars
        for (Car c : myCars) {
            System.out.println(c.brand + " " + c.model + " " + c.year);
        }

        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);
        System.out.println(myNumbers);

        Collections.sort(myNumbers, (Object o1, Object o2)->{
            Integer a = (Integer) o1;
            Integer b = (Integer)  o2;
            Boolean a1 = (a%2 == 0);
            Boolean b1 = (b%2 == 0);
            if(a1 == b1) {
                if (a < b) return -1;
                if (a > b) return 1;
                return 0;
            }else {

                // If a is even then it goes first, otherwise b goes first
                if (a1) {
                    return -1;
                } else {
                    return 1;
                }
            }} );


        for(int i :myNumbers)
            System.out.println(i);

    }



}

