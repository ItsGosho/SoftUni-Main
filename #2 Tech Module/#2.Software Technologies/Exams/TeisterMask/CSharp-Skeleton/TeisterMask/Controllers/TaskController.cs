namespace TeisterMask.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using Models;
    using System.Collections.Generic;
    using System.Linq;

    public class TaskController : Controller
    {
        private readonly TeisterMaskDbContext dbContext;

        public TaskController(TeisterMaskDbContext dbContext)
        {
            this.dbContext = dbContext;
        }

        [HttpGet]
        [Route("")]
        public IActionResult Index()
        {
            var tasks = dbContext.Tasks.ToList();
            return View(tasks);
        }

        [HttpGet]
        [Route("/create")]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("/create")]
        [ValidateAntiForgeryToken]
        public IActionResult Create(Task task)
        {
            dbContext.Tasks.Add(task);
            dbContext.SaveChanges();
            return RedirectToAction(nameof(Index));
        }

        [HttpGet]
        [Route("/edit/{id}")]
        public IActionResult Edit(int id)
        {
            var task = dbContext
                .Tasks
                .Where(p => p.Id == id)
                .FirstOrDefault();

            return View(task);
        }

        [HttpPost]
        [Route("/edit/{id}")]
        [ValidateAntiForgeryToken]
        public IActionResult EditConfirm(Task taskModel)
        {
            dbContext.Tasks.Update(taskModel);
            dbContext.SaveChanges(); 
            return RedirectToAction("Index");
        }
    }
}
