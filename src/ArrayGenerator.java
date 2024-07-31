
public class ArrayGenerator {
	
	//	Constructor Method
	
	public ArrayGenerator() {
		
	}
	
	
	//	Method for generating array with equal integers
	
	public int[] generateEqualArray(int _n) {
		
        int[] array = new int[_n];
        
        for (int i = 0; i < _n; i++) {
        	
        	array[i] = 3;
        }
        
        return array;
    }
    
    
    //	Method for generating array with increasing integers

	public int[] generateIncreasingArray(int _n) {
    	
        int[] array = new int[_n];
        
        for (int i = 0; i < _n; i++) {
        	
        	array[i] = i;
        }
        
        return array;
    }
    
    
    //	Method for generating array with decreasing integers

	public int[] generateDecreasingArray(int _n) {
    	
        int[] array = new int[_n];
        
        for (int i = 0; i < _n; i++) {
        	
        	array[i] = _n - i - 1;
        }
        
        return array;
    }
	
	
	//	Method for generating array with random integers

	public int[] generateRandomArray(int _n) {
        
    	var random = new java.util.Random();
    	
        int[] array = new int[_n];
        
        for (int i = 0; i < _n; i++) {
        	
        	array[i] = random.nextInt();
        }
        
        return array;
    }
	
	
	//	Method for generating array with random integers between _minInclusive and _maxExclusive

	public int[] generateRandomArray(int _n, int _minInclusive, int _maxExclusive) {
        
    	var random = new java.util.Random();
    	
        int[] array = new int[_n];
        
        for (int i = 0; i < _n; i++) {
        	
        	array[i] = random.nextInt(_minInclusive, _maxExclusive);
        }
        
        return array;
    }
}
