'''
http://acm.timus.ru/problem.aspx?space=1&num=1910
'''

from sys import stdin, stdout
def main():
    reader = stdin.read().split()
    reader=map(int,reader)
    i=0
    l=[]
    while i<len(reader)-2:
        if reader[i]==reader[i+1]==reader[i+2]:
            l.append([reader[i],i])

        i=i+1
        pass
    l.sort(key=lambda x:x[0],reverse=True)
    print l[0][0]*3,l[0][1]+1



if __name__ == "__main__":
    main()
