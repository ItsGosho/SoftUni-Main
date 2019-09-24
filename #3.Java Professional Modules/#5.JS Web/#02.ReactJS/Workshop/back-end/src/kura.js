class Kura {

    constructor(repository) {
        this.repository = repository;
    }

    test() {
        this.repository.save("dobre");
    }
}

export default Kura;