
namespace ProjectRider.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using ProjectRider.Models;
    using System.Linq;

    public class ProjectController : Controller
    {
        private readonly ProjectDbContext context;

        public ProjectController(ProjectDbContext context)
        {
            this.context = context;
        }

        [HttpGet]
        [Route("")]
        public ActionResult Index()
        {
            using (var db = new ProjectDbContext())
            {
                var projects = db.Projects.ToList();
                return View(projects);
            }
        }

        [HttpGet]
        [Route("create")]
        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("create")]
        public ActionResult Create(Project project)
        {
            if (ModelState.IsValid)
            {
                using (var db = new ProjectDbContext())
                {
                    db.Projects.Add(project);
                    db.SaveChanges();
                    return Redirect("/");
                }
            }
            return View();
        }

        [HttpGet]
        [Route("edit/{id}")]
        public ActionResult Edit(int id)
        {
            using (var db = new ProjectDbContext())
            {
                var project = db.Projects.Find(id);
                if (project != null)
                {
                    return View(project);
                }
            }
            return Redirect("/");
        }

        [HttpPost]
        [Route("edit/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult EditConfirm(int id, Project projectModel)
        {
            if (!ModelState.IsValid)
            {
                return View(projectModel);
            }

            using (var db = new ProjectDbContext())
            {
                var projectFromDb = db.Projects.Find(projectModel.Id);
                if (projectFromDb != null)
                {
                    projectFromDb.Title = projectModel.Title;
                    projectFromDb.Description = projectModel.Description;
                    projectFromDb.Budget = projectModel.Budget;
                    db.SaveChanges();
                }
            }
            return Redirect("/");
        }

        [HttpGet]
        [Route("delete/{id}")]
        public ActionResult Delete(int id)
        {
            using (var db = new ProjectDbContext())
            {
                var project = db.Projects.Find(id);
                if (project != null)
                {
                    return View(project);
                }
            }
            return Redirect("/");
        }

        [HttpPost]
        [Route("delete/{id}")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirm(int id, Project projectModel)
        {
            using (var db = new ProjectDbContext())
            {
                var project = db.Projects.Find(id);
                if (project != null)
                {
                    db.Projects.Remove(project);
                    db.SaveChanges();
                }
            }
            return Redirect("/");
        }
    }
}
