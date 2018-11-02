function result() {

    class Keyboard{
        constructor(manufacturer,responseTime ){
            this._manufacturer=manufacturer;
            this._responseTime=responseTime;
        }

        get manufacturer() {
            return this._manufacturer;
        }

        set manufacturer(value) {
            this._manufacturer = value;
        }

        get responseTime() {
            return this._responseTime;
        }

        set responseTime(value) {
            this._responseTime = value;
        }
    }

    class Monitor{
        constructor(manufacturer,width,height) {
            this._manufacturer=manufacturer;
            this._width=width;
            this._height=height;
        }


        get manufacturer() {
            return this._manufacturer;
        }

        set manufacturer(value) {
            this._manufacturer = value;
        }

        get width() {
            return this._width;
        }

        set width(value) {
            this._width = value;
        }

        get height() {
            return this._height;
        }

        set height(value) {
            this._height = value;
        }
    }

    class Battery{
        constructor(manufacturer,expectedLife ) {
            this._manufacturer=manufacturer;
            this._expectedLife=expectedLife;
        }


        get manufacturer() {
            return this._manufacturer;
        }

        set manufacturer(value) {
            this._manufacturer = value;
        }

        get expectedLife() {
            return this._expectedLife;
        }

        set expectedLife(value) {
            this._expectedLife = value;
        }
    }
    
    //Abstract
    class Computer{
        constructor(manufacturer,processorSpeed,ram,hardDiskSpace ) {
            if(new.target===Computer){
                throw new Error();
            }
            this._manufacturer=manufacturer;
            this._processorSpeed=processorSpeed;
            this._ram=ram;
            this._hardDiskSpace=hardDiskSpace;
        }


        get manufacturer() {
            return this._manufacturer;
        }

        set manufacturer(value) {
            this._manufacturer = value;
        }

        get processorSpeed() {
            return this._processorSpeed;
        }

        set processorSpeed(value) {
            this._processorSpeed = value;
        }

        get ram() {
            return this._ram;
        }

        set ram(value) {
            this._ram = value;
        }

        get hardDiskSpace() {
            return this._hardDiskSpace;
        }

        set hardDiskSpace(value) {
            this._hardDiskSpace = value;
        }
    }

    class Laptop extends Computer{
        constructor(manufacturer,processorSpeed,ram,hardDiskSpace,weight,color,battery) {
            if(battery instanceof Battery){

            }else{
                throw new TypeError();
            }
            super(manufacturer,processorSpeed,ram,hardDiskSpace);
            this._weight=weight;
            this._color=color;
            this._battery=battery;
        }


        get battery() {
            return this._battery;
        }

        set battery(value) {
            if(value instanceof Battery){

            }else{
                throw new TypeError();
            }
            this._battery = value;
        }


        get manufacturer() {
            return this._manufacturer;
        }

        set manufacturer(value) {
            this._manufacturer = value;
        }

        get weight() {
            return this._weight;
        }

        set weight(value) {
            this._weight = value;
        }

        get color() {
            return this._color;
        }

        set color(value) {
            this._color = value;
        }
    }

    class Desktop extends Computer{
        constructor(manufacturer,processorSpeed,ram,hardDiskSpace,keyboard,monitor) {
            if(keyboard instanceof Keyboard){

            }else{
                throw new TypeError();
            }
            if(monitor instanceof Monitor){

            }else{
                throw new TypeError();
            }
            super(manufacturer,processorSpeed,ram,hardDiskSpace);
            this._keyboard=keyboard;
            this._monitor=monitor;
        }


        get manufacturer() {
            return this._manufacturer;
        }

        set manufacturer(value) {
            this._manufacturer = value;
        }

        get keyboard() {
            return this._keyboard;
        }

        set keyboard(value) {
            if(value instanceof Keyboard){

            }else{
                throw new TypeError();
            }
            this._keyboard = value;
        }

        get monitor() {
            return this._monitor;
        }

        set monitor(value) {
            if(value instanceof Monitor){

            }else{
                throw new TypeError();
            }
            this._monitor = value;
        }
    }

    return {
        Battery,
        Keyboard,
        Monitor,
        Computer,
        Laptop,
        Desktop
    }
}

let classes = result();
let Computer = classes.Computer;
let Laptop = classes.Laptop;
let Desktop = classes.Desktop;
let Monitor = classes.Monitor;
let Battery = classes.Battery;
let Keyboard = classes.Keyboard;

let keyboard = new Keyboard('Logitech',70);
let monitor = new Monitor('Benq',28,18);


let t = new Laptop("Hewlett Packard",2.4,4,0.5,3.12,"Silver","pesho");