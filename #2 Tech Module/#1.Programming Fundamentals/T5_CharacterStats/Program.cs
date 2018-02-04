using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T5_CharacterStats
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            int health = int.Parse(Console.ReadLine());
            int totalHealth = int.Parse(Console.ReadLine());
            int energy = int.Parse(Console.ReadLine());
            int totalEnergy = int.Parse(Console.ReadLine());
            Console.WriteLine($"Name: {name}");
            Console.WriteLine("Health: |" + new string('|', health) +
                new string('.', totalHealth - health) + "|");
            Console.WriteLine("Energy: |" + new string('|', energy) +
               new string('.', totalEnergy - energy) + "|");

        }
    }
}
