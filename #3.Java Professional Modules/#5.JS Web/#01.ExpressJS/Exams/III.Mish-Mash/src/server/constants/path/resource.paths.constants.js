import Path from 'path'
import AppRoot from 'app-root-path'

const ResourcePaths = {
  JWT: {
    SECRET: Path.join(AppRoot.path, '/src/resources/jwt.secret.txt')
  },

  FOLDERS: {
    VIEW_FOLDER: Path.join(AppRoot.path, '/src/resources/views'),
    PUBLIC_VIEWS_FOLDER: Path.join(AppRoot.path, '/src/resources/public'),
  },

  VIEWS: {

    OTHER: {
      GUEST_HOME: 'layouts/home/guest-home',
      USER_HOME: 'layouts/home/user-home',
      ADMIN_HOME: 'layouts/home/admin-home',
    },

    AUTHENTICATION: {
      LOGIN: 'layouts/authentication/login',
      REGISTER: 'layouts/authentication/register',
    },

    CHANNEL: {
        CREATE: 'layouts/channel/channel-create',
        DETAILS: 'layouts/channel/channel-details',
        FOLLOWED: 'layouts/channel/followed-channels',
    }
  }
}

const JWTResourcePaths = ResourcePaths.JWT
const FolderResourcePaths = ResourcePaths.FOLDERS
const ViewsResourcePaths = ResourcePaths.VIEWS

export {
  JWTResourcePaths,
  FolderResourcePaths,
  ViewsResourcePaths,
}