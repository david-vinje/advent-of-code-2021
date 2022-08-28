f = open('day2.txt').readlines()

# part one
horizonal, depth = 0, 0
for line in f:
  line = line.split(' ')
  direction = line[0]
  amount = int(line[1])
  if direction == 'forward':
    horizonal += amount
  elif direction == 'down':
    depth += amount
  else:
    depth -= amount
print(depth * horizonal)

# part two
horizonal, depth, aim = [0]*3
for line in f:
  line = line.split(' ')
  direction = line[0]
  amount = int(line[1])
  if direction == 'down':
    aim += amount
  elif direction == 'up':
    aim -= amount
  else:
    horizonal += amount
    depth += aim*amount
print(depth * horizonal)
