using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T3_WordCount
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] threeWords = File.ReadAllText(@"words.txt").ToLower().Split(' ');
            string[] AllWords = File.ReadAllText(@"text.txt").ToLower().Split(' ');
            for (int i = 0; i < AllWords.Length; i++)
            {
               
                if (AllWords[i].Equals(threeWords[1]))
                {
                    Console.WriteLine("Yes");
                }
            }
        }
    }
}
