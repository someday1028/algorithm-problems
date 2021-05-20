package com.my.practice.programmers.dp;

import java.util.Arrays;

public class 정수_삼각형 {
  public int solution(int[][] triangle) {
    for(int i = 1; i < triangle.length; ++i) {
      for(int j = 0; j < triangle[i].length; ++j) {
        int a = j == 0? 0 : triangle[i-1][j-1];
        int b = j == triangle[i].length-1? 0 : triangle[i-1][j];
        triangle[i][j] = Math.max(a+triangle[i][j], b+triangle[i][j]);
      }
    }
    return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
  }
}
