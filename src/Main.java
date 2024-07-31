
@FunctionalInterface
interface ISortingMethod {
	
    void sortingMethod(int[] _array);
}

public class Main {
	
	private static ArraySortingClass arraySortingClass;
	
	
	//	Main Method

	public static void main(String[] args) {
		
		arraySortingClass = new ArraySortingClass();
		
		ArraySortEfficiencyTest();
		
		System.out.println();

		ArraySortTest();
	}
	
	
	//	Example efficiency testing
	
	public static void ArraySortEfficiencyTest() {
		
		var arrayGenerator = new ArrayGenerator();
		
		int[] array;
		
		//	Shell Random:
		
		array = arrayGenerator.generateRandomArray(1000);
		calculateTime(arraySortingClass::shellSortRecursive, "Random_Integers", array);
		
		array = arrayGenerator.generateRandomArray(10000);
		calculateTime(arraySortingClass::shellSortRecursive, "Random_Integers", array);
		
		array = arrayGenerator.generateRandomArray(100000);
		calculateTime(arraySortingClass::shellSortRecursive, "Random_Integers", array);
	}
	
	
	//	Example sorting method usage
	
	public static void ArraySortTest() {
		
		var arrayGenerator = new ArrayGenerator();
		
		int[] array;
		
		array = arrayGenerator.generateRandomArray(50, 0, 100);
		
		array = arrayGenerator.generateDecreasingArray(50);
		
		printArray(array);
		
		arraySortingClass.quickSort(array);
		
		printArray(array);
	}
	
	
	//	Method for calculate estimated time using shellSort
	
	private static void calculateTime(ISortingMethod _sortingMethod, String _arrayType, int[] _array) {
		
		long startTimeNano = System.nanoTime();
		
		_sortingMethod.sortingMethod(_array);
		
		long estimatedTimeNano = System.nanoTime() - startTimeNano;
		
		double estimatedTimeMilli = estimatedTimeNano / 1000000d;
		
		String output
				= "ShellSort: "
				+ "arrayType = " + _arrayType + " | "
				+ "arraySize = " + _array.length + " | "
				+ "estimatedTime = " + estimatedTimeMilli + " ms.";
		
		System.out.println(output);
	}
	
	
	//	Method for debug
	
	public static void printArray(int[] _array) {
		
		for (int i = 0; i < _array.length; i++) {
			
			System.out.print(_array[i] + ",");
		}
		
		System.out.println();
	}
}
