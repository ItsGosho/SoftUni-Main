import ChannelRepository from '../repositories/channel.repository'

const ChannelServices = {

  async findById (id) {
    return ChannelRepository.findById(id)
  },

  async findAll () {
    return ChannelRepository.findAll()
  },

  async create (name, description, tags, type) {
    tags = tags.split(/[, ]+/)

    return ChannelRepository.save({ name, description, tags, type })
  }

}

export default ChannelServices