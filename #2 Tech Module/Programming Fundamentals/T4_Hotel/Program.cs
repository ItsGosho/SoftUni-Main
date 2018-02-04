using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_Hotel
{
    class Program
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            double nights = int.Parse(Console.ReadLine());
            double Studio = 0;
            double Double = 0;
            double Suite = 0;
            double discount = 0;
            switch (month)
            {
                case "May":
                case "October":
                    if (nights>7)
                    {
                        Studio = 50*0.95; 
                    }
                    else
                    {
                        Studio = 50;
                    }              
                    Double = 65;
                    Suite = 75;
                    break;
                case "June":
                case "September":
                    Studio = 60;
                    if (nights > 14)
                    {
                        Double = 72 * 0.90;
                    }
                    else
                    {
                        Double = 72;
                    }                   
                    Suite = 82;
                    break;
                case "July":
                case "August":
                case "December":
                    Studio = 68;
                    Double = 77;
                    if (nights > 14)
                    {
                        Suite = 89 * 0.85;
                    }
                    else
                    {
                        Suite = 89;
                    }
                    break;                  

            }
            double StudioT = Studio * nights;
            double DoubleT = Double * nights;
            double SuiteT = Suite * nights;
            Console.WriteLine($"Studio: {StudioT:F2} lv.");
            Console.WriteLine($"Double: {DoubleT:F2} lv.");
            Console.WriteLine($"Suite: {SuiteT:F2} lv.");

        }
    }
}
