using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_RotateAndSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] vhod = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
            int reverseTimes = int.Parse(Console.ReadLine());
            
            int[] sum = new int[vhod.Length];
          
        }
    }
}
