using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T3_SearchForANumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();
            int[] options = Console.ReadLine().Split().Select(int.Parse).ToArray();
            List<int> taken = new List<int>();
            for (int i = 0; i < options[0]; i++)
            {
                taken.Add(numbers[i]);
            }
            Console.WriteLine(String.Join(" ",taken));
                taken.RemoveRange(0,options[1]);
            Console.WriteLine(String.Join(" ", taken));
            for (int i = 0; i < taken.Count; i++)     
            {
                if (taken[i]==options[2])
                {
                    Console.WriteLine("YES!");
                    return; 
                }
                else if(taken[i] !=options[2])
                {
                    Console.WriteLine("NO!");
                    return;
                }
            } 

        }
    }
}
