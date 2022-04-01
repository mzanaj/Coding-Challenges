import java.util.*;
//O(n^2); this is silly time 
class Program {
  public int[] arrayOfProducts(int[] array) {
    // Write your code here.
		int [] temp = new int[array.length];
		int count=1;
		
		for(int x=0; x< array.length; x++){
			for(int y=0; y<array.length; y++){
				if(y!=x){
					count *=array[y];
				}
			}
			temp[x]= count;
			count=1;
		}
		
    return temp;
  }
}
