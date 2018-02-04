using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T13_MagicLetter
{
    class Program
    {
        static void Main(string[] args)
        {
            char firstLetter = char.Parse(Console.ReadLine());
            char lasttLetter = char.Parse(Console.ReadLine());
            char removeLetter = char.Parse(Console.ReadLine());

            for (char first = firstLetter; first <= lasttLetter; first++)
            {
                for (char secound = firstLetter; secound <= lasttLetter; secound++)
                {
                    for (char third = firstLetter; third <= lasttLetter; third++)
                    {
                        if (first.Equals(removeLetter) == false
                            && secound.Equals(removeLetter) == false
                            && third.Equals(removeLetter) == false)
                        {
                            Console.Write("{0}{1}{2} ", first, secound, third);
                        }
                    }
                }
            }
        }
    }
}
