using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace T2_2.AdvertisementMessage
{
    class Program
    {
        static void Main(string[] args)
        {
            int times = int.Parse(Console.ReadLine());
            Random random = new Random(); 
            string[] Frazi={ "Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
            string[] Subitiq = { "Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!" };
            string[] Avtori = { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva" };
            string[] Gradove = { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };
            int FraziRandom = random.Next(0,Frazi.Length);
            int SubitiqRandom = random.Next(0,Subitiq.Length);
            int AvtoriRandom = random.Next(0,Avtori.Length);
            int GradoveRandom = random.Next(0,Gradove.Length);
            for (int i = 0; i < times; i++)
            {
                Console.Write(Frazi[FraziRandom] + " ");
                Console.Write(Subitiq[SubitiqRandom] + " ");
                Console.Write(Avtori[AvtoriRandom] + " - ");
                Console.Write(Gradove[GradoveRandom]);
            }
        }
    }
}
