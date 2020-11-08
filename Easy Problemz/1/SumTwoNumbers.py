
#Time O(n^2) | Space O(1)
def twoNumberSum(array, targetSum):
    # Distinct integers
	array= list(set(array))
	temp = []
	#Base Cases
	if(len(array)<2):
		return temp
	if(len(array)==2):
		if(array[0]+array[1]==targetSum):
			return array
	
	#Loop through each element & check against each element after current (n*m), where m=n-1~n^2
	i = 1
	size=int(len(array)-1)
	for x in range(len(array)):
		for y in array[i:size]:
			if(array[x]!=y):
				if((array[x]+y)==targetSum):
					temp.append(array[x])
					temp.append(y)
	return list(set(temp))
		
		
#Time O(n) | Space O(n) 
def twoNumberSum(array, targetSum):
	#X+Y=targetSum, Y=targetSum-X
	nums= {}
	#If Y appears in the hash table (dictionary) , then that means that it satisfies the sum requirements
	for num in array:
		if targetSum-num in nums:
			return[targetSum-num,num]
		else:
			nums[num]=True
	return []
    pass

#Time O(nlogn) | space O(1)
def twoNumberSum(array, targetSum):
	
	#Use pointers given a sorted array
	pointer1= 0
	pointer2= len(array)-1
	
	array.sort()
	temp= []
	while pointer1 < pointer2:
		if(array[pointer1]+array[pointer2]==targetSum):
			temp.append(array[pointer1])
			temp.append(array[pointer2])
			pointer1 +=1
		elif array[pointer1]+array[pointer2]<targetSum:
			pointer1 +=1
		elif array[pointer1]+array[pointer2]>targetSum:
			pointer2 -=1
	return temp
    pass

