package com.my.practice.programmers.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class N으로_표현 {
  public int solution(int N, int number) {
    Map<Integer, List<Integer>> t = new HashMap<>();
    int[] ns = new int[8];
    for(int i = 1; i <= 8; ++i) {
      ns[i-1] = (i == 1)? N : N * (int)Math.pow(10, i-1) + ns[i-2];
      t.put(i, List.of(ns[i-1]));
    }
    for(int i = 1; i <= 8; ++i) {
      List<Integer> f = new ArrayList<>(t.get(i));
      for(int j = 1; j < i; ++j) {
        for(int k = 0; k < t.get(j).size(); ++k) {
          for(int l = 0; l < t.get(i-j).size(); ++l) {
            int a = t.get(j).get(k), b = t.get(i-j).get(l);
            f.add(a + b);
            f.add(a - b);
            f.add(a * b);
            if(b != 0) f.add(a / b);
          }
        }
      }
      t.put(i, f);
    }

    return t.entrySet().stream()
        .dropWhile(entry -> entry.getValue().stream().noneMatch(value -> value == number))
        .findAny().map(Entry::getKey).orElse(-1);
  }
}
