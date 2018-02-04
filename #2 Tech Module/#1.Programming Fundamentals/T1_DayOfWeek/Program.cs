using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T1_DayOfWeek
{
    class Program
    {
        static void Main(string[] args)
        {
            int WhichDay = int.Parse(Console.ReadLine());
            string[] DaysOfWeek = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
            };
            if (WhichDay>=1 && WhichDay<=7)
            {
                Console.WriteLine(DaysOfWeek[WhichDay-1]);
            }
            else
            {
                Console.WriteLine("Invalid Day!");
            }
}
        }
    }

