import random
import copy

f = open('input.txt', 'r')
rows = f.read().split('\n')
graph = []
allnodes = set()

#construct the graph
for row in rows:
	integerNodes = [int(x) - 1 for x in row.split()]
	node = integerNodes[0]
	allnodes.add(node)
	graph.append(integerNodes[1:])

def merge(x, y, g, nodes):

	for vy in g[y]:
		for index, item in enumerate(g[vy]):
			if(item == y):
				g[vy][index] = x

	g[x] = g[x] + g[y]
	g[x] = [a for a in g[x] if a != x and a != y]
	g[y] = g[x]
	#print (g[x])
	nodes.remove(y)

def minimumCut(graph):
	#print (len(graph))
	iterations = 4000
	min = 231231231232

	for i in range(iterations):
		g = copy.deepcopy(graph)
		nodes = copy.deepcopy(allnodes)

		while len(nodes) > 2:
			#pick x and y randomly
			[x, y] = random.sample(nodes, 2)

			#print (x, y)
			merge(x, y, g, nodes)

		[el] = random.sample(nodes, 1)
		
		ans = len(g[el])
		if ans < min:
			min = ans
	print(min)		


minimumCut(graph)