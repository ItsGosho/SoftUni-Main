import Mongoose from 'mongoose'
import Format from 'sprintf-js'
import {
  TeamModelValidationMessages,
} from '../../constants/mongo/mongo.validation.constants'
import { TeamModelLogging } from '../../constants/mongo/mongo.logging.constants'
import ModelNames from '../../constants/mongo/mongo.models.constants'

const Schema = Mongoose.Schema
const Type = Schema.Types
const ParseString = Format.sprintf

const model = new Schema({
  name: {
    type: Type.String,
    required: [true, TeamModelValidationMessages.NAME_REQUIRED],
    unique: true,
    trim: true,
  },
  projects: [
    {
      type: Type.ObjectId,
      ref: ModelNames.PROJECT
    }
  ],
  members: [
    {
      type: Type.ObjectId,
      ref: ModelNames.USER
    }
  ]
})

model.post('save', function (team) {
  console.log(ParseString(TeamModelLogging.SAVE, team.name))
})

let TeamModel = Mongoose.model(ModelNames.TEAM, model)

export default TeamModel