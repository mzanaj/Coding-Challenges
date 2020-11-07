
def twoNumberSum(array, targetSum):
    # Distinct integers
	array= list(set(array))
	temp = []
	if(len(array)<2):
		return temp
	if(len(array)==2):
		if(array[0]+array[1]==targetSum):
			return array

	i = 1
	size=int(len(array)-1)
	for x in range(len(array)):
		for y in array[i:size]:
			if(array[x]!=y):
				if((array[x]+y)==targetSum):
					temp.append(array[x])
					temp.append(y)
	return list(set(temp))
		
		
