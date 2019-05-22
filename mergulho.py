N, R = [int(value) for value in input().split()]

#voltaram
s = [int(value) for value in input().split()]

#nao voltaram
n = []

if N != R:
    for c in range(1, N+1):
        k = False
        for d in s:
            if d == c:
                k = True
        if not k:
            n.append(c)
else:
    n.append("*")
print(' '.join('{}'.format(k) for k in n) + ' ')




