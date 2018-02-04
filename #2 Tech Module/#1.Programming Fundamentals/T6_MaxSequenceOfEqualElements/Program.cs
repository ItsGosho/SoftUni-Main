using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T6_MaxSequenceOfEqualElements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine()
                  .Split(' ')
                  .Select(int.Parse) 
                  .ToArray();
            int plus = 0;
            for (int i = 0; i < arr.Length-1; i++)
            {
                if (arr[i+1]==arr[i])
                {
                    plus++;
                }      
            }
            Console.WriteLine(plus);
        }
    }
}
