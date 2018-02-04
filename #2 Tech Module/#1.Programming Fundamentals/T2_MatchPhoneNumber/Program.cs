using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace T2_MatchPhoneNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"\+359( |\-)2(\1)[0-9]{3}(\1)[0-9]{4}\b";
            // string toRegex = @"\+359( |\-)2(\1)\d{3}(\1)\d{4}\b";

            string phones = Console.ReadLine();

            MatchCollection phoneMatches = Regex.Matches(phones, pattern);

            string[] matchesPhones = phoneMatches.Cast<Match>().Select(a => a.Value.Trim()).ToArray();

            Console.WriteLine("{0}", string.Join(", ", matchesPhones));
        }
    }
}
