class BaseRepository {

    constructor(model) {
        this.model = model;
    }

    async save(data) {
        return new this.model(data).save();
    }

    async deleteById(id) {
        return this.model.deleteOne({'_id': id}).exec();
    }

    async findById(id) {
        return this.model.findById(id).exec();
    }

    async findTotal() {
        return this.model.count({}).exec();
    }
}

export default BaseRepository