package tdd.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tdd.kata.PrimeFactors.generate;

public class PrimeFactorsTest {

   @Test
   public void returnEmptyForOne() {
      assertThat(generate(1), is(Collections.emptyList()));
   }

   @Test
   public void test2() {
      assertThat(generate(2), is(asList(2)));
   }

   @Test
   public void test3() {
      assertThat(generate(3), is(asList(3)));
   }

   @Test
   public void test4() {
      assertThat(generate(4), is(asList(2, 2)));
   }

   @Test
   public void test5() {
      assertThat(generate(5), is(asList(5)));
   }

   @Test
   public void test6() {
      assertThat(generate(6), is(asList(2, 3)));
   }

   @Test
   public void test7() {
      assertThat(generate(7), is(asList(7)));
   }

   @Test
   public void test8() {
      assertThat(generate(8), is(asList(2, 2, 2)));
   }

   @Test
   public void test453() {
      assertThat(generate(453), is(asList(3, 151)));
   }

   @Test
   public void test9() {
      assertThat(generate(9), is(asList(3, 3)));
   }


}
