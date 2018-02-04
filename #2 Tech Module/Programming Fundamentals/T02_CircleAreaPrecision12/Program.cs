using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T02_CircleAreaPrecision12
{
    class Program
    {
        static void Main(string[] args)
        {
            double vhod = double.Parse(Console.ReadLine());
            double result = Math.PI*vhod*vhod;
            Console.WriteLine($"{result:f12}");

        }
    }
}
