#sum1068.py
import sys

def solve(n):
	""" return sum form n to 1"""	
	if n<=1:
		return sum(range(n,2))
	else:
		return sum(range(1,n+1))
def main():
	try:
		number=int(sys.stdin.readline())
		print solve(number)
	except ValueError:
		print 'input number'

if __name__ == "__main__":
    main()