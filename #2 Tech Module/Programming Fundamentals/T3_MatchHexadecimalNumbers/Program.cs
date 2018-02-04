using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace T3_MatchHexadecimalNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"\b(?:0x)?[0-9A-F]+\b";
            string vhod = Console.ReadLine();
            MatchCollection suvpadeniq = Regex.Matches(vhod, pattern);
            foreach (var item in suvpadeniq)
            {
                Console.Write(item + " ");
            }
        }
    }
}
