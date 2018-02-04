using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T07_Greeting
{
    class Program
    {
        static void Main(string[] args)
        {
            String firstName = Console.ReadLine();
            String lastName = Console.ReadLine();
            int years = int.Parse(Console.ReadLine());
            Console.WriteLine($"Hello, {firstName} {lastName}.You are {years} years old.");
        }
    }
}
