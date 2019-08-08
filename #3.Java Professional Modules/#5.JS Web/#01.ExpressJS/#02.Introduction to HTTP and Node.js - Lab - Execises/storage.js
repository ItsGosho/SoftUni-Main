const fileSystemLibrary = require('fs');
const pathLibrary = require('path');


let data = new Map();

let put = (key, value) => {
    setTimeout(() => {
        if (typeof key !== 'string') {
            throw new Error('Key value must be string.');
        }

        if (data.has(key)) {
            throw new Error('Value with that key already exists.');
        }
        data.set(key, value);
    }, 0);
};

let get = (key, callback) => {

    setTimeout(() => {
        if (typeof key !== 'string') {
            throw new Error('Key value must be string.');
        }

        if (!data.has(key)) {
            throw new Error('Value with that key already exists.');
        }

        callback(key);
    }, 0);
};

let getAll = (callback) => {
    setTimeout(() => {
        if (data.size === 0) {
            console.log('There is no data present.');
        }
        callback(data);
    }, 0);
};

let update = (key, newValue) => {

    setTimeout(() => {
        if (typeof key !== 'string') {
            throw new Error('Key value must be string.');
        }

        if (!data.has(key)) {
            throw new Error('Value with that key already exists.');
        }
        data.set(key, newValue);
    }, 0);
};

let remove = (key) => {
    setTimeout(() => {
        if (typeof key !== 'string') {
            throw new Error('Key value must be string.');
        }

        if (!data.has(key)) {
            throw new Error('Value with that key already exists.');
        }

        data.delete(key);

    }, 0);
};

let clear = () => {
    setTimeout(() => {
        data.clear();
    }, 0);
};

let save = () => {
    setTimeout(() => {
        let result = JSON.stringify(Object.fromEntries(data));
        fileSystemLibrary.writeFile(pathLibrary.join(__dirname, 'storage.json'), result, (test) => {
            console.log(test);
        })
    }, 0);
};

let load = () => {
    setTimeout(() => {
        let result = fileSystemLibrary.readFileSync(pathLibrary.join(__dirname, 'storage.json'));
        data = new Map(Object.entries(JSON.parse(result.toString())));
    }, 0);
};
