import Mongoose from 'mongoose'
import Format from 'sprintf-js'
import {
  ProjectModelValidationMessages,
  TeamModelValidationMessages,
} from '../../constants/mongo/mongo.validation.constants'
import { ProjectModelLogging, TeamModelLogging } from '../../constants/mongo/mongo.logging.constants'
import ModelNames from '../../constants/mongo/mongo.models.constants'

const Schema = Mongoose.Schema
const Type = Schema.Types
const ParseString = Format.sprintf

const model = new Schema({
  name: {
    type: Type.String,
    required: [true, ProjectModelValidationMessages.NAME_REQUIRED],
    unique: true,
    trim: true,
  },
  description: {
    type: Type.String,
    required: [true, ProjectModelValidationMessages.DESCRIPTION_REQUIRED],
    maxLength: [50, ProjectModelValidationMessages.DESCRIPTION_TOO_LONG],
    trim: true,
  },
  team: {
    type: Type.ObjectId,
    ref: ModelNames.TEAM
  }
})

model.post('save', function (project) {
  console.log(ParseString(ProjectModelLogging.SAVE, project.name))
})

let ProjectModel = Mongoose.model(ModelNames.PROJECT, model)

export default ProjectModel