using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T1_LargestCommonEnd
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] vhod1 = Console.ReadLine()
                .Split(' ')
                .ToArray();
            string[] vhod2 = Console.ReadLine()
                .Split(' ')
                .ToArray();
            int minOfTheTwoArrays = Math.Min(vhod1.Length, vhod2.Length);
            int totalLeft = 0;
            int totalRight = 0;
            for (int i = 0; i < minOfTheTwoArrays; i++)
            {
                if (vhod1[i] == vhod2[i])
                {
                    totalLeft++;  
                }
                if (vhod1[vhod1.Length - 1 - i] == vhod2[vhod2.Length - 1 - i])
                {
                    totalRight++;
                }
            }
           
            Console.WriteLine(Math.Max(totalLeft,totalRight));
        }
    }
}
