import BodyParser from 'body-parser'
import Morgan from 'morgan'
import Flash from 'express-flash'
import Session from 'express-session'
import CookieParser from 'cookie-parser'
import MiddlewaresConfiguration from './middlewares.configuration'
import AuthenticationController from '../web/controllers/authentication.controller'
import HomeController from '../web/controllers/base.controller'
import ChannelController from '../web/controllers/channel.controller'
import Properties from './properties'
import HandleBars from 'express-handlebars'
import { FolderResourcePaths } from '../constants/path/resource.paths.constants'
import { hasRoleHandlebarsHelper, handlebarsNotificationHelper } from '../helpers/handlebars.helpers'

export default (app) => {
  app.use(Morgan(Properties.morgan.environment))

  app.use(BodyParser.urlencoded({ extended: Properties.bodyParser.extended }))
  app.use(BodyParser.json())
  app.use(BodyParser.raw())
  app.use(BodyParser.text())

  app.use(CookieParser())
  app.use(Session({ secret: 'JoretoSecret' }))
  app.use(Flash())

  app.use(MiddlewaresConfiguration(app))

  app.use(AuthenticationController)
  app.use(HomeController)
  app.use(ChannelController)

  app.use('/public', require('express').static(FolderResourcePaths.PUBLIC_VIEWS_FOLDER))

  app.set('views', FolderResourcePaths.VIEW_FOLDER)

  app.engine('.hbs', HandleBars({
    defaultLayout: 'index',
    extname: '.hbs',
    helpers: {
      notification: handlebarsNotificationHelper,
      hasRole: hasRoleHandlebarsHelper
    },
    layoutsDir: `${FolderResourcePaths.VIEW_FOLDER}\\layouts`,
    partialsDir: `${FolderResourcePaths.VIEW_FOLDER}\\partials`,
  }))

  app.set('view engine', '.hbs')
}