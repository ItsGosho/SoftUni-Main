class Point{
     constructor (x,y){
         this._x=x;
         this._y=y;
     }

     get x(){
         return this._x;
     }

    get y(){
        return this._y;
    }

     static distance(a,b){
         let dx = a.x - b.x;
         let dy = a.y - b.y;
         return Math.sqrt(dx*dx + dy*dy);
     }
}



let p1 = new Point(5, 5);
let p2 = new Point(9, 8);
console.log(Point.distance(p1, p2));
