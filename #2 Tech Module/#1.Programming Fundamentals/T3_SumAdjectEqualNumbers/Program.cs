using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T3_SumAdjectEqualNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<decimal> numbers =
                Console.ReadLine()
                .Split()
                .Select(decimal.Parse)
                .ToList();
            bool hasSum = true;
            int index = 0;
            decimal sum = 0;
            while (hasSum)
            {  
                hasSum = false;
                for (int i = 1; i < numbers.Count; i++)
                {
                    if (numbers[i]==numbers[i-1])
                    {
                        index = i - 1;
                        sum = numbers[i] + numbers[i - 1];  
                        hasSum = true;
                        break;
                    }
                }
                if (hasSum)
                {
                    numbers.RemoveRange(index, 2);
                    numbers.Insert(index, sum);
                }
            }
            Console.WriteLine(String.Join(" ",numbers));
        }
    }
}
