using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_CharacterMultiplier
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] lineOfWords = Console.ReadLine().Split();
            char[] firstWord = lineOfWords[0].ToCharArray();
            char[] secondWord = lineOfWords[1].ToCharArray();
            int maxOfTwo = Math.Max(firstWord.Length,secondWord.Length);
            int minOfTwo=Math.Min(firstWord.Length, secondWord.Length);
            bool ravni = false;
            if (firstWord.Length==secondWord.Length)
            {
                ravni = true;
            }
            bool purvotoEPoMalko = false;
            if (firstWord.Length<secondWord.Length)
            {
                purvotoEPoMalko = true;
            }
            bool purvotoEPoGolqmo = false;
            if (firstWord.Length>secondWord.Length)
            {
                purvotoEPoGolqmo = true;
            }
            //DONE RAVNI 
            int result=0;
            if (ravni == true)
            {
                for (int i = 0; i < firstWord.Length; i++)
                {
                   result+= Convert.ToInt32(firstWord[i]) * Convert.ToInt32(secondWord[i]);
                }
            }
            //DONE PURVO PO MALKO 
            if (purvotoEPoMalko==true)
            {
                int toRemove = 0;
                    for (int j = 0; j < minOfTwo; j++)
                    {
                        result+= Convert.ToInt32(firstWord[j]) * Convert.ToInt32(secondWord[j]);
                    toRemove++;
                    }
                if (firstWord.Length < secondWord.Length)
                {
                    for (int i = toRemove; i < maxOfTwo; i++)
                   {
                        result += Convert.ToInt32(secondWord[i]);
                    }
                }                                  
            }
            //NEXT ONE
            if (purvotoEPoGolqmo==true)
            {
                int toRemove = 0;
                for (int j = 0; j < minOfTwo; j++)
                {
                    result += Convert.ToInt32(firstWord[j]) * Convert.ToInt32(secondWord[j]);
                    toRemove++;
                }
                if (secondWord.Length < firstWord.Length)
                {
                    for (int i = toRemove; i < maxOfTwo; i++)
                    {
                        result += Convert.ToInt32(firstWord[i]);
                    }
                }
            }
            Console.WriteLine(result);                     
        }
    }
}
