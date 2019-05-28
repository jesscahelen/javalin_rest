f = open("entrada.txt", "r")

l = f.readline()
N, R = [int(l) for l in l.split()]

l = f.readline()

#voltaram
s = [int(l) for l in l.split()]

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

f.close()
f = open("saida.txt", "w")

f.write(' '.join('{}'.format(k) for k in n) + ' ')




