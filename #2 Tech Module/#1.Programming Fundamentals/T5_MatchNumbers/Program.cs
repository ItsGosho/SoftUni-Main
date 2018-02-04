using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace T5_MatchNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"(^|(?<=\s))-?\d+(\.\d+)?($|(?=\s))";
            string vhod = Console.ReadLine();
            MatchCollection rezultati = Regex.Matches(vhod, pattern);
            foreach (Match item in rezultati)
            {
                Console.Write(item + " ");
            }
        }
    }
}
