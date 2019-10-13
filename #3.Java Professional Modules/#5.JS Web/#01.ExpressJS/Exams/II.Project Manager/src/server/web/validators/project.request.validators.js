import {
  ProjectRequestValidationMessages,
  TeamRequestValidationMessages,
} from '../../constants/web/request.validation.constants'
import TeamServices from '../../services/team.services'
import ProjectServices from '../../services/project.services'

const ProjectRequestValidators = {

  nameNotPresent: (field) => {
    let nameField = field;

    return async (data) => {
      let name = data[nameField]

      let result = await ProjectServices.findByName(name)

      if (result != null) {
        return Promise.reject(ProjectRequestValidationMessages.NAME_ALREADY_EXIST)
      }
    }
  },

  projectNotAssigned: (project, team) => {
    let projectField = project
    let teamField = team

    return async (data) => {
      let id = data[projectField]
      project = await ProjectServices.findById(id);

      if (project.team !== undefined) {
        return Promise.reject('Project already have team!')
      }
    }
  },

}

export default ProjectRequestValidators