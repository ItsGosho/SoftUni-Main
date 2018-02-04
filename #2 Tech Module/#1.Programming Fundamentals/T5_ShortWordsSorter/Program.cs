using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T5_ShortWordsSorter
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> input = Console.ReadLine()
            .Split(",.:;()[]\"'\\/!? ".ToArray(), StringSplitOptions.RemoveEmptyEntries)
            .Where(str => str.Length < 5)
            .OrderBy(str => str)
            .Select(str => str.ToLower())
            .Distinct()
            .ToList();

            Console.WriteLine("{0}", string.Join(", ", input));
        }
    }
}
