const RoutingURLs = {
  HOME: '/',

  USER: {
    LOGIN: '/login',
    REGISTER: '/register',
    LOGOUT: '/logout',
  },

  CHANNEL: {
    CREATE: '/channel/create',
    DETAILS: '/channel/:id/details',
    FOLLOWED: '/channel/followed',

    FOLLOW: '/channel/:id/follow',
    UNFOLLOW: '/channel/:id/unfollow',
  }

}

const UserRoutingURLs = RoutingURLs.USER

export {
  RoutingURLs,

  UserRoutingURLs,
}