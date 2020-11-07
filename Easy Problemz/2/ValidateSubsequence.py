def isValidSubsequence(array, sequence):
    # Write your code here.
	flag=False 
	i=0
	if(len(sequence)>len(array)):
	   return False
	if(len(array)==1):
		if(array[0]!=sequence[0]):
			return False
		else:
			return True
	for x in array:
		#Enter if no match yet
		if(flag==False):
			if(x==sequence[i]):
				flag= True
				if((i+1)> (len(sequence)-1)):
					return True
				i=i+1
				
		else:
			#Now, we want to check that
			if(x==sequence[i]):
				if((i+1)> (len(sequence)-1)):
					return True
				i=i+1
			else:
				continue
	
	return False
    pass
