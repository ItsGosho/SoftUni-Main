import ProjectModel from '../domain/models/project.model';


const ProjectRepository = {

    async save(data) {
        return new ProjectModel(data).save();
    },

    async deleteById(id) {

        return ProjectModel.deleteOne({'_id': id}).exec();
    },

    async findById(id) {
        return ProjectModel.findById(id).exec();
    },

    async findTotal() {
        return ProjectModel.count({}).exec();
    },

    /*-----*/

    async findByName(name) {
        return ProjectModel.findOne({name}).exec();
    },

    async findAllWithoutTeam(){
        return ProjectModel.find({team: null}).exec();
    }
};

export default ProjectRepository;