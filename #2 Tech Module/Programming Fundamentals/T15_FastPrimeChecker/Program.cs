using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T15_FastPrimeChecker
{
    class Program
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());
            for (int i = 2; i <= input; i++)
            {
                bool isItDivide = true;
                for (int divide = 2; divide <= Math.Sqrt(i); divide++)
                {
                    if (i % divide == 0)
                    {
                        isItDivide = false;
                        break;
                    }
                }
                Console.WriteLine($"{i} -> {isItDivide}");
            }

        }
    }
}
