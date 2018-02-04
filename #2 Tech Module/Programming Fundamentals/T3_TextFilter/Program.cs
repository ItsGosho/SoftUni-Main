using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T3_TextFilter
{
    class Program
    {
        static void Main(string[] args)
        {
            var badWords = Console.ReadLine().Split(',', ' ').
                Where(x => x.Length > 0).ToArray();
            var text = Console.ReadLine();
            foreach (var badWord in badWords)
            {
                var replacement = new string('*', badWord.Length);
                text = text.Replace(badWord, replacement);
            }
            Console.WriteLine(text);
        }
    }
}
