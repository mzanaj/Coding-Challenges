import java.util.*;

class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
		int one= arrayOne.length -1;
		int two= arrayTwo.length -1;
                Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int 	min = Math.abs(arrayOne[one]-arrayTwo[two]);
                
		int [] temp = new int [2];
                temp[0]= arrayOne[one];
		temp[1]= arrayTwo[two];

                
		while(one>0 &&  two >0){
			if(arrayOne[one] == arrayTwo[two]){
					temp[0]= arrayOne[one];
					temp[1]= arrayTwo[two];
				return temp;
			}
			else{
				//new min 
				if(Math.abs(arrayOne[one]-arrayTwo[two]) < min){
					temp[0]= arrayOne[one];
					temp[1]= arrayTwo[two];
                                        min= Math.abs(arrayOne[one]-arrayTwo[two]);
				}
			 
				//first out of bound
				if(arrayOne[one] > arrayTwo[two]){
					if(one>0){		one--; }
					
			}else {
					if(two>0){
						two--;
					}
				}
			}
			
		}
                
                if(one==0){
                if(two==0){
                	if(Math.abs(arrayOne[one]-arrayTwo[two]) < min){
					temp[0]= arrayOne[one];
					temp[1]= arrayTwo[two];
								return temp;

				}	
                }else{
                while(two>=0){
                if(Math.abs(arrayOne[one]-arrayTwo[two]) < min){
                    min= Math.abs(arrayOne[one]-arrayTwo[two]);
                    
					temp[0]= arrayOne[one];
					temp[1]= arrayTwo[two];
								

				}
                two--;
                }
                    return temp;
                }
                }
                  ///////////
		
		 if(two==0){
                if(one==0){
                	if(Math.abs(arrayOne[one]-arrayTwo[two]) < min){
					temp[0]= arrayOne[one];
					temp[1]= arrayTwo[two];
								return temp;

				}	
                }else{
                while(one>=0){
                if(Math.abs(arrayOne[one]-arrayTwo[two]) < min){
                    min= Math.abs(arrayOne[one]-arrayTwo[two]);
                    
					temp[0]= arrayOne[one];
					temp[1]= arrayTwo[two];
								

				}
                one--;
                }
                    return temp;
                }
                }
		
		////////
                
              System.out.println(temp[0] + "  "+temp[1]);
		return temp;
			
  }}