class Node:
    def __init__(self, freq, char, left=None, right=None):
       self.freq = freq
       self.char = char
       self.left = left
       self.right = right
       self.huffman = ''

def printNodes(node, val=''):
       newVal = val + str(node.huffman)
       if(node.left):
        printNodes(node.left, newVal)
       if(node.right):
        printNodes(node.right, newVal)
       if(not node.left and not node.right):
        print(f"{node.char}   |  {newVal}") 
chars = input("Enter Charachter String:")
dict_frequency={}
for i in  chars:
    if i in dict_frequency:
        dict_frequency[i]+=1
    else:
        dict_frequency[i]=1
freq=[]
for i in dict_frequency:
    freq.append(dict_frequency[i])
nodes = []

for x in range(len(freq)):
    nodes.append(Node(freq[x], chars[x]))
while len(nodes) > 1:
    nodes = sorted(nodes, key=lambda x: x.freq)
    left = nodes[0]
    right = nodes[1]
    left.huffman = 0
    right.huffman = 1
    newNode = Node(left.freq+right.freq, left.char+right.char, left, right)
    nodes.remove(left)
    nodes.remove(right)
    nodes.append(newNode)
print("Char| Huffman Code")
print("------------------")
printNodes(nodes[0]) 
