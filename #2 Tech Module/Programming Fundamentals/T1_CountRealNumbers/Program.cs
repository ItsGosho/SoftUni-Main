using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T1_CountRealNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<double> vhod = Console.ReadLine().Split(' ').Select(double.Parse).ToList();
            var result = new SortedDictionary<double, int>();
            foreach (var number in vhod)
            {
                if (result.ContainsKey(number))
                {
                    result[number]++;
                }
                else
                {
                    result.Add(number, 1);
                }
            }
            foreach (KeyValuePair<double, int> doubleNumber in result)
            {
                Console.WriteLine("{0} -> {1}", doubleNumber.Key, doubleNumber.Value);
            }
        }
    }
}
