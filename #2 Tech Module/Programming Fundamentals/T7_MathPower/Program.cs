using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T7_MathPower
{
    class Program
    {
        static void Main(string[] args)
        {
            double chislo = double.Parse(Console.ReadLine());
            double stepen = double.Parse(Console.ReadLine());
            MathPower(chislo,stepen);
        }
        static double MathPower(double chislo,double stepen)
        {
            double total = Math.Pow(chislo,stepen);
            Console.WriteLine(total);
            return total;
        }
    }
}
