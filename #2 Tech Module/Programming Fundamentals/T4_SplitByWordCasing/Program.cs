using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T4_SplitByWordCasing
{                         
    class Program
    {
        static void Main(string[] args)
        {
            List<string> row = Console.ReadLine().Split(',',';',':','.','!','(',')','"','\'','\\','/','[',']',' ').ToList();
            List<string> lowerCaseWord = new List<string>();
            List<string> upperCaseWord = new List<string>();
            List<string> mixedCaseWord = new List<string>();
           
            foreach (var item in row)
            {
                if (item.All(char.IsLower))
                {
                    lowerCaseWord.Add(item);
                }
                else if (item.All(char.IsUpper))
                {
                    upperCaseWord.Add(item);
                }
                else 
                {
                    mixedCaseWord.Add(item);
                }  
            }
            Console.WriteLine("Lower-case: "+String.Join(", ", lowerCaseWord.Where(s => !string.IsNullOrEmpty(s))));
            Console.WriteLine("Mixed-case: " + String.Join(", ", mixedCaseWord.Where(s => !string.IsNullOrEmpty(s))));
            Console.WriteLine("Upper-case: " + String.Join(", ", upperCaseWord.Where(s => !string.IsNullOrEmpty(s))));
        } 
    }
}
