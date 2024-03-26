open FizzBuzz

[<EntryPoint>]
let main argv =
    [0..100]
    |> List.iter (fun i -> printfn "%d: %s" i (fizzbuzz i))
    0 // return an integer exit code