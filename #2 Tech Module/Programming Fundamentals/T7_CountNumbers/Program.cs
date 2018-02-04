using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T7_CountNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            List<int> numbers = Console.ReadLine().Split(new char[] { ' ' },
                    StringSplitOptions.RemoveEmptyEntries).Select(int.Parse)
                .ToList();

            int[] coutList = new int[numbers.Max() + 1];

            foreach (int number in numbers)
            {
                coutList[number]++;
            }

            for (int i = 0; i < coutList.Length; i++)
            {
                if (coutList[i] != 0)
                {
                    Console.WriteLine($"{i} -> {coutList[i]}");
                }
            }
        }
    }
}
