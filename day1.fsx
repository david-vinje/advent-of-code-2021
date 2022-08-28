// part one
System.IO.File.ReadAllLines("day1.txt")
|> Array.map int
|> Array.pairwise
|> Array.fold (fun acc elem -> 
  if snd elem > fst elem then acc+1 
  else acc) 0

// part two
System.IO.File.ReadAllLines("day1.txt")
|> Array.map int
|> Array.windowed 3
|> Array.map Array.sum
|> Array.pairwise
|> Array.fold (fun acc elem -> 
  if snd elem > fst elem then acc+1 
  else acc) 0