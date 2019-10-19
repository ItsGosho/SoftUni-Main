const BaseRequestValidators = {

  notEmpty: (field) => {
    let fieldCopy = field

    return async (data) => {
      let field = data[fieldCopy]

      if (field !== undefined && field.trim().length === 0) {
        return Promise.reject(`${fieldCopy} cant be empty!`)
      }
    }

  },

}

export default BaseRequestValidators