using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_MaxMethod
{
    class Program
    {  
        static void Main(string[] args)
        {
            int number1 = int.Parse(Console.ReadLine());
            int number2 = int.Parse(Console.ReadLine());
            int number3 = int.Parse(Console.ReadLine());
            int resultForCheck = GetMaxMethod(number1, number2);
            if (resultForCheck>number3)
            {
                Console.WriteLine(resultForCheck);
            }
            else
            {
                Console.WriteLine(number3);
            }
        }
        static int GetMaxMethod(int first,int second)
        {
            if (first>second)
            {
                return first;
            }
            else
            {
                return second;
            }
            
        }
    }
}
