using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T7_SumArrrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] redica1 = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();
            int[] redica2 = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();
            int n = Math.Max(redica1.Length,redica2.Length);
            int[] sumArr = new int[n];
            for (int i = 0; i < n; i++)
            {
                sumArr[i] = redica1[i % redica1.Length] + redica2[i % redica2.Length];
            }
            Console.WriteLine(string.Join(" ",sumArr));
        }
    }
}
