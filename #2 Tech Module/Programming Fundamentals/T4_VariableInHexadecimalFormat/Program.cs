using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_VariableInHexadecimalFormat
{
    class Program
    {
        static void Main(string[] args)
        {
            String Hexadecimal = Console.ReadLine();
            int result = Convert.ToInt32(Hexadecimal, 16);
            Console.WriteLine(result);
        }
    }
}
