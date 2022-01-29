def seq(n):
    if(n <= 1):
        return n
    else:
        return (seq(n-1) + seq(n-2))

n = int(input("Enter number of terms:"))

print("Fibonacci sequence using Recursion :")
for item in range(n):
    print(seq(item))