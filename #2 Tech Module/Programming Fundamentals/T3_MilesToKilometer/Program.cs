using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T3_MilesToKilometer
{
    class Program
    {
        static void Main(string[] args)
        {
            double n1 = double.Parse(Console.ReadLine());
            double sum = n1 * 1.60934;
            Console.WriteLine($"{sum:F2}");

        }
    }
}
