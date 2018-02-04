using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T6_IntervalOfNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1 = int.Parse(Console.ReadLine());
            int n2 = int.Parse(Console.ReadLine());
            //42 & 48
            if (n1<n2) {
                Console.WriteLine(n1);
                do
                {                
                    n1++;
                    Console.WriteLine(n1);

                } while (n1 < n2);
                
                
            }
           
            // 100 & 14
            if (n1>n2) {
                do
                {
                    Console.WriteLine(n2);
                    n2++;

                } while (n1>=n2);
            }
        }
    }
}
