using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T03_ExactSumOfRealNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal vhod = decimal.Parse(Console.ReadLine());
            decimal total = 0;
            for (int i = 0; i < vhod; i++)
            {
                decimal vhodove = decimal.Parse(Console.ReadLine());
                total += vhodove;
            }
            Console.WriteLine(total);
        }
    }
}
