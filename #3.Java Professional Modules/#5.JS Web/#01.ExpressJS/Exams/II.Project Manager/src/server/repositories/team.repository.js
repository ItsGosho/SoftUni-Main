import TeamModel from '../domain/models/team.model';


const TeamRepository = {

    async save(data) {
        return new TeamModel(data).save();
    },

    async deleteById(id) {

        return TeamModel.deleteOne({'_id': id}).exec();
    },

    async findById(id) {
        return TeamModel.findById(id).exec();
    },

    async findTotal() {
        return TeamModel.count({}).exec();
    },

    /*-----*/

    async findByName(name) {
        return TeamModel.findOne({name}).exec();
    },
};

export default TeamRepository;