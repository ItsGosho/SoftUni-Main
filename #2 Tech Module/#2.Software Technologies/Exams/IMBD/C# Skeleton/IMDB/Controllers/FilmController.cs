namespace IMDB.Controllers
{
    using Microsoft.AspNetCore.Mvc;
    using System.Collections.Generic;
    using System.Linq;
    using Models;

    public class FilmController : Controller
    {
        private readonly IMDBDbContext dbContext;

        public FilmController(IMDBDbContext dbContext)
        {
            this.dbContext = dbContext;
        }

        [HttpGet]
        [Route("")]
        public IActionResult Index()
        {
            using (var db = new IMDBDbContext())
            {
                var films = db.Films.ToList();
                return View(films);
            }
        }

        [HttpGet]
        [Route("/create")]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        [Route("/create")]
        public IActionResult Create(Film film)
        {
            if (ModelState.IsValid)
            {
                using (var db = new IMDBDbContext())
                {
                    db.Films.Add(film);
                    db.SaveChanges();
                    return Redirect("/");
                }
            }
            return View();
        }

        [HttpGet]
        [Route("/edit/{id}")]
        public IActionResult Edit(int? id)
        {
            using (var db = new IMDBDbContext())
            {
                var films = db.Films.Find(id);
                if (films != null)
                {    
                    return View(films);
                }
            }
            return Redirect("/");
        }

        [HttpPost]
        [Route("/edit/{id}")]
        public IActionResult Edit(Film film)
        {
            if (!ModelState.IsValid)
            {
                return View(film);
            }

            using (var db = new IMDBDbContext())
            {
                var filmFromDb = db.Films.Find(film.Id);
                if (filmFromDb != null)
                {
                    filmFromDb.Name = film.Name;
                    filmFromDb.Genre = film.Genre;
                    filmFromDb.Director = film.Director;
                    filmFromDb.Year = film.Year;
                    db.SaveChanges();
                }
            }
            return Redirect("/");
        }

        [HttpGet]
        [Route("/delete/{id}")]
        public IActionResult Delete(int? id)
        {
            using (var db = new IMDBDbContext())
            {
                var film = db.Films.Find(id);
                if (film != null)
                {
                    return View(film);
                }
            }
            return Redirect("/");
        }

        [HttpPost]
        [Route("/delete/{id}")]
        public IActionResult Delete(Film film)
        {
            using (var db = new IMDBDbContext())
            {
                film = db.Films.Find(film.Id);
                if (film != null)
                {
                    db.Films.Remove(film);
                    db.SaveChanges();
                }
            }
            return Redirect("/");
        }
    }
}
