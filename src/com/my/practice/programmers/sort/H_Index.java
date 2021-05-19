package com.my.practice.programmers.sort;

import java.util.Arrays;

public class H_Index {
  public int solution(int[] citations) {
    int answer = 0;
    Arrays.sort(citations);
    for(int i = 0; i < citations.length; ++i) {
      int x = citations[i];
      int y = citations.length - i;
      int h = Math.min(x, y);
      answer = Math.max(answer, h);
      if(x > y) break;
    }
    return answer;
  }
}
