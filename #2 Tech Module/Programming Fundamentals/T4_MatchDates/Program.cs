using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace T4_MatchDates
{
    class Program
    {
        static void Main(string[] args)
        {
            string pattern = @"([0-9]{2})(\/|.)([A-Z]{1}[a-z]{2})(\2)([0-9]{4})";
            string vhod = Console.ReadLine();
            MatchCollection rezultati = Regex.Matches(vhod, pattern);
            foreach (Match item in rezultati)
            {
                Console.Write("Day: " + item.Groups[1] + ", ");
                Console.Write("Month: " + item.Groups[3] + ", ");
                Console.Write("Year: " + item.Groups[5]);
                Console.WriteLine();
            }
        }
    }
}
