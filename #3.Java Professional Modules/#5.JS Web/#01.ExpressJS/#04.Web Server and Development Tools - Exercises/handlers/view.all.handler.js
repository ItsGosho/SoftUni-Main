const URL = require('url');
const FileSystem = require('fs');
const HTMLTools = require('../tools/html.tools');
const DB = require('../config/dataBase');

module.exports = (request, response) => {
    if (isValid(request)) {
        let result = HTMLTools.getHTMLAsString('views/viewAll.html');

        let str = '';
        for (const movie of DB.sort((x1, x2) => x1.movieYear - x2.movieYear)) {
            str += `<div class="movie">
            <a href="/details/${movie.id}"><img class="moviePoster" src="${movie.moviePoster}"/></a>
            </div>`;
        }

        result = result.replace(`{{replaceMe}}`, str);

        response.write(result);
        response.end();
    }
};

function isValid(request) {
    let url = URL.parse(request.url).pathname;
    return url === '/viewAllMovies' && request.method.toUpperCase() === 'GET';
}