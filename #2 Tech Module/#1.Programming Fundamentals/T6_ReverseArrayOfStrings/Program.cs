using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T6_ReverseArrayOfStrings
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] vhod = Console.ReadLine()
               .Split()
               .ToArray();
            for (int i = 0; i < vhod.Length; i++)
            {
                Console.Write($"{vhod[vhod.Length-1-i]} ");
            }
        }
    }
}
