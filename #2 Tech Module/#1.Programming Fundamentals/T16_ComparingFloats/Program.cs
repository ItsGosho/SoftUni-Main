using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T16_ComparingFloats
{
    class Program
    {
        static void Main(string[] args)  
        {
            decimal a = decimal.Parse(Console.ReadLine());
            decimal b = decimal.Parse(Console.ReadLine());

            decimal eps = 0.000001m;
            if (Math.Abs(a - b) >= eps)
            {
                Console.WriteLine(false);
            }
            else
            {
                Console.WriteLine("True");
            }
        }
    }
}
