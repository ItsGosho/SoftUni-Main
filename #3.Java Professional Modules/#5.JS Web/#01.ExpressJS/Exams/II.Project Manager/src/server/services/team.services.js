import TeamRepository from '../repositories/team.repository'

const TeamServices = {

    async findByName(name) {
        return TeamRepository.findByName(name)
    },

    async findById(id) {
        return TeamRepository.findById(id)
    },

    async create(team) {
        return TeamRepository.save(team)
    },

    async findAll() {
        return TeamRepository.findAll()
    },

    async findByUser(user) {
        let teams = await TeamServices.findAll();

        let result = [];

        for (const team of teams) {
            let test = team.members.filter(x => x.toString() == user._id);

            if (test.length > 0) {
                result.push(team);
            }
        }

        return result;
    }

};

export default TeamServices