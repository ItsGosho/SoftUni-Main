function f(){
    class Melon{
        constructor(weight,melonSort){
            if(new.target===Melon){
                throw new Error("Abstract class cannot be instantiated directly");
            }
            this._weight = weight;
            this._melonSort = melonSort;

        }


        get weight() {
            return this._weight;
        }

        get melonSort() {
            return this._melonSort;
        }
    }

    class Watermelon extends Melon{
        constructor(weight,melonSort) {
            super(weight,melonSort);
            this._elementIndex = weight*melonSort.length;
        }


        get elementIndex() {
            return this._elementIndex;
        }

        toString(){
            return `Element: Water\nSort: ${super.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    class Firemelon extends Melon{
        constructor(weight,melonSort) {
            super(weight,melonSort);
            this._elementIndex = weight*melonSort.length;
        }


        get elementIndex() {
            return this._elementIndex;
        }

        toString(){
            return `Element: Fire\nSort: ${super.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    class Earthmelon extends Melon{
        constructor(weight,melonSort) {
            super(weight,melonSort);
            this._elementIndex = weight*melonSort.length;
        }


        get elementIndex() {
            return this._elementIndex;
        }

        toString(){
            return `Element: Earth\nSort: ${super.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    class Airmelon extends Melon{
        constructor(weight,melonSort) {
            super(weight,melonSort);
            this._elementIndex = weight*melonSort.length;
        }


        get elementIndex() {
            return this._elementIndex;
        }

        toString(){
            return `Element: Air\nSort: ${super.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    class Melolemonmelon extends Melon{
        constructor(weight,melonSort) {
            super(weight,melonSort);
            this._elementIndex = weight*melonSort.length;
            this.element="Water";
            this.elements = ["Water","Fire","Earth","Air"];
            this.currIndex=0;
        }


        get elementIndex() {
            return this._elementIndex;
        }

        morph(){
            this.currIndex++;
            if(this.currIndex===4){
                this.currIndex=0;
            }
            this.element=this.elements[this.currIndex];
        }

        toString(){
            return `Element: ${this.element}\nSort: ${super.melonSort}\nElement Index: ${this.elementIndex}`;
        }
    }

    return {Melon,Watermelon,Firemelon,Earthmelon,Airmelon,Melolemonmelon}
}

let test = new Melolemonmelon(1,"asd");
console.log(test.toString());
test.morph();
test.morph();
test.morph();
test.morph();
test.morph();
console.log(test.toString());