using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace T1_MatchFullName
{
    class Program
    {
        static void Main(string[] args)
        {
            string vhod = Console.ReadLine();
            string regPattern = @"\b[A-Z]{1}[a-z]{1,} [A-Z]{1}[a-z]{1,}\b";
            MatchCollection suvpadeniq = Regex.Matches(vhod, regPattern);
            foreach (var item in suvpadeniq)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();
        }
    }
}
