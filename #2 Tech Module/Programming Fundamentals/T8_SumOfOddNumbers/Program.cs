using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T8_SumOfOddNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int plusdve = 1;
            int total = 0;
            for (int i = 1; n >= i; i++)
            {
                Console.WriteLine(plusdve);
                plusdve += 2;
                total = i*n;
            }
            Console.WriteLine($"Sum: {total}");
        }
    }
}
