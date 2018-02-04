using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_ReverseArrayOfIntegers
{
    class Program
    {
        static void Main(string[] args)
        {
            int DuljinaNaArray  = int.Parse(Console.ReadLine());
            int[] ArrayOfInteger = new int[DuljinaNaArray];
            for (int i = 0; i < ArrayOfInteger.Length; i++)
            {
                ArrayOfInteger[i] =int.Parse(Console.ReadLine());
                
            }
            for (int i = DuljinaNaArray-1; i>=0; i--)
            {
                Console.Write($"{ArrayOfInteger[i]} ");
            }
        }
    }
} 
