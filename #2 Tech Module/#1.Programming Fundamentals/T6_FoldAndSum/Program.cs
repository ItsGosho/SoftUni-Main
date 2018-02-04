using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T6_FoldAndSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            Console.WriteLine(string.Join(" ", arr.Take(arr.Length / 4).Reverse().Concat(arr.Reverse().Take(arr.Length / 4)).ToArray().Select((x, index) => x + arr.Skip(arr.Length / 4).Take(2 * arr.Length / 4).ToArray()[index])));
        }
    }
}
