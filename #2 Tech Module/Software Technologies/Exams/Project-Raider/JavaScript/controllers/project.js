const Project = require('../models/Project');

module.exports = {
    index: (req, res) => {
        Project.find().then(projects => {
            res.render('project/index', {'projects': projects});
        });
    },
    createGet: (req, res) => {
        res.render('project/create');
    },
    createPost: (req, res) => {
       let project=req.body;
       Project.create(project).then(project=>{
          res.redirect("/");
       }).catch(err=>{
           project.error='Cannot create project.';
          res.render('project/create',project);
       });
    },
    editGet: (req, res) => {
        let projectID = req.params.id;
        Project.findById(projectID).then(project => {
            if (project) {
                res.render('project/edit', project );
            }
            else {
                res.redirect('/');
            }
        }).catch(err => res.redirect('/'));
    },
    editPost: (req, res) => {
        let projectID = req.params.id;
        let project = req.body;

        Project.findByIdAndUpdate(projectID, project, {runValidators: true}).then(projects => {
            res.redirect("/");
        }).catch(err => {
            projects.id = taskId;
            projects.error = "Cannot edit task.";
            return res.render("project/edit", projects);
        });
    },
    deleteGet: (req, res) => {
        let projectID = req.params.id;
        Project.findById(projectID).then(project => {
            if (project) {
                return res.render('project/delete', project);
            }
            else {
                return res.redirect('/');
            }
        }).catch(err => res.redirect('/'));
    },

    deletePost: (req, res) => {
        let projectID = req.params.id;
        Project.findByIdAndRemove(projectID).then(project => {
            res.redirect('/');
        }).catch(err => res.redirect('/'));
    },
};