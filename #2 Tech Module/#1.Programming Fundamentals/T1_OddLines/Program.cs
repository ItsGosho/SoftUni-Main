using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T1_OddLines
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = File.ReadAllLines(@"input.txt");
            string[] deli = text.Where((b, a) => a % 2 == 1).ToArray();
            foreach (var item in deli)
            {
                Console.WriteLine(item);
            }
        }
    }
}
