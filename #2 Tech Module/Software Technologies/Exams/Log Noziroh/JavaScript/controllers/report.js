const Report = require('../models/Report');

module.exports = {
    index: (req, res) => {
        Report.find().then(projects => {
            res.render('report/index', {'reports': projects});
        });
    },
    createGet: (req, res) => {
        res.render('report/create');
    },
    createPost: (req, res) => {
        let project=req.body;
        Report.create(project).then(project=>{
            res.redirect("/");
            console.log('Created!');
        }).catch(err=>{
            project.error='Cannot create project.';
            res.render('report/create',project);
        });
    },
    detailsGet: (req, res) => {
        let projectID = req.params.id;
        Report.findById(projectID).then(project => {
            if (project) {
                res.render('report/details', project );
            }
            else {
                res.redirect('/');
            }
        }).catch(err => res.redirect('/'));
    },
    deleteGet: (req, res) => {
        let projectID = req.params.id;
        Report.findById(projectID).then(project => {
            if (project) {
                return res.render('report/delete', project);
            }
            else {
                return res.redirect('/');
            }
        }).catch(err => res.redirect('/'));
    },

    deletePost: (req, res) => {
        let projectID = req.params.id;
        Report.findByIdAndRemove(projectID).then(project => {
            res.redirect('/');
        }).catch(err => res.redirect('/'));
    }
};