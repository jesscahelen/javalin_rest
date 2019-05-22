A, B, C = [int(value) for value in input().split()]

if A==B and A==C:
    print("*")
elif A==B and A!=C:
    print("C")
elif C==B and C!=A:
    print("A")
elif A==C and A!=B:
    print("B")

