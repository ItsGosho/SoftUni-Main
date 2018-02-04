using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T3_UnicodeCharacters
{
    class Program
    {
        static void Main(string[] args)
        {
            var vhod = Console.ReadLine().ToCharArray();
            foreach (var charr in vhod)
            {
                Console.Write("\\u{0}", ((int)charr).ToString("x4"));
            }

        }
    }
}
