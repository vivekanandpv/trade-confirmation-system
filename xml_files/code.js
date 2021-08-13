//  Promise declaration
function promiseFunction(initialCount, nSteps) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      let sum = initialCount;

      let i = 0;
      while (i <= nSteps) {
        sum += i;
        ++i;
      }
      resolve(sum);
    }, 3000);
  });
}

//  promise usage
promiseFunction(0, 11)
  .then((result) => console.log('Promise is successfully resolved', result))
  .catch((error) => console.log('Promise failed'))
  .finally(() => console.log('Promise finished'));

console.log('End of module');
