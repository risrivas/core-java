package com.pluralsight.slidesexpressingintent;

//@SuppressWarnings("deprecation")
public class MyWorker {
    //@SuppressWarnings("deprecation")
    void doSomeWork() {
        Doer d1 = new Doer();
        d1.doTheThing();
    }
    //@SuppressWarnings("deprecation")
    void doDoubleWork() {
        Doer d2 = new Doer();
        d2.doTheThing();
        d2.doTheThing();
    }

}
