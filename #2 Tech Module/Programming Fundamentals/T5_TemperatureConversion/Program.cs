using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T5_TemperatureConversion
{
    class Program
    {
        static void Main(string[] args)
        {
            double vhod = double.Parse(Console.ReadLine());
            TempConv(vhod);
        }
        static double TempConv(double farenh)
        {
            farenh = (farenh - 32) * 5 / 9;
            Console.WriteLine($"{farenh:F2}");
            return farenh;
        }
    }
}
