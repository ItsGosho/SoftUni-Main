using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T7_CakeIngredients
{
    class Program
    {
        static void Main(string[] args)
        {
            
            int times = 0;
            for (int i = 0; i < 20; i++)
            {
                String name = Console.ReadLine();
                
                 if (name.Equals("Bake!"))
                {
                    Console.WriteLine($"Preparing cake with {times} ingredients.");
                    return;
                }
                times += 1;
                Console.WriteLine($"Adding ingredient {name}.");
               
               

            }
        }
    }
}
