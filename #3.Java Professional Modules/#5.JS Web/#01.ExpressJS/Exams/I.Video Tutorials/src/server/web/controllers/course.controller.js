import Express from 'express';
import RoutingURLs from '../../constants/routing.urls';
import ViewPaths from '../../constants/resource.paths.constants';
import Role from '../middlewares/role.middleware';
import JWTHelper from '../helpers/jwt.helper';
import CourseServices from "../../services/course.services";
import UserServices from "../../services/user.services";
import LectureServices from "../../services/lecture.services";


const Router = Express.Router();


Router.get(RoutingURLs.COURSE.CREATE, async (request, response) => {
    response.render(ViewPaths.COURSE.CREATE, {user: request.user});
});

Router.post(RoutingURLs.COURSE.CREATE, async (request, response) => {
    let {title, description, imageURL, isPublic} = request.body;

    let course = {
        title,
        description,
        imageURL,
        isPublic: isPublic === 'on' ? true : false,
        lectures: []
    };

    await CourseServices.save(course);

    response.redirect(RoutingURLs.BASE.HOME);
});

Router.get(RoutingURLs.COURSE.EDIT, async (request, response) => {
    let course = await CourseServices.findById(request.params.id);
    response.render(ViewPaths.COURSE.EDIT, {user: request.user, course});
});

Router.post(RoutingURLs.COURSE.EDIT, async (request, response) => {
    let course = await CourseServices.findById(request.params.id);

    let {title, description, imageURL} = request.body;

    course.title = title;
    course.description = description;
    course.imageURL = imageURL;
    course.save();

    response.redirect(RoutingURLs.BASE.HOME);
});

Router.get(RoutingURLs.COURSE.DETAILS, async (request, response) => {
    let course = await CourseServices.findById(request.params.id);
    let user = await JWTHelper.getCurrentUser(request);

    if (user.enrolledCourses.filter(x => x.toString() === request.params.id).length === 0) {
        response.render(ViewPaths.COURSE.NOT_ENROLLED_IN, {user: request.user, course});
    } else {
        let lectures = await LectureServices.findAllByCourseId(course.id);
        response.render(ViewPaths.COURSE.ENROLLED_IN, {user: request.user, course,lectures});
    }
});

Router.post(RoutingURLs.COURSE.ENROLL, async (request, response) => {
    let courseId = request.params.id;
    let user = await JWTHelper.getCurrentUser(request);

    user.enrolledCourses.push(courseId);
    user.save();

    let redirectURL = RoutingURLs.COURSE.DETAILS;
    redirectURL = redirectURL.replace(':id', courseId);
    response.redirect(redirectURL);
});

export default Router;