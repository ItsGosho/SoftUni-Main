using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T13_VowelOrDigit
{
    class Program
    {
        static void Main(string[] args)
        {
            char vhod = char.Parse(Console.ReadLine());
            if (vhod == 'a' || vhod == 'e' || vhod == 'o' || vhod == 'i' || vhod == 'u')
            {
                Console.WriteLine("vowel");
            }
            else if (Char.IsDigit(vhod))
            {
                Console.WriteLine("digit");
            }
            else
            {
                Console.WriteLine("other");
            }
        }
    }
}
