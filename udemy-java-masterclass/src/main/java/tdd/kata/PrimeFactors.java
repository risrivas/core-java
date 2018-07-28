package tdd.kata;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
   public static List<Integer> generate(int n) {
      List<Integer> primes = new ArrayList<>();

      for (int prime = 2; n > 1; prime++) {
         for (; n % prime == 0; n /= prime) {
            primes.add(prime);
         }
      }

      return primes;
   }
}
