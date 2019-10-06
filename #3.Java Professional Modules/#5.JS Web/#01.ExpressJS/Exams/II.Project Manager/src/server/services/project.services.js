import ProjectRepository from '../repositories/project.repository'

const ProjectServices = {

  async findByName (name) {
    return ProjectRepository.findByName(name)
  }

}

export default ProjectServices