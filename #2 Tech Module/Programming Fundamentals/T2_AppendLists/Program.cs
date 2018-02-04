using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_AppendLists
{ 
    class Program
    {  
        static void Main(string[] args)
        {
            string[] numbers = Console.ReadLine().Split('|').ToArray();
            List<int> result = new List<int>();
            for (int i = numbers.Length-1; i >= 0; i--)
            {
                int[] elements = numbers[i]
                    .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray() ;
                result.AddRange(elements);
            }
            Console.WriteLine(String.Join(" ",result));
        }
    }
}
