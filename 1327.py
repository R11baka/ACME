'''
http://acm.timus.ru/problem.aspx?space=1&num=1327
'''
import sys


def main():
    try:
        A=int(sys.stdin.readline())
        B=int(sys.stdin.readline())
    except ValueError:
        sys.exit(1)

    if B%2==0:
        counter=((B-A)+1)/2
    else:
        counter=((B-A)+2)/2
    print counter




if __name__ == "__main__":
    main()