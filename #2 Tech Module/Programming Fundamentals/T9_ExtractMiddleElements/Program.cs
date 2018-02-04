using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T9_ExtractMiddleElements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine()
                .Split(' ')
                .Select(int.Parse)
                .ToArray();
           
            if (arr.Length %2==0)
            {
                int first = 0;
                int second = 0;
                for (int i = 0; i < arr.Length/2-1; i++)
                {
                    first++;
                }
                for (int i = 0; i < (arr.Length / 2); i++)
                {
                    second++;
                }
                Console.WriteLine($"{{{arr[first]}, {arr[second]}}}");      
            }
            if (arr.Length % 2 != 0)
            {
                if (arr.Length == 1)
                {
                    Console.WriteLine(arr[0]);
                    return;
                }
                int first = 0; 
                int second = 0;
                int third = 0;
                for (int i = 0; i < arr.Length / 2 - 1; i++)
                {
                    first++;
                }
                for (int i = 0; i < (arr.Length / 2); i++)
                {
                    second++;
                }
                for (int i = 0; i < (arr.Length / 2+1); i++)
                {
                    third++;
                }

                Console.WriteLine($"{{{arr[first]}, {arr[second]}, {arr[third]}}}");

            }
        }
    }
}
