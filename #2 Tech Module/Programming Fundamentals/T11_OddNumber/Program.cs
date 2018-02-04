using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T11_OddNumber
{
    class Program                  
    {
        static void Main(string[] args)
        {
            double n;
            do
            {
                n = double.Parse(Console.ReadLine());
                if (n%2!=0)
                {
                    Console.WriteLine($"The number is: {Math.Abs(n)}");
                    return;
                }
                Console.WriteLine("Please write an odd number.");
                

            } while (n%2==0);
             
        }
    }
}
