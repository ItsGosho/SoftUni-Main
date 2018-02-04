using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T04_Elevator
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberOfPeople = int.Parse(Console.ReadLine());
            int capacity = int.Parse(Console.ReadLine());
            int courses = (int)Math.Ceiling((double)(numberOfPeople / capacity));
            int remainder = numberOfPeople % capacity;
            if (remainder==0)
            {
                Console.WriteLine(courses);
            }
            else if (remainder!=0)
            {
                Console.WriteLine(courses+1);
            }


           
            
        }
    }
}
