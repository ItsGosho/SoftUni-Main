import JWTServices from '../../services/jwt.token.services';
import UserServices from '../../services/user.services';


const JWTHelper = {

    async getCurrentUser(request) {

        if (request.cookies.jwt === undefined) {
            return null;
        }

        let tokeData = await JWTServices.decode(request.cookies.jwt);
        return await UserServices.findByUsername(tokeData.username);
    },

    async attachToken(token, response) {
        response.cookie('jwt', token, {maxAge: 86400000, httpOnly: true});
    },

};

export default JWTHelper;