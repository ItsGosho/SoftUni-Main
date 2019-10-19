import Mongoose from 'mongoose'
import Format from 'sprintf-js'
import {
  ChannelModelValidationMessage
} from '../../constants/mongo/mongo.validation.constants'
import { ChannelModelLogging } from '../../constants/mongo/mongo.logging.constants'
import ModelNames from '../../constants/mongo/mongo.models.constants'
import ChannelTypes from './enums/channel.enums'

const Schema = Mongoose.Schema
const Type = Schema.Types
const ParseString = Format.sprintf

const model = new Schema({
  name: {
    type: Type.String,
    required: [true, ChannelModelValidationMessage.NAME_REQUIRED],
    unique: true,
    trim: true,
  },
  description: {
    type: Type.String,
    required: [true, ChannelModelValidationMessage.DESCRIPTION_REQUIRED],
    trim: true
  },
  tags: [{
    type: Type.String,
  }],
  followers: [{
    type: Type.ObjectId,
    ref: ModelNames.USER
  }],
  type: {
    type: Type.String,
    required: [true, ChannelModelValidationMessage.TYPE_REQUIRED],
    trim: true,
    enum: [ChannelTypes.GAME, ChannelTypes.LESSONS, ChannelTypes.MOTIVATION, ChannelTypes.OTHER, ChannelTypes.RADIO]
  }
})

model.post('save', function (channel) {
  console.log(ParseString(ChannelModelLogging.SAVE, channel.name))
})

let ChannelModel = Mongoose.model(ModelNames.CHANNEL, model)

export default ChannelModel