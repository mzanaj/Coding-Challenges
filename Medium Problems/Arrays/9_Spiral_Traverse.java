import java.util.*;

class Program {
  public static List<Integer> spiralTraverse(int[][] array) {
    // Write your code here.	    // Write your code here.
	
		HashMap<Integer, Boolean> hm = new HashMap<>();
		List<Integer> temp = new ArrayList<Integer>();
		
		int i=0;
		int j=0;
		int n=0;
    int iter=1;
    int temp1= array.length;
    int temp2= array[0].length;
                
	

                
		while(n != array[0].length*array.length){
			
			//Trasverse right elements
			while(j <temp2-iter){
				if(hm.get((i+1)*10+j)!=null){
					i++;
					j--;
					break;

				}
                                //Scheme of poplating hashmap, with appropiate key, value
				hm.put((i+1)*10+j, true);
				temp.add(array[i][j]);
				j++;
				n++;
			}
			//Trasverse down elements
			while(i < temp1-iter){
					if(hm.get((i+1)*10+j)!=null){
					i++;
					j--;
					break;
				}
				temp.add(array[i][j]);
				//Scheme of poplating hashmap, with appropiate key, value
				hm.put((i+1)*10+j, true);
				i++;
				n++;
			}
			
			//Trasverse left elements
			while(j-iter>=0){
					if(hm.get((i+1)*10+j)!=null){
					i--;
					j--;
					break;
				}
				//Scheme of poplating hashmap, with appropiate key, value
				hm.put((i+1)*10+j, true);
				temp.add(array[i][j]);
				j--;
				n++;
			}
                        //Trasverse up elements
			while(i>=0){
					if(hm.get((i+1)*10+j)!=null){
					i++;
					j++;
					break;
				}
				//Scheme of poplating hashmap, with appropiate key, value
				hm.put((i+1)*10+j, true);
				temp.add(array[i][j]);
				i--;
				n++;
			}
                        iter++;
		}
    return temp;

		
  }
}
