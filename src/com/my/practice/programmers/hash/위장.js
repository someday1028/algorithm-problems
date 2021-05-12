function solution(clothes) {
  var answer = 1;

  let map = {};
  clothes.forEach(c => {
    if(map[c[1]]) {
      map[c[1]].push(c[0]);
    } else {
      map[c[1]] = [c[0]];
    }
  })
  Object.entries(map).forEach(([key, value]) => {
    answer *= value.length+1;
  })
  return answer-1;
}