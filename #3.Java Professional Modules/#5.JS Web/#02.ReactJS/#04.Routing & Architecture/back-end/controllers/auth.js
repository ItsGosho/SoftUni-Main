const {validationResult} = require('express-validator/check');
const jwt = require('jsonwebtoken');
const User = require('../models/User');
const encryption = require('../util/encryption');

module.exports = {
    signUp: (req, res, next) => {
        const {username, password, email} = req.body;
        const salt = encryption.generateSalt();
        const hashedPassword = encryption.generateHashedPassword(salt, password);
        User.create({
            email,
            hashedPassword,
            username,
            salt
        }).then((user) => {
            res.status(201)
                .json({message: 'User created!', userId: user._id, username: user.username});
        })
            .catch((error) => {
                if (!error.statusCode) {
                    error.statusCode = 500;
                }

                next(error);
            });
    },
    signIn: (req, res, next) => {
        const {username, password} = req.body;

        User.findOne({username})
            .then((user) => {
                if (!user) {
                    const error = new Error('A user with this username could not be found');
                    error.statusCode = 401;
                    throw error;
                }

                if (!user.authenticate(password)) {
                    const error = new Error('A user with this email could not be found');
                    error.statusCode = 401;
                    throw error;
                }

                const token = jwt.sign({
                        username: user.username,
                        userId: user._id.toString()
                    }
                    , 'somesupersecret'
                    , {expiresIn: '1h'});

                res.cookie('JWT', token, {
                    maxAge: 86_400_000,
                    httpOnly: true
                });

                res.status(200).json(
                    {
                        success: {
                            message: 'User successfully logged in!',
                            data: {
                                userId: user._id.toString(),
                                username: user.username,
                                isAdmin: user.roles.indexOf('Admin') != -1
                            }
                        }
                    });
            })
            .catch(error => {
                if (!error.statusCode) {
                    error.statusCode = 500;
                }

                res.status(error.statusCode).json(
                    {
                        error: {
                            message: error.message,
                            statusCode: error.statusCode
                        }
                    });

                next(error);
            })
    }
};