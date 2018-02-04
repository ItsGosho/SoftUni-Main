using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T5_BooleanVariable
{
    class Program
    {
        static void Main(string[] args)
        {
            String isItBoolean = Console.ReadLine();
            if (Convert.ToBoolean(isItBoolean))
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }

        }
    }
}
