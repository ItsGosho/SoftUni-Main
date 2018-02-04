using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T9_MultiplicationTable
{
    class Program       
    {
        static void Main(string[] args)
        { 
            int n = int.Parse(Console.ReadLine());
            int result = 0;
            for (int i = 1; 10>=i; i++)
            {
                result = n * i;
                Console.WriteLine($"{n} X {i} = {result}");
            }
        }
    }
}
