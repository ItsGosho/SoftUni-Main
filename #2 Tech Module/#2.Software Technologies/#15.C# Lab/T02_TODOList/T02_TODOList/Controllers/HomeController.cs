using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using T02_TODOList.Models;

namespace T02_TODOList.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            using (var db=new TaskDbContext())
            {
                var tasks = db.Tasks.ToList();
                return View();
            }
        }

    }
}