'''
http://acm.timus.ru/problem.aspx?space=1&num=1494
'''
import sys
from sys import stdin, stdout
from collections import deque
class Stack(object):
    def __init__(self):
        self.stack = deque()
        self.excluded = set()

    def push(self, N):
        self.stack.append(N)

    def is_empty(self):
        return len(self) == 0

    def pop(self):
        extractedElem = self.stack.pop()
        self.excluded.add(extractedElem)
        return extractedElem

    def peek(self):
        if len(self) == 0:
            return 0
        return self.stack[-1]

    def pushTo(self, N):
        minRange = self._getMinRange()
        if self.peek() < N:
            for i in range(minRange + 1, N + 1):
                self.push(i)

    def _getMinRange(self):
        if len(self.excluded) == 0:
            return self.peek()
        else:
            return max(self.peek(), max(self.excluded))

    def __str__(self):
        return str(self.stack)

    def __len__(self):
        return len(self.stack)

    def isEmpty(self):
        return len(self)==0


def main():
    reader = stdin.read().split()
    reader=map(int,reader)
    N=reader[0]
    stack=Stack()
    for index,elem in enumerate(reader[1:]):
        if stack.isEmpty():
            stack.pushTo(elem)
        if elem>stack.peek():
            stack.pushTo(elem)
        if stack.pop()!=elem:
            print 'Cheater'
            return

    print 'Not a proof'




if __name__ == "__main__":
    main()


