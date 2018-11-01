function toStringExtension() {
    class Person {
        constructor(name,email) {
            this.name=name;
            this.email=email;
        }

        toString(){
            return `${this.constructor.name} (name: ${this.name}, email: ${this.email})`
        }
    }

    class Teacher extends Person{
        constructor(name,email,subject) {
            super(name,email);
            this.subject=subject;

        }

        toString(){
            return `${this.constructor.name} (name: ${this.name}, email: ${this.email}, subject: ${this.subject})`
        }

    }

    class Student extends Person{
        constructor(name,email,course) {
            super(name,email);
            this.course=course;

        }

        toString(){
            return `${this.constructor.name} (name: ${this.name}, email: ${this.email}, course: ${this.course})`
        }
    }

    return {
        Person,
        Teacher,
        Student
    }
}

let p = new Person("Joro","asd@abv.bg");
let t = new Teacher("Divcho","kvakva@gmail.com","chuski");
let s = new Student("Roki","str@yahoo.zdr","musaka");
console.log(p.toString());
console.log(t.toString());
console.log(s.toString());