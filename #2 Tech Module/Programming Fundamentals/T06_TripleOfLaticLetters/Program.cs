using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T06_TripleOfLaticLetters
{
    class Program
    {
        static void Main(string[] args)
        {
            int vhod = int.Parse(Console.ReadLine());
            int navurtqno1 = 0;
            for (int i = 0; i < vhod; i++)
            {
                for (int j = 0; j < vhod; j++)
                {
                    for (int k = 0; k < vhod; k++)         
                    {
                        char letter = (char)('a' + i);
                        char letter1 = (char)('a' + j);
                        char letter2 = (char)('a' + k);
                        Console.Write(letter);
                        Console.Write(letter1);
                        Console.Write(letter2);
                        Console.WriteLine();
                    }
                }
            }
        }
    }
}
