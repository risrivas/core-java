package coding.game;

class Change {
    long coin2 = 0;
    long bill5 = 0;
    long bill10 = 0;
}

public class Test {



    public static void main(String[] args) {
        long s = 10L; // Change this value to perform other tests
        Change m = Test.optimalChange(s);

        System.out.println("Coin(s)  2€: " + m.coin2);
        System.out.println("Bill(s)  5€: " + m.bill5);
        System.out.println("Bill(s) 10€: " + m.bill10);
    }

    static Change optimalChange(long s) {
        long[] coins = new long[]{2L, 5L, 10L};
        return optimalChange(coins, s, 0);
    }

    static Change optimalChange(long[] coins, long money, int index) {
        if(money == 0L) {
            Change change = new Change();
            if(index == 0) change.coin2 = 1;
            if(index == 1) change.bill5 = 1;
            if(index == 2) change.bill10 = 1;
            return change;
        }

        if(index >= coins.length) {
            return null;
        }

        long amtWithCoin = 0L;

        Change change = new Change();
        change.coin2 = 0L;
        change.bill5 = 0L;
        change.bill10 = 0L;

        while(amtWithCoin <= money) {
            long remaining = money - amtWithCoin;
            change = optimalChange(coins, remaining, index + 1);
            amtWithCoin += coins[index];
        }

        return change;
    }

}
