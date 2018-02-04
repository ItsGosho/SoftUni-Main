using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T8_GreaterOfTwoValues
{
    class Program
    {
        static void Main(string[] args)
        {
            String type = Console.ReadLine();
            if (type =="int")
            {
                int firstOne = int.Parse(Console.ReadLine());
                int secondOne = int.Parse(Console.ReadLine());
                GetMaxInt(firstOne,secondOne);
            }
            if (type == "char")
            {
                char firstOne = char.Parse(Console.ReadLine());
                char secondOne = char.Parse(Console.ReadLine());
                GetMaxChar(firstOne, secondOne);
            }
            if (type == "string")
            {
                string firstOne = Console.ReadLine();
                string secondOne = Console.ReadLine();
                GetMaxString(firstOne, secondOne);
            }
        }
        static int GetMaxInt(int firstOne,int SecondOne)
        {
            if (firstOne>=SecondOne)
            {
                Console.WriteLine(firstOne);
                return firstOne;
            }
            else
            {
                Console.WriteLine(SecondOne);
                return SecondOne;
            }
            
        }
        static char GetMaxChar(char firstOne,char SecondOne)
        {
            if (firstOne>SecondOne)
            {
                Console.WriteLine(firstOne);
                return firstOne;
            }
            else
            {
                Console.WriteLine(SecondOne);
                return SecondOne;
            }
        }
        static string GetMaxString(string firstOne,string secondOne)
        {
            if (firstOne.CompareTo(secondOne) >=0)
            {
                Console.WriteLine(firstOne);
                return firstOne;
            }
            else
            {
                Console.WriteLine(secondOne);
                return secondOne;
            }
        }
    }
}
