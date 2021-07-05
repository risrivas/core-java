package com.pluralsight.slidesexpressingintent;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person p1 = new Person("Jim", 50);
        Person p2 = new Person("Jim", 55);
        System.out.println(p1.compareTo(p2));
    }
}
