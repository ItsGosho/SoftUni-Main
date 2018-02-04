using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T6_CalculateTriangleArea
{
    class Program
    {
        static void Main(string[] args)
        {
            double vhod = double.Parse(Console.ReadLine());
            double vhod2 = double.Parse(Console.ReadLine());
            TriangleArea(vhod,vhod2);

        }

        static double TriangleArea(double width, double height)
        {
            double total = width * height / 2;
            Console.WriteLine(total);
            return total;
        }
    }
}
