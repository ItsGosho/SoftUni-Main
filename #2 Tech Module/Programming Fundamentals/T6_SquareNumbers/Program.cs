using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T6_SquareNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> vhod = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            List<int> result = new List<int>(); 
            foreach (var item in vhod)
            {
                if (Math.Sqrt(item) == (int)Math.Sqrt(item))
                {
                    result.Add(item);
                }
            }
            result.Sort((a, b) => b.CompareTo(a));
            Console.WriteLine(String.Join(" ",result));
        }
    }
}
