let viewAddMeme = (request, response) => {
    console.log('View add meme was invoked.');
};

let viewAll = (request, response) => {
    console.log('View all has been invoked');
};

let addMeme = (request, response) => {
    console.log('Add meme has been invoked');
};

let getDetails = (request, response) => {
    console.log('Get details has been invoked');
};


module.exports = {viewAddMeme, viewAll, addMeme, getDetails};