class BookCollection{

    constructor(shelfGenre,room,shelfCapacity){

        this.room = room;
        this.shelfGenre = shelfGenre;
        this.shelf = [];
        this.shelfCapacity = shelfCapacity;
    }

    get room() {
        return this._room;
    }

    set room(value) {
        if(typeof value !== "string"){
            throw new Error();
        }
        if(value !== "livingRoom"
            && value!=="bedRoom"
            && value!=="closet"){
            let txt = `Cannot have book shelf in ${value}`;
            throw new Error(txt);
        }
        this._room = value;
    }

    get shelfGenre() {
        return this._shelfGenre;
    }

    set shelfGenre(value) {
        if(typeof value !== "string"){
            throw new Error();
        }
        this._shelfGenre = value;
    }

    get shelf() {
        return this._shelf;
    }

    set shelf(value) {
        this._shelf = value;
    }

    get shelfCapacity() {
        return this._shelfCapacity;
    }

    set shelfCapacity(value) {
        if(typeof value !== "number"){
            throw new Error();
        }
        this._shelfCapacity = value;
    }


    addBook(bookName,bookAuthor,genre){
        if(this.shelf.length>=this.shelfCapacity){
            //remove first book
            this.shelf.splice(0,1);
        }
        this.shelf.push(bookName+"-"+bookAuthor+"-"+genre);
        this.shelf=this.shelf.sort((x1,x2)=>{
            let ath1= x1.split("-")[0];
            let ath2= x2.split("-")[0];
            return ath2.localeCompare(ath1);
        })
    }

    throwAwayBook(bookName){
        for (let i = 0; i < this.shelf.length; i++) {
            let values = this.shelf[i].split("-");
            if(values[0].toLowerCase()===bookName.toLowerCase()){
                this.shelf.splice(i,1);
            }
        }
    }

    showBooks(genre){
        let result = [];
        result.push(`Results for search "${genre}":`);
        for (let i = 0; i < this.shelf.length; i++) {
            let values = this.shelf[i].split("-");
            if(values[2].toLowerCase()===genre.toLowerCase()){
                result.push(`\uD83D\uDCD6 ${values[1]} - "${values[0]}"`);
            }
        }
        let res = result.join("\n");
        console.log(res);
        return res;
    }

    get shelfCondition(){
        return this.shelfCapacity-this.shelf.length;
    }

    toString(){
        if(this.shelf.length===0){
            return "It's an empty shelf";
        }else{
            let result = [];
            result.push(`"${this.shelfGenre}" shelf in ${this.room} contains:`);
            for (let i = 0; i < this.shelf.length; i++) {
                let values = this.shelf[i].split("-");
                if(values[2].toLowerCase()===this.shelfGenre.toLowerCase()){
                    result.push(`\uD83D\uDCD6 ${values[1]} – "${values[0]}`);
                }
            }
            return result.join("\n")
        }
    }
}

let bedRoom = new BookCollection('Programming', 'livingRoom', 5);
bedRoom.addBook("Introduction to Programming with C#", "Svetlin Nakov")
bedRoom.addBook("Introduction to Programming with Java", "Svetlin Nakov")
bedRoom.addBook("Programming for .NET Framework", "Svetlin Nakov");
console.log(bedRoom.toString());