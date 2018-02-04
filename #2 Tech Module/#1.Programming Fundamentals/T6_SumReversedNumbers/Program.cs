using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T6_SumReversedNumbers
{
    class Program
    {
        static void Main(string[] args)   
        {
            int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int sum = 0;
            for (int i = 0; i < input.Length; i++)
            { 
                int rev = 0;
                while (input[i] > 0)
                {

                    int r = input[i] % 10;
                    rev = rev * 10 + r;
                    input[i] = input[i] / 10;
                }
                sum += rev;
            }
            Console.WriteLine(sum);
        }
    }
}
