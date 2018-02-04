using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_DrawAFilledSquare
{
    class Program
    {
        static void Main(string[] args)
        {
            int vhod = int.Parse(Console.ReadLine());
            PrintercheTopBot(vhod);
            for (int i = 0; i < vhod-2; i++)
            {
                PrintercheMiddle(vhod);
            }
            PrintercheTopBot(vhod);
        }
        static void PrintercheTopBot(int n)
        {
            Console.WriteLine(new string('-',n*2));
           
        }
        static void PrintercheMiddle(int n)
        {
            Console.Write("-");
            for (int i = 1; i < n; i++)
            {
                Console.Write("\\/");
            }
            Console.Write("-");
            Console.WriteLine();
        }
    }
}
