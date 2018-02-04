using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
    
namespace T3_RestaurantDiscount
{
    class Program
    {
        static void Main(string[] args)
        {
            double groupsize = double.Parse(Console.ReadLine());
            string package = Console.ReadLine();
            double price = 0;
            string hall = "";
            if (groupsize<=50)
            {
                price += 2500;
                hall = "Small Hall";
            }
            if (groupsize <= 100 && groupsize>=51)
            {
                price += 5000;
                hall = "Terrace";
            }
            if (groupsize <= 120 && groupsize>=101)
            {
                price += 7500;
                hall = "Great Hall";
            }
            if (groupsize>=121)
            {
                Console.WriteLine("We do not have an appropriate hall.");
                Environment.Exit(0);
            }
            double discount = 0;
            double price2 = 0;
            if (package.Equals("Normal"))
            {
                discount += 0.50;
                price2 += 500;
            }
            if (package.Equals("Gold"))
            {
                discount += 0.90;
                price2 += 750;
            }
            if (package.Equals("Platinum"))
            {
                discount += 0.85;
                price2 += 1000;
            }
            double totalprice = price + price2;
            double after = totalprice * discount;
            double priceperperson = after / groupsize;
            Console.WriteLine($"We can offer you the {hall:F2}");
            Console.WriteLine($"The price per person is {priceperperson:F2}$");
        }
    }
}
