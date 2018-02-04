using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T1_HelloName
{
    class Program
    {
        static void Main(string[] args)
        {
            string vhod = Console.ReadLine();
            HelloName(vhod);
        }
        static void HelloName(string input)
        {
            Console.WriteLine($"Hello, {input}!");
        }
    }
}
