import {
  TeamRequestValidationMessages,
} from '../../constants/web/request.validation.constants'
import TeamServices from '../../services/team.services'
import UserServices from '../../services/user.services'

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

  userNotAssigned: (user, team) => {
    let userField = user
    let teamField = team

    return async (data) => {
      let userId = data[userField]
      let teamId = data[teamField]

      team = await TeamServices.findById(teamId)
      let result = team.members.filter(x=> x.toString() === userId).length;

      if (team.members.filter(x=> x.toString() === userId).length > 0) {
        return Promise.reject(TeamRequestValidationMessages.USER_ALREADY_EXIST)
      }
    }
  },

}

export default TeamRequestValidators