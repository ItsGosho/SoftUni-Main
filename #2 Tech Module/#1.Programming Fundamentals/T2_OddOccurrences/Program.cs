using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_OddOccurrences
{
    class Program
    {
        static void Main(string[] args)
        {    
            List<string> vhod= Console.ReadLine().ToLower().Split().ToList();
            var result = new Dictionary<string, int>();
            foreach (var strings in vhod)
            {
                if (result.ContainsKey(strings))
                {
                    result[strings]++;
                }
                else
                {
                    result[strings] = 1;
                }    
            }
            List<string> results = new List<string>();

            foreach (KeyValuePair<string, int> strringss in result)
            {
                if (strringss.Value % 2 != 0) 
                {
                    results.Add(strringss.Key);
                }
            }
            Console.WriteLine(string.Join(", ", results));
        }
    }
}
