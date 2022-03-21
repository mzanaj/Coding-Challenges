import java.util.*;

class Program {
  public static boolean isMonotonic(int[] array) {
    // Write your code here.
		//Empty 
		if(array.length == 0 || array.length ==1 ){return true;}
		int y=0;
		int x=1;
		
		while(x<array.length ){
			if(array[y] == array[x]){x++;}
			
			else if(array[y] <array[x] ){
					for(int z= x; z < array.length-1; z++){
						if( array[z+1] < array[z]){return false;}
					}
				return true;
				
			}				
			else{ 
			for(int a= x; a < array.length-1; a++){
						if( array[a+1] > array[a]){return false;}
					}
				return true;
		}
		
		}
		
	    return true;
  }
}
