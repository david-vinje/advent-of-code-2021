import collections

f = open('day3.txt').readlines()
n = len(f[0])-1

# cols = 
cols = ['']*n

# part one
for line in f:
  for i, c in enumerate(list(line.rstrip())):
    cols[i] += c

most_common, least_common = '', ''
for bit in cols:
  counter = collections.Counter(bit)
  most_common += counter.most_common()[0][0]
  least_common += counter.most_common()[1][0]

gamma_rate = int(most_common, 2)
epsilon_rate = int(least_common, 2)
print('power consumption:', gamma_rate * epsilon_rate)

# part two
def find_most_common(lst: list[str], i):
  bits = []
  for line in lst:
    bits.append(line[i])
  counter = collections.Counter(bits)
  if (counter.get('0') == counter.get('1')):
    return '1'
  else:
    return counter.most_common()[0][0]

def find_least_common(lst: list[str], i):
  bits = []
  for line in lst:
    bits.append(line[i])
  counter = collections.Counter(bits)
  if (counter.get('0') == counter.get('1')):
    return '0'
  else:
    return counter.most_common()[1][0]

def find_oxygen_rating(lst: list[str], i):
  bit = find_most_common(lst, i)
  new_lst = []
  for line in lst:
    if bit == line[i]:
      new_lst.append(line.rstrip())
  return new_lst

def find_scrubber_rating(lst: list[str], i):
  bit = find_least_common(lst, i)
  new_lst = []
  for line in lst:
    if bit == line[i]:
      new_lst.append(line.rstrip())
  return new_lst

i = 0
lst = f
while (len(lst) > 1):
  lst = find_oxygen_rating(lst, i)
  i += 1
oxygen_rating = int(lst[0], 2)

i = 0
lst = f
while (len(lst) > 1):
  lst = find_scrubber_rating(lst, i)
  i += 1
scrubber_rating = int(lst[0], 2)

print('life support rating:', oxygen_rating * scrubber_rating)
