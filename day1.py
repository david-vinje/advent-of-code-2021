f = [int(x) for x in open('day1.txt').readlines()]

# part one
count = 0
for i in range(len(f)-1):
  if f[i] < f[i+1]:
    count += 1
print(count)

# part two
count = 0
for i in range(len(f)-3):
  if f[i]+f[i+1]+f[i+2] < f[i+1]+f[i+2]+f[i+3]:
    count += 1
print(count)  