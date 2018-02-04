using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
    
namespace T14_IntegerToHexBinary
{
    class Program
    {
        static void Main(string[] args)
        {
            int vhod = int.Parse(Console.ReadLine());
            string firstOutPutLine =Convert.ToString(vhod, 16).ToUpper();
            string secondOutPutLine = Convert.ToString(vhod, 2);
            Console.WriteLine(firstOutPutLine);
            Console.WriteLine(secondOutPutLine);
        }
    }
}
