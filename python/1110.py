'''
http://acm.timus.ru/problem.aspx?space=1&num=1110
'''
import sys

def solve(N,M,Y):
    result=[]

    result=[i for  i in range(0,M) if (i**N)%M==Y]
    return result


def main():
    try:
        Line=sys.stdin.readline()
        N,M,Y=map(int,Line.split())
    except ValueError:
        sys.exit(1)

    result=solve(N,M,Y)
    if not result:
        print -1
    else:
        print ' '.join(map(str,result))




if __name__ == "__main__":
    main()