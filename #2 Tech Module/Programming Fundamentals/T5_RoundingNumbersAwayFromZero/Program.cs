using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T5_RoundingNumbersAwayFromZero
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] vhod = Console.ReadLine()
                .Split()
                .Select(double.Parse)
                .ToArray();
            for (int i = 0; i < vhod.Length; i++)
            {
                Console.WriteLine($"{vhod[i]}=>{vhod[i] = Math.Round(vhod[i], MidpointRounding.AwayFromZero)}");
                
            }
        }
    }
}
