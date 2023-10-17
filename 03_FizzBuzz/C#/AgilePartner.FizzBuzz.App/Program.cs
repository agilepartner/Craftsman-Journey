using System;
using System.Linq;
using System.Speech.Synthesis;

namespace AgilePartner.FizzBuzz.App
{
    class Program
    {
        static void Main(string[] args)
        {
            var speechSynthesizer = new SpeechSynthesizer();
            speechSynthesizer.SelectVoiceByHints(VoiceGender.Female);
            //speechSynthesizer.Rate = 10;

            Enumerable.Range(1, 100)
                .Select(FizzBuzz.Map)
                .ToList()
                .ForEach(value =>
                {
                    Console.WriteLine(value);
                    speechSynthesizer.Speak(value);
                });

            Console.Read();
        }
    }
}
