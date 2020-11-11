
#Average Time: O(log(n)) | Space: O(l)
#Worst Time: O(n) | Space: O(1)
def findClosestValueInBst(tree, target):
    #How big of a difference between current & target
	initialDifference = abs(tree.value-target)

	#Base case-root == target
	if(tree.value==target):
		return tree.value
	
	#Keep checking until there are no more elemtns left
	while(tree is not None):
		#Update difference if more similar
		if(initialDifference > abs(tree.value-target)):
			initialDifference = abs(tree.value-target)
			node_val=tree.value
		if target > tree.value:
		    tree= tree.right
		elif(target < tree.value):
			tree= tree.left
		elif(initialDifference==0):
			return tree.value
	
	return node_val
	pass

# This is the class of the input tree. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
