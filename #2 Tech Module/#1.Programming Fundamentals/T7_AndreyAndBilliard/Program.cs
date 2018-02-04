using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T7_AndreyAndBilliard
{
    class ShopList
    {
        public Dictionary<string, double> dict { get; set; }
    }
    class Customers
    {
        public Dictionary<string, double> dict { get; set; }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            ShopList ShopList = new ShopList();
            ShopList.dict = new Dictionary<string, double>();
   
            for (int i = 0; i < n; i++)
            {
                List<string> vhod = Console.ReadLine().Split('-').ToList();
                if (!ShopList.dict.ContainsKey(vhod[0]))
                {
                    ShopList.dict[vhod[0]] = double.Parse(vhod[1]);
                }
                else
                {
                    ShopList.dict[vhod[0]] = double.Parse(vhod[1]);
                }
            }
            List<string> klienti = new List<string>();
            Customers Customers = new Customers();
            Customers.dict = new Dictionary<string, double>();
            var namesAndTotal = new Dictionary<string,double>();
            while (true)     
            {
                klienti = Console.ReadLine().Split('-',',').ToList();
                if (klienti.Contains("end of clients"))
                {
                    break;
                }
                namesAndTotal[klienti[0]] = int.Parse(klienti[2]);
                Customers.dict[klienti[1]] = int.Parse(klienti[2]);             
               
            }
            var result = new Dictionary<string, int>();
            foreach (var item in namesAndTotal)
            {
                Console.WriteLine(item.Key);
                Console.Write("-- ");
                foreach (var item2 in Customers.dict)
                {
                    Console.Write(item2.Key+" - "+item.Value);                    
                }
                
            }
        }
    }
}
