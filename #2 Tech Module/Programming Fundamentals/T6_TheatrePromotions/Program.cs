using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T6_TheatrePromotions
{
    class Program
    {
        static void Main(string[] args)
        {
            var sedmica = Console.ReadLine();
            var age = int.Parse(Console.ReadLine());
            int result = 0;
            if (age < 0 || age > 122)
            {
                Console.WriteLine("Error!");
                Environment.Exit(0);
            }
            if (age >=0 && age <=18)
            {
                if (sedmica.Equals("Weekday"))
                {
                    result += 12;
                }
                if (sedmica.Equals("Weekend"))
                {
                    result += 15;
                }
                if (sedmica.Equals("Holiday"))
                {
                    result += 5;
                }
            }
            if (age > 18 && age <= 64)
            {
                if (sedmica.Equals("Weekday"))
                {
                    result += 18;
                }
                if (sedmica.Equals("Weekend"))
                {
                    result += 20;
                }
                if (sedmica.Equals("Holiday"))
                {
                    result += 12;
                }
            }
            if (age > 64 && age <= 122)
            {
                if (sedmica.Equals("Weekday"))
                {
                    result += 12;
                }
                if (sedmica.Equals("Weekend"))
                {
                    result += 15;
                }
                if (sedmica.Equals("Holiday"))
                {
                    result += 10;
                }

            }
            
            Console.WriteLine($"{result}$");  
        }
        
    }
}
