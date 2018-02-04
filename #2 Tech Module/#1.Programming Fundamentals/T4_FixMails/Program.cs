using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_FixMails
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> vhod = new List<string>();
            var dict = new Dictionary<string,string>();
            while (true)
            {
                string name = Console.ReadLine();
                if (name == "stop")
                {
                    break;  
                }
                string email = Console.ReadLine();
                if (email.Contains(".us") || email.Contains(".uk"))
                {

                }
                else
                {
                    dict.Add(name, email);
                }  
            }
            foreach (var item in dict)
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }
        }
    }
}
