using System;
using System.Speech.Synthesis;

namespace AgilePartner.FizzBuzz.App
{
    class Program
    {
        static void Main(string[] args)
        {
            var fizzBuzz = new FizzBuzz();
            var speechSynthesizer = new SpeechSynthesizer();
            speechSynthesizer.SelectVoiceByHints(VoiceGender.Female);
            //speechSynthesizer.Rate = 10;

            for (int i = 1; i <= 100; i++)
            {
                var value = fizzBuzz.Map(i);

                Console.WriteLine(value);
                speechSynthesizer.Speak(value);
            }
            Console.Read();
        }
    }
}
