import JWTServices from '../../services/jwt.token.services';
import UserServices from '../../services/user.services';
import Properties from "../../configurations/properties";


const JWTHelper = {

    async getCurrentUser(request) {

        if (request.cookies.jwt === undefined) {
            return null;
        }

        let tokeData = await JWTServices.decode(request.cookies.jwt);
        return await UserServices.findByUsername(tokeData.username);
    },

    async attachToken(token, response) {
        response.cookie(Properties.jwt.cookieName, token, {
            maxAge: Properties.jwt.maxAge,
            httpOnly: Properties.jwt.httpOnly
        });
    },

};

export default JWTHelper;