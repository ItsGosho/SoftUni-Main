class Textbox {

    constructor (selector,regex){

        this.selectors = $(`${selector}`);
        console.log(this.selectors);
        this.regex=regex;

    }

    get value(){
        return this.selectors[0].value + " "+ this.selectors[1].value;
    }
}

let textbox = new Textbox(".textbox",/[^a-zA-Z0-9]/);
let inputs = $('.textbox');

inputs.on('input',function(){console.log(textbox.value)});
