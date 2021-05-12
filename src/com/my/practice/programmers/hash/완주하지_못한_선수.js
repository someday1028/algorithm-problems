function solution(par, com) {
  let map = {};
  com.forEach(c => map[c] = (map[c]|0) + 1);
  return par.find(p => !map[p]--);
}