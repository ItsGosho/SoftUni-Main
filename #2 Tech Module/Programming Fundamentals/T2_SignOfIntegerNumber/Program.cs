using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_SignOfIntegerNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int vhod = int.Parse(Console.ReadLine());
            PositiveOrNegative(vhod);
        }
        static int PositiveOrNegative(int n)
        {
           
            if (n>=1)
            {
                Console.WriteLine($"The number {n} is positive.");

            }
            if (n == 0)
            {
                Console.WriteLine($"The number {n} is zero.");
            }
            if (n<=-1)
            {
                  Console.WriteLine($"The number {n} is negative.");
               
            }
            return n;
        }
    }
}
