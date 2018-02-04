using System;
using System.Collections.Generic;
using System.Linq;  
using System.Text;
using System.Threading.Tasks;

namespace T11_ConvertSpeedUnits
{
    class Program
    {
        static void Main(string[] args)
        {
            int distanceInMeters = int.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());
            int seconds = int.Parse(Console.ReadLine());
            float hourTime = (float)(hours + minutes / 60.0f + seconds / 3600.0f);
            float kmSpeed = (float)(distanceInMeters / 1000 / hourTime);
            float metersSpeed = (float)(kmSpeed / 3.6f);
            float milesSpeed = (float)(distanceInMeters / 1609.0f / hourTime);
            Console.WriteLine($"{metersSpeed}");
            Console.WriteLine($"{kmSpeed}");
            Console.WriteLine($"{milesSpeed}");
        }
    }
}
