f = open("entrada.txt", "r")
l = f.readline()

A, B, C = [int(l) for l in l.split()]
r = ""
if A==B and A==C:
    r = "*\n"
elif A==B and A!=C:
    r = "C\n"
elif C==B and C!=A:
    r = "A\n"
elif A==C and A!=B:
    r = "B\n"

f.close()
f = open("saida.txt", "w")

f.write(r)
f.close()