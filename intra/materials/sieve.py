import math

def sieve(n):
  ilist = [0] * n
  ilist[0] = 1
  #for k in range(2, n+1):
  for k in range(2, int(math.sqrt(n+1))):
    for j in range(2, int(math.floor(n/k)+1)):
      ilist[j*k-1] = 1
  return [number+1 for number, i in enumerate(ilist) if i == 0]

print sieve(49)
print sieve(10000)
print [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199]
