let p = new Promise(function (resolve, reject) {
    throw new Error();
})
    .then(function (result) {
        console.log(result);
    })
    .catch(function (reject) {
        console.log(reject);
    });
console.log(123);

// setTimeout(explode,500);
// setTimeout(run,1000);
//
// function explode() {
//     throw new Error("Boom!");
// }
//
// function run() {
//     console.log(123);
// }