using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T5_SortNumbers 
{
    class Program
    {
        static void Main(string[] args)
        {
            List<decimal> vhod = Console.ReadLine().Split(' ').Select(decimal.Parse).ToList();
            vhod.Sort();
            Console.WriteLine(String.Join(" <= ",vhod));
        }
    }
}
