
const BaseRequestValidators = {

  notEmpty: (field) => {
    return async (data) => {
      let field = data[field]

      if (field.trim().length === 0) {
        return Promise.reject(`${field} cant be empty!`)
      }
    }
  },

}

export default BaseRequestValidators