using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T8_CondenseArrayToNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            while (arr.Length >= 2)
            {
                int[] arrTemporary = new int[arr.Length - 1];
                for (int i = 0; i < arrTemporary.Length; i++)
                {
                    arrTemporary[i] = arr[i] + arr[i + 1];
                }
                arr = arrTemporary;
            }
            Console.WriteLine(arr[0]);  
        }  
    }
}
