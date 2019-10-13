import TeamRepository from '../repositories/team.repository'

const TeamServices = {

  async findByName (name) {
    return TeamRepository.findByName(name)
  },

  async findById (id) {
    return TeamRepository.findById(id)
  },

  async create (team) {
    return TeamRepository.save(team)
  },

  async findAll () {
    return TeamRepository.findAll()
  }

}

export default TeamServices