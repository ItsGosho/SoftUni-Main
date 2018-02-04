using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_Largest3Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> vhod = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            List<int> result = vhod.OrderByDescending(x => x).Take(3).ToList();
            Console.WriteLine(String.Join(" ",result));
        }
    }
}
