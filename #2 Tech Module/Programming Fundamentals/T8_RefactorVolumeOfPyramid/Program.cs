using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T8_RefactorVolumeOfPyramid
{
    class Program
    {
        static void Main(string[] args)
        { 
            Console.Write("Length: ");
            Double Length = double.Parse(Console.ReadLine());
            Console.Write("Width: ");
            Double Width = double.Parse(Console.ReadLine());
            Console.Write("Height: ");
            Double Height = double.Parse(Console.ReadLine());
            double PyramidVolume = (Length * Width * Height)/3;
            Console.WriteLine("Pyramid Volume: {0:F2}", PyramidVolume);

        }
    }
}
