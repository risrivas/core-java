package udemy.java.recursion;

public class HousingProblem {

    public static void main(String[] args) {
        buildLayer(5);
    }

    private static void buildLayer(int height) {
        if (height == 0) return;

        // buildLayer(height-1); // head recursion

        System.out.println(height);

        buildLayer(height-1); // tail recursion
    }
}
