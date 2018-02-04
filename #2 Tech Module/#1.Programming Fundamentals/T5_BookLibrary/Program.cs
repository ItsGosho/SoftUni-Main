using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T5_BookLibrary
{
    class Library
    {
        public string Name { get; set; }
        public Dictionary<string, double> result { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int times = int.Parse(Console.ReadLine());
            Library library = new Library();
            library.result = new Dictionary<string, double>();

            for (int i = 0; i < times; i++)
            {
                List<string> vhod = Console.ReadLine().Split(' ').ToList();
                if (!library.result.ContainsKey(vhod[1]))
                {
                    library.result.Add(vhod[1],double.Parse(vhod[5]));
                }
                else
                {
                    library.result[vhod[1]] += double.Parse(vhod[5]);
                }
                
            }
            foreach (var pair in library.result.OrderByDescending(x => x.Value).ThenBy(x => x.Key))
            {
                Console.WriteLine("{0} -> {1:F2}", pair.Key, pair.Value);
            }
        }
    }
}
