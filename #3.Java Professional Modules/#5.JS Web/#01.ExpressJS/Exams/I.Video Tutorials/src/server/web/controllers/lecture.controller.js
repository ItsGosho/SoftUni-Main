import Express from 'express';
import RoutingURLs from '../../constants/routing.urls';
import ViewPaths from '../../constants/resource.paths.constants';
import Role from '../middlewares/role.middleware';
import JWTHelper from '../helpers/jwt.helper';
import CourseServices from "../../services/course.services";
import LectureServices from "../../services/lecture.services";


const Router = Express.Router();


Router.get(RoutingURLs.LECTURE.PANEL, async (request, response) => {
    let course = await CourseServices.findById(request.params.id);
    let totalLectures = course.lectures.length;
    let lectures = await LectureServices.findAllByCourseId(course.id);

    response.render(ViewPaths.LECTURE.PANEL, {user: request.user, course, totalLectures, lectures});
});

Router.get(RoutingURLs.LECTURE.DELETE, async (request, response) => {
    /*TODO!*/
    let lecture = await LectureServices.findById(request.params.id);
    await LectureServices.removeById(request.params.id);

    let course = await CourseServices.findById(lecture.course);
    course.lectures = course.lectures.filter(x => x.toString() !== lecture.id);
    course.save();

    let redirectURL = RoutingURLs.LECTURE.PANEL;
    redirectURL = redirectURL.replace(':id', course.id);
    response.redirect(redirectURL);
});

Router.post(RoutingURLs.LECTURE.ADD, async (request, response) => {
    let course = await CourseServices.findById(request.params.id);
    let {title, videoURL} = request.body;

    let lecture = {
        title,
        videoURL,
        course: course.id
    };

    /*TODO!*/
    let result = await LectureServices.save(lecture);
    course.lectures.push(result.id);
    course.save();

    let redirectURL = RoutingURLs.LECTURE.PANEL;
    redirectURL = redirectURL.replace(':id', course.id);
    response.redirect(redirectURL);
});


Router.get(RoutingURLs.LECTURE.PLAY, async (request, response) => {
    let lecture = await LectureServices.findById(request.params.id);
    let lectures = await LectureServices.findAllByCourseId(lecture.course);

    response.render(ViewPaths.VIDEO.PLAY, {user: request.user,lecture, lectures});
});


export default Router;