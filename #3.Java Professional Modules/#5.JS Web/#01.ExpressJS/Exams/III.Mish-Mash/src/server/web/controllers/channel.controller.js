import Express from 'express'
import { RoutingURLs } from '../../constants/web/routing.urls.constants'
import { ViewsResourcePaths } from '../../constants/path/resource.paths.constants'
import ChannelServices from '../../services/channel.services'

const Router = Express.Router()

Router.get(RoutingURLs.CHANNEL.CREATE, async (request, response) => {
  response.render(ViewsResourcePaths.CHANNEL.CREATE, { user: request.user })
})

Router.post(RoutingURLs.CHANNEL.CREATE, async (request, response) => {
  let { name, description, tags, type } = request.body

  let result = await ChannelServices.create(name, description, tags, type)

  let redirectUrl = RoutingURLs.CHANNEL.DETAILS.replace(':id', result._id)
  response.redirect(redirectUrl)
})

Router.get(RoutingURLs.CHANNEL.DETAILS, async (request, response) => {
  let { id } = request.params

  let channel = await ChannelServices.findById(id)
  channel.totalFollowers = channel.followers.length
  channel.tagsJoined = channel.tags.join(', ')

  response.render(ViewsResourcePaths.CHANNEL.DETAILS, { user: request.user, channel: channel })
})

Router.get(RoutingURLs.CHANNEL.FOLLOWED, async (request, response) => {
  let user = request.user

  let followedChannels = []

  for (let id of user.followedChannels) {

    let channel = await ChannelServices.findById(id)
    channel.totalFollowers = channel.followers.length
    followedChannels.push(channel)
  }

  /*TODO: debug to see*/

  response.render(ViewsResourcePaths.CHANNEL.FOLLOWED, { user: request.user, channels: followedChannels })
})

export default Router