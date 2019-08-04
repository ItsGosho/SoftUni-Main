const HandleBarsTools = {
    /*
    * Parameters:
    * @data: Object ,which fields correspond to the {{fieldName}} values
    * @templatePath: Path to the template which needs to be .hbs
    * @appendTo: Document element where the finished template will be appended
    */
    makeTemplate(data, templatePath, appendTo) {

        let template = Handlebars.compile(WebTools.getHTMLFile(templatePath));
        let elements = $(template(data));

        appendObjectElementsTo(elements, appendTo);
    },


    /*
    * @Parameters:
    * @data Object, which fields correspond to the {{fieldName}} value
    * @templatePath: Path to the template which needs to be .hbs
    *
    * @returns parsed template as string
    * */
    getTemplate(data, templatePath) {

        let template = Handlebars.compile(WebTools.getHTMLFile(templatePath));
        let elements = $(template(data));

        let result = '';
        for (let i = 0; i < elements.length; i++) {
            result += $(elements[i]).prop('outerHTML');
        }

        return result;
    },
};

/*
* Parameters:
* @elements: Collection of Node elements
* @consumer: Document element which will consume the passed elements
*
* */
function appendObjectElementsTo(elements, consumer) {
    for (const element of elements) {
        consumer.append(element);
    }
}