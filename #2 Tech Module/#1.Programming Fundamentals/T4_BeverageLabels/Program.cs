using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_BeverageLabels
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            double volume = double.Parse(Console.ReadLine());
            double energy = double.Parse(Console.ReadLine());
            double sugar = double.Parse(Console.ReadLine());
            double procent = volume / 100;
            double resulkcal = energy * procent;
            double resultsugars = sugar * procent;
            Console.WriteLine($"{volume}ml {name}:");
            Console.WriteLine($"{resulkcal}kcal, {resultsugars}g sugars");
        }
    }
}
