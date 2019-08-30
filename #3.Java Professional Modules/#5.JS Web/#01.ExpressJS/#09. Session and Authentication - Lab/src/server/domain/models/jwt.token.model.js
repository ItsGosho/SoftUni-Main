import Mongoose from 'mongoose';
import MongooseConstants from '../../constants/mongoose.constants';


const Schema = Mongoose.Schema;
const Type = Schema.Types;
const {Models} = MongooseConstants;

const jwtTokenModel = new Schema({
    token: {
        type: Type.String,
        required: [true, 'Token is not present!']
    },
    user: {
        type: Type.ObjectID,
        ref: Models.USER
    }
});

jwtTokenModel.post('save', function (token) {
    console.log(`-> `.red + `Token has been created/updated for user with id: ${token.user}`.cyan);
});

jwtTokenModel.post('deleteMany', function (token) {
    console.log(`-> `.red + `${token.deletedCount} tokens have been deleted!`.cyan);
});

let JWTTokenModel = Mongoose.model(Models.JWT, jwtTokenModel);

export default JWTTokenModel;