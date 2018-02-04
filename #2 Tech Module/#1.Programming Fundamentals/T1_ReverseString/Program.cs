using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T1_ReverseString
{
    class Program
    {
        static void Main(string[] args)
        {
            string vhod = Console.ReadLine().ToString();
            var result = vhod.Reverse();
            foreach (var item in result)
            {
                Console.Write(item);
            }
        }
    }
}
