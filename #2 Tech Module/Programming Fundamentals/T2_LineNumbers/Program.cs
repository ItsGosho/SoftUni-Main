using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_LineNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] text = File.ReadAllLines(@"input.txt");
            for (int i = 0; i < text.Length; i++)
            {
                File.AppendAllText("input.txt", $"{i + 1}. {text[i]}{Environment.NewLine}");
            }
            foreach (var item in text)
            {
                Console.WriteLine(item);
            }
        }
    }
}
