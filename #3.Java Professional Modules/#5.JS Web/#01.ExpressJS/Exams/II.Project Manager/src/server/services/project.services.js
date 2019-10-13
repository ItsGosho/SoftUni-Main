import ProjectRepository from '../repositories/project.repository'

const ProjectServices = {

  async findById (id) {
    return ProjectRepository.findById(id)
  },

  async findByName (name) {
    return ProjectRepository.findByName(name)
  },

  async save (project) {
    return ProjectRepository.save(project)
  },

  async findAllWithoutTeam () {
    return ProjectRepository.findAllWithoutTeam()
  }
}

export default ProjectServices