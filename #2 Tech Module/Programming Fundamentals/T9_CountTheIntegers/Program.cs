using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T9_CountTheIntegers
{
    class Program
    {
        static void Main(string[] args)
        {
            int counter = 0;
            while (true)
            {
                string n = Console.ReadLine();
                int value;
                if (int.TryParse(n, out value))
                {
                    counter++;
                }
                else
                {
                    Console.WriteLine($"{counter}");
                    Environment.Exit(0);
                }
            }
        }
    }
}
