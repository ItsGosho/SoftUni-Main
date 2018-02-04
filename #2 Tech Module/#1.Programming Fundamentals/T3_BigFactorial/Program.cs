using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace T3_BigFactorial
{
    class Program
    {
        static void Main(string[] args)
        {
            int vhod = int.Parse(Console.ReadLine());
            BigInteger factorial = 1;
            for (int i = 2; i <= vhod; i++)
            {
                factorial *= i;
            }
            Console.WriteLine(factorial);
        }
    }
}
