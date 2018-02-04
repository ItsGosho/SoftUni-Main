using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T05_SpecialNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int vhod = int.Parse(Console.ReadLine());
            for (int i = 1; i < vhod+1; i++)
            {
                int SumOfDigits = 0;
                int digits = i;
                while (digits>0)
                {
                    SumOfDigits += digits % 10;
                    digits = digits / 10;
                }
                bool special = SumOfDigits == 5 ||
                    SumOfDigits == 7 ||
                    SumOfDigits == 11;
                Console.WriteLine($"{i} -> {special}");
               
            }
           
        }
    }
}
