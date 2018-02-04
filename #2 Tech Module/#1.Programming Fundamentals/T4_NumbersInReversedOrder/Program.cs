using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_NumbersInReversedOrder
{
    class Program
    {
        static void Main(string[] args)
        {
            string vhod = Console.ReadLine();
            Reversed(vhod);
           
        }
        static string  Reversed(string number)
        {
            for (int i = number.Length - 1; i >= 0; i--)
            {
                Console.Write(number[i]);
            }
            return number;
        }
    }
}
