const Project = require('../models').Project;

module.exports = {
    index: (req, res) => {
        Project.findAll().then(projects=>{
            res.render('project/index', {'projects': projects});
        });
    },
    createGet: (req, res) => {
        res.render('project/create');
    },
    createPost: (req, res) => {
        let project = req.body.project;
        Project.create(project).then(project => {
            res.redirect("/");
        }).catch(err => {
            project.error = 'Cannot create project.';
            res.render('project/create', project);
        });
    },
    editGet: (req, res) => {
        let projectId = req.params.id;
        Project.findById(projectId).then(project => {
            if (project) {
                res.render('project/edit',{'project':project});
            }
            else {
                res.redirect('/');
            }
        }).catch(err => res.redirect('/'));
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let args = req.body.project;

        Project.findById(id).then(project => {
            project.updateAttributes(args).then(()=>{
                res.redirect('/')
            });
        });
    },

    deleteGet: (req, res) => {
        let id = req.params.id;
        let args = req.body.project;

        Project.findById(id).then(project => {
            res.render('project/delete',{'project':project});
        });
    },
    deletePost: (req, res) => {
        let id = req.params.id;
        let args = req.body.project; 

        Project.findById(id).then(project => {
            project.destroy().then(()=>{
                res.redirect('/')
            });
        });
    }
};