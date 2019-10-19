import ChannelModel from '../domain/models/channel.model'

const ChannelRepository = {

  async save (data) {
    return new ChannelModel(data).save()
  },

  async deleteById (id) {

    return ChannelModel.deleteOne({ '_id': id }).exec()
  },

  async findById (id) {
    return ChannelModel.findById(id).exec()
  },

  async findTotal () {
    return ChannelModel.count({}).exec()
  },

  async findAll () {
    return ChannelModel.find({}).exec()
  },

  /*-----*/

  async findByName (name) {
    return ChannelModel.findOne({ name }).exec()
  },
}

export default ChannelRepository