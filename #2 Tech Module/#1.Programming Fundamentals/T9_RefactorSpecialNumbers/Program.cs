using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T9_RefactorSpecialNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int vhod = int.Parse(Console.ReadLine());
            int total = 0;
            int Chislo = 0;
            for (int i = 1; i <= vhod; i++)
            {
                Chislo = i;
                while (i > 0)
                {
                    total += i % 10;
                    i = i / 10;
                }
                bool ProverkaNaSuotvetstvie = (total == 5) || (total == 7) || (total == 11);
                Console.WriteLine($"{Chislo} -> {ProverkaNaSuotvetstvie}");
                total = 0;
                i = Chislo;
            }

        }
    }
}
