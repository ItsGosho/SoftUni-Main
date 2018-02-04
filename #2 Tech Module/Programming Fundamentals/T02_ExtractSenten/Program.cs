using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace T02_ExtractSenten
{
    class Program
    {
        static void Main(string[] args)
        {
            string searched = Console.ReadLine();
            string input = Console.ReadLine();
            string pattern = $@"[a-zA-Z0-9,\s]+ {searched} [a-zA-Z0-9,\s\-]+";

            Regex regex = new Regex(pattern);
            MatchCollection matches = regex.Matches(input);

            foreach (var match in matches)
            {
                var x = match.ToString().Trim();

                Console.WriteLine(x);
            }
        }
    }
}
