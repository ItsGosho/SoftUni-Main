using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T8_CaloriesCounter
{
    class Program
    {
        static void Main(string[] args)
        {
            int total = int.Parse(Console.ReadLine());
            int cheese = 0;
            int tomato = 0;
            int salami = 0;
            int pepper = 0;
            for (int i = 0; i < total; i++)
            {
                String bake = Console.ReadLine();
                if (bake.Equals("Cheese", StringComparison.InvariantCultureIgnoreCase))
                {
                    cheese += 500;
                }
                if (bake.Equals("Tomato sauce", StringComparison.InvariantCultureIgnoreCase))
                {
                    tomato += 150;
                }
                if (bake.Equals("Salami", StringComparison.InvariantCultureIgnoreCase))
                {
                    salami += 600;
                }
                if (bake.Equals("Pepper", StringComparison.InvariantCultureIgnoreCase))
                {
                    pepper += 50;
                }
                
            }
            int obshto = salami + pepper + tomato + cheese;
            Console.WriteLine($"Total calories: {obshto}");
        }
    }
}
