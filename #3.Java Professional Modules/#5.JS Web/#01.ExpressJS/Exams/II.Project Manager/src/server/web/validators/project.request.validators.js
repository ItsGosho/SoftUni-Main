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

}

export default ProjectRequestValidators