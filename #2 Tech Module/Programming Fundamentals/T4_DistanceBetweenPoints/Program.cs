using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_DistanceBetweenPoints
{
    class Tochki
    {
        public int TochkaX1 { get; set; }
        public int TochkaX2 { get; set; }
        public int TochkaY1 { get; set; }
        public int TochkaY2 { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int[] rowFirst = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int[] rowSecond = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            Tochki pointsFirstRow = new Tochki();
            pointsFirstRow.TochkaX1 = rowFirst[0];
            pointsFirstRow.TochkaY1 = rowFirst[1];

            Tochki pointsSecondRow = new Tochki();
            pointsFirstRow.TochkaX2 = rowSecond[0];
            pointsFirstRow.TochkaY2 = rowSecond[1];

            Console.WriteLine($"{Calculate(pointsFirstRow, pointsSecondRow):F3}");
        }
        static double Calculate(Tochki a, Tochki b)
        {
            int formulaX = Math.Abs(a.TochkaX1 - a.TochkaX2);
            int formulaY = Math.Abs(a.TochkaY1 - a.TochkaY2);
            double distance = Math.Sqrt(formulaX * formulaX + formulaY * formulaY);
            return distance;
        }
        //GOSHO
    }
}
