using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T3_AMinerTask
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string,int>();
            while (true)
            {
                string ore = Console.ReadLine();
                if (ore == "stop")
                {
                    break;
                }
                int overall = int.Parse(Console.ReadLine());
                if (!dict.ContainsKey(ore))
                {
                    dict.Add(ore,overall);
                }
                else
                {
                    dict[ore] +=overall;
                }
            }
            foreach (var item in dict)
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }
        }  
    }
}
