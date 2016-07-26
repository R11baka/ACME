'''
http://acm.timus.ru/problem.aspx?num=1080
'''
import sys

class Graph(object):
    def __init__(self, numberVertex):
        self.V = numberVertex
        self.adj = dict()
        for i in range(0, numberVertex):
            self.adj[i] = set()

    def addEdge(self, v, w):
        self.adj[v].add(w)
        self.adj[w].add(v)

    def adj1(self, vertex):
        return self.adj[vertex]


class TwoColor(object):
    def __init__(self, graph):
        self.G = graph
        self.marked = [None] * graph.V
        self.color = [0] * graph.V
        self.twoColorable = True
        self._dfs(graph, 0)

    def _dfs(self, graph, source):
        self.marked[source] = True
        for w in graph.adj1(source):
            if not self.marked[w]:
                self.color[w] = self.invert(self.color[source])
                self._dfs(graph, w)
            elif self.color[w] == self.color[source]:
                self.twoColorable = False
                break

    def invert(self, color):
        if color == 1:
            return 0
        else:
            return 1



def main():
    reader = [map(int, line.split()) for line in sys.stdin.readlines()]
    N = reader[0][0]
    G = Graph(N)
    # print N
    for index, country in enumerate(reader[1:]):
        for c in country:
            if c == 0:
                break
            G.addEdge(index, c - 1)

    tw=TwoColor(G)
    if tw.twoColorable==False:
        print -1
    else:
        print "".join([str(x) for x in tw.color] )

if __name__ == "__main__":
    main()
