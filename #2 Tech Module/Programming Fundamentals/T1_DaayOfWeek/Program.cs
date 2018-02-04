using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T1_DaayOfWeek
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            string[] dateNumbers = input.Split('-');
            int day = int.Parse(dateNumbers[0]);
            int month = int.Parse(dateNumbers[1]);
            int year = int.Parse(dateNumbers[2]);

            DateTime newDate = new DateTime(year, month, day);

            Console.WriteLine(newDate.DayOfWeek);
        }
    }
}
