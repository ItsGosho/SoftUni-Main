import {
  TeamRequestValidationMessages,
} from '../../constants/web/request.validation.constants'
import TeamServices from '../../services/team.services'

const TeamRequestValidators = {

  nameNotPresent: (field) => {
    let nameField = field

    return async (data) => {
      let name = data[nameField]

      let result = await TeamServices.findByName(name)

      if (result != null) {
        return Promise.reject(TeamRequestValidationMessages.NAME_ALREADY_EXIST)
      }
    }
  },

}

export default TeamRequestValidators