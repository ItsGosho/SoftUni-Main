using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_RandomizeWords
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> vhod = Console.ReadLine().Split(' ').ToList();
            Random random = new Random();

            for (int i = 0; i < vhod.Count; i++)
            {
                int zarche = random.Next(0, vhod.Count);
                int zarche2 = random.Next(0, vhod.Count);
                string swap = vhod[zarche];
                vhod[zarche] = vhod[zarche2];
                vhod[zarche2] = swap;
            }
            foreach (var item in vhod)
            {
                Console.WriteLine(item);
            }
        }
    }
}
