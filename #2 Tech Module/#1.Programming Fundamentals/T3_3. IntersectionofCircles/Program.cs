using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T3_3.IntersectionofCircles
{
    class Circle
    {
        public List<int> circle1 { get; set; }
        public List<int> circle2 { get; set; }
        public int x1 { get; set; }
        public int y1 { get; set; }
        public int x2 { get; set; }
        public int y2 { get; set; }
        public int r1 { get; set; }
        public int r2 { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Circle krug = new Circle
            {
                circle1 = Console.ReadLine().Split(' ').Select(int.Parse).ToList(),
                circle2 = Console.ReadLine().Split(' ').Select(int.Parse).ToList(),
            };
            krug.x1 = krug.circle1[0];
            krug.y1 = krug.circle1[1];
            krug.x2 = krug.circle2[0];
            krug.y2 = krug.circle2[1];
            krug.r1 = krug.circle1[2];
            krug.r2 = krug.circle2[2];
            double distance = Math.Sqrt((Math.Pow(krug.x2,2)-Math.Pow(krug.x1,2))+
                (Math.Pow(krug.y2,2)-Math.Pow(krug.y1,2)));
            if (distance<=krug.r1+krug.r2)
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
        }
    }
}
