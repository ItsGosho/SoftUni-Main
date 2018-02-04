using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T17_PrintPartOfASCIITable
{
    class Program
    {
        static void Main(string[] args)
        {
            int vhodSTART = int.Parse(Console.ReadLine());
            int vhodEND = int.Parse(Console.ReadLine());
            for (int i = vhodSTART; i < vhodEND+1; i++)
            {
                char chars = (char)i;
                Console.Write($" {chars}");
            }
        }
    }
}
