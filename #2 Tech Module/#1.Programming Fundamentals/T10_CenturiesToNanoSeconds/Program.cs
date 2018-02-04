using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T10_CenturiesToNanoSeconds
{
    class Program
    {
        static void Main(string[] args)
        {
            byte centuries = byte.Parse(Console.ReadLine());
            short years =(short)(centuries * 100);
            int days = (int)(years * 365.2422);
            long hours = days * 24;
            long minutes = hours * 60;
            //-----
            long seconds = minutes * 60;
            ulong miliseconds=(ulong)(minutes*60000);
            decimal microseconds = (decimal)(seconds * 1000000);
            decimal nanoseconds = microseconds*1000;
            Console.Write($"{centuries} centuries = ");
            Console.Write($"{years} years = ");
            Console.Write($"{days} days = ");
            Console.Write($"{hours} hours = ");
            Console.Write($"{minutes} minutes = ");
            Console.Write($"{seconds} seconds = ");
            Console.Write($"{miliseconds} milliseconds = ");
            Console.Write($"{microseconds} microseconds = ");
            Console.Write($"{nanoseconds} nanoseconds");
        }
    }
}
