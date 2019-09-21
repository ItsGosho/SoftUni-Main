import {Controller, Get} from "@decorators/express";

class Probichka {

    @Get('/kura')
    someMethod(request, response) {
        console.log(request);
        console.log(response);

        response.send('<h1>Hi</h1>');
    }

};

export default Probichka;