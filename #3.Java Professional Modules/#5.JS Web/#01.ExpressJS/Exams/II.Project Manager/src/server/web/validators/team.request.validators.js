import {
  TeamRequestValidationMessages,
} from '../../constants/web/request.validation.constants'
import TeamServices from '../../services/team.services'

const TeamRequestValidators = {

  nameNotPresent: (field) => {
    return async (data) => {
      let name = data[field]

      let result = await TeamServices.findByName(name)

      if (result != null) {
        return Promise.reject(TeamRequestValidationMessages.NAME_ALREADY_EXIST)
      }
    }
  },

}

export default TeamRequestValidators