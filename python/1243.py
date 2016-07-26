from sys import stdin, stdout

def main():
    for line in stdin:
        N=int(line.strip())
    if N:
        print N%7


if __name__ == "__main__":
    main()
