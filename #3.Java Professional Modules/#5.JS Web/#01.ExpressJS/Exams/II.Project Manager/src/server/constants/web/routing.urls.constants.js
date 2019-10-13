const RoutingURLs = {
  HOME: '/',

  USER: {
    LOGIN: '/login',
    REGISTER: '/register',
    LOGOUT: '/logout',
    PROFILE: '/user/profile',
  },

  PROJECT: {
    CREATE: '/project/create',
    ASSIGN: '/project/assign',
    ALL: '/projects/all',
  },

  TEAM: {
    CREATE: '/team/create',
    ASSIGN: '/team/assign',
    ALL: '/teams/all',
  }
}

const UserRoutingURLs = RoutingURLs.USER
const ProjectRoutingURLs = RoutingURLs.PROJECT
const TeamRoutingURLs = RoutingURLs.TEAM

export {
  RoutingURLs,

  UserRoutingURLs,
  ProjectRoutingURLs,
  TeamRoutingURLs,
}