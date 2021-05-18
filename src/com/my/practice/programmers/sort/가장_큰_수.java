package com.my.practice.programmers.sort;

import java.math.BigDecimal;
import java.util.Arrays;

public class 가장_큰_수 {
  public String solution(int[] numbers) {
    return new BigDecimal(Arrays.stream(numbers)
        .mapToObj(String::valueOf)
        .sorted((x, y) -> {
          String xx = x, yy = y;
          for(int i = 0; i < 5; ++i) xx += xx;
          for(int i = 0; i < 5; ++i) yy += yy;
          int compare = xx.compareTo(yy);
          return compare * -1;
        }).reduce("", (a, b) -> a + b)).toString();
  }
}