import ProjectRepository from '../repositories/project.repository'

const ProjectServices = {

    async findById(id) {
        return ProjectRepository.findById(id)
    },

    async findByName(name) {
        return ProjectRepository.findByName(name)
    },

    async save(project) {
        return ProjectRepository.save(project)
    },

    async findAllWithoutTeam() {
        return ProjectRepository.findAllWithoutTeam()
    },

    async findAllByTeams(teams) {
        let projects = [];

        for (const team of teams) {
            let allProjects = await ProjectRepository.findAllByTeam(team);

            for (const proj of allProjects) {
                projects.push(proj);
            }
        }

        return projects;
    }
}

export default ProjectServices