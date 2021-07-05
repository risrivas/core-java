package udemy.java.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        hanoi(3, 'A', 'C', 'B');
    }

    private static void hanoi(int n, char source, char destination, char buffer) {
        if (n<=1) {
            System.out.printf("Move Disk 1 from %s to %s%n", source, destination);
            return;
        }

        hanoi(n-1, source, buffer, destination);
        System.out.printf("Move Disk %d from %s to %s%n", n, source, destination);
        hanoi(n-1, buffer, destination, source);
    }

}
