import UserModel from '../domain/models/user.model'

const UserRepository = {

  async save (data) {
    return new UserModel(data).save()
  },

  async deleteById (id) {

    return UserModel.deleteOne({ '_id': id }).exec()
  },

  async findById (id) {
    return UserModel.findById(id).exec()
  },

  async findTotal () {
    return UserModel.count({}).exec()
  },

  async findAll () {
    return UserModel.find({}).exec()
  },

  /*-----*/

  async findByUsername (username) {
    return UserModel.findOne({ username }).exec()
  },

  async findByEmail (email) {
    return UserModel.findOne({ email }).exec()
  },
}

export default UserRepository