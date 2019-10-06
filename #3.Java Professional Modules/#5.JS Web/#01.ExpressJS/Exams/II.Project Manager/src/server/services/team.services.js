import TeamRepository from '../repositories/team.repository'

const TeamServices = {

  async findByName (name) {
    return TeamRepository.findByName(name);
  }

}

export default TeamServices