#Time O(n) | Space O(n)
# This is the class of the input root. Do not edit it.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def recursiveFunction(node, tempSum, array):
	#Base case 
	if(node is None):
		return
	#Getting Sum
	currentSum= node.value+tempSum
	#Reached end, append final sum to array
	if(node.left is None and node.right is None):
		array.append(currentSum)
		return
	#Visit all the way to the left
	recursiveFunction(node.left, currentSum, array)
	#Visit right
	recursiveFunction(node.right, currentSum, array)
	
def branchSums(root):
	array=[]
	recursiveFunction(root, 0,array)
	return array
	
