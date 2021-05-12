package com.my.practice.programmers.hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.List;

public class 전화번호_목록 {
  public boolean solution(String[] phone_book) {

    List<String> sorted= Arrays.stream(phone_book)
        .sorted(Comparator.comparing(p -> p.length()))
        .collect(Collectors.toList());
    int min = sorted.get(0).length();
    return sorted.stream()
        .collect(Collectors.groupingBy(p -> p.substring(0, min)))
        .values()
        .stream()
        .map(pList -> {
          for(int i = 0; i < pList.size()-1; ++i) {
            if(pList.get(i+1).startsWith(pList.get(i))) {
              return false;
            }
          }
          return true;
        })
        .reduce((x, y) -> x && y).get();
  }
}