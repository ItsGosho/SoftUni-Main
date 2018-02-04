using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_ChooseADrink2._0
{
    class Program
    {
        static void Main(string[] args)
        {
            var type = Console.ReadLine();
            int price = int.Parse(Console.ReadLine());
            double prehodna = 0;
            switch (type)
            {
                case "Athlete":
                   
                    prehodna += 0.70;
                    break;
                case "Businessman":
                case "Businesswoman":
                    
                    prehodna += 1.00;
                    break;
                case "SoftUni Student":
                   
                    prehodna += 1.70;
                    break;
                default:
                    
                    prehodna += 1.20;
                    break;

            }
            double result = price * prehodna;
            Console.WriteLine($"The {type} has to pay {result:F2}.");
        }
    }
}
