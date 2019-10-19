import UserRepository from '../repositories/user.repository'
import JWTServices from './jwt.services'
import Bcrypt from 'bcrypt-nodejs'
import Roles from '../domain/models/enums/role.enums'

const SaltRounds = 10

const UserServices = {

  async findById (id) {
    return UserRepository.findById(id)
  },

  async findByEmail (email) {
    return UserRepository.findByEmail(email)
  },

  async register (user) {

    let salt = Bcrypt.genSaltSync(SaltRounds)
    user.password = Bcrypt.hashSync(user.password, salt)

    if (await UserRepository.findTotal() === 0) {
      user.role = Roles.ADMIN
    }

    user = await UserRepository.save(user)
  },

  async isCredentialsValid (username, password) {
    let user = await UserRepository.findByUsername(username)

    if (user !== null) {
      return Bcrypt.compareSync(password, user.password)
    }

    return false
  },

  async proceedToken (username) {
    let user = await UserRepository.findByUsername(username)

    let tokenData = {
      username: user.username,
      role: user.role
    }

    let token = {
      token: await JWTServices.generateToken(tokenData),
      user: user.id
    }

    await JWTServices.removeAllByUserId(user.id)
    return await JWTServices.save(token)
  },

  async findByUsername (username) {
    return UserRepository.findByUsername(username)
  },

  async totalUsers () {
    return UserRepository.findTotal()
  },

  async findAll () {
    return UserRepository.findAll()
  }

}

export default UserServices