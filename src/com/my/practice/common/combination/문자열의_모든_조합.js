function solution(array) {
  let flag = array.reduce((a, c) => {
    a[c] = 0;
    return a;
  }, {});
  let stack = [];
  let comb = [];
  let find = () => {
    if(stack.length === array.length) {
      comb.push(stack.reduce((a, c) => a+c, ''));
      return;
    }
    array.filter(num => !flag[num]).forEach(num => {
      flag[num]++;
      stack.push(num);
      find();
      flag[num]--;
      stack.pop();
    });
  }
  find();
  return comb;
}