package udemy.java.memory.management;

public class MemoryTest {

    public static void main(String args[]) {
        MemoryTest main = new MemoryTest();
        main.start();
    }

    private void start() {
        String last = "Z";
        Container container = new Container();
        container.setInitial("C");
        another(container, last);
        System.out.print(container.getInitial());
    }

    private void another(Container initialHolder, String newInitial) {
        newInitial.toLowerCase();
        initialHolder.setInitial("B");
        Container initial2 = new Container();
        initialHolder = initial2;
        System.out.print(initialHolder.getInitial());
        System.out.print(newInitial);
    }
}
