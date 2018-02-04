using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T5_WordInPlural
{
    class Program
    {
        static void Main(string[] args)
        {
            String text = Console.ReadLine();
            String nounY = "ies";
            String nounOCHSSHXZ = "es";
            String chelnuvano = "s";
            bool cheln = true;
            if (text.EndsWith("y"))
            {
                text = text.Remove(text.Length -1);
                Console.WriteLine($"{text}{nounY}");
                return;

            }
            if (text.EndsWith("o") ||
                text.EndsWith("ch") ||
                text.EndsWith("s") ||
                text.EndsWith("sh") ||
                text.EndsWith("x") ||
                text.EndsWith("z") )    
            {
                
                Console.WriteLine($"{text}{nounOCHSSHXZ}");
                return;

            }
            if (cheln=true)
            {
                Console.WriteLine($"{text}{chelnuvano}");
            }
        }
    }
}
