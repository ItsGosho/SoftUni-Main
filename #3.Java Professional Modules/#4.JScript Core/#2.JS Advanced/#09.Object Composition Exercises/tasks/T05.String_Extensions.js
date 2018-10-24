(function f() {
     String.prototype.ensureStart=function (string) {
         if(!this.startsWith(string)){
             let str =string+ this;
             return str;
         }else{
             return ""+this;
         }
     };
    String.prototype.ensureEnd=function (string) {
        if(!this.endsWith(string)){
            let str = this+string;
            return str;
        }else{
            return ""+this;
        }
    };
    String.prototype.isEmpty=function () {
        if(this==""){
            return true;
        }else{
            return false;
        }
    };
    String.prototype.truncate=function (n) {
        if (this.length < 4)
            return '.'.repeat(n);
        if (this.length <= n)
            return this.toString();
        if (this.indexOf(' ') == -1) {
            return this.slice(0, n - 3) + '...';
        }
        let tokens = this.split(' ');
        let result = tokens[0];
        for (let i = 1; i < tokens.length; i++) {
            if (result.length + tokens[i].length + 4 > n)
                return result + '...';
            result += ` ${tokens[i]}`;
        }
    };
    String.format=function (format,...params) {
        for (let i = 1; i < arguments.length; i++)
            format = format.replace('{' + (i - 1) + '}', arguments[i]);
        return format;
    }
})();

function test() {
    let asd = "1";
    str = String.format('The {0} {1} fox',
        'quick', 'brown');

    console.log(str);
}

test();