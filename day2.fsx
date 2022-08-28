type Position = { horizontal: int; depth: int }

// part one
System.IO.File.ReadAllLines("day2.txt")
|> Array.fold (fun acc elem ->
  let a = elem.Split(" ")
  let dir = a[0]
  let amount = int a[1]
  if dir = "forward" then { horizontal = acc.horizontal + amount; depth = acc.depth }
  else if dir = "down" then { horizontal = acc.horizontal; depth = acc.depth + amount}
  else { horizontal = acc.horizontal; depth = acc.depth - amount }
  ) { horizontal = 0; depth = 0 }
  |> fun pos -> pos.depth * pos.horizontal

type Position' = { horizontal: int; depth: int; aim: int }

// part two
System.IO.File.ReadAllLines("day2.txt")
|> Array.fold (fun acc elem ->
  let a = elem.Split(" ")
  let dir = a[0]
  let amount = int a[1]
  if dir = "down" then { horizontal = acc.horizontal; depth = acc.depth; aim = acc.aim + amount }
  else if dir = "up" then { horizontal = acc.horizontal; depth = acc.depth; aim = acc.aim - amount }
  else { horizontal = acc.horizontal + amount; depth = acc.depth + acc.aim*amount; aim = acc.aim }
  ) { horizontal = 0; depth = 0; aim = 0 }
  |> fun pos -> pos.depth * pos.horizontal

