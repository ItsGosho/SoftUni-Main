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
      HOME: 'layouts/home/home',
    },

    AUTHENTICATION: {
      LOGIN: 'layouts/authentication/login',
      REGISTER: 'layouts/authentication/register',
    },

    PROJECT: {
      CREATE: 'layouts/project/project-create',
      ALL_ADMIN: 'layouts/project/projects-admin',
      ALL_USER: 'layouts/project/projects-user',
    },

    TEAM: {
      CREATE: 'layouts/team/team-create',
      ALL_ADMIN: 'layouts/team/teams-admin',
      ALL_USER: 'layouts/team/teams-user',
    },

    USER: {
      PROFILE: 'layouts/user/profile'
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