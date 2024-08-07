
public class ArraySortingClass {
	
	//	Constructor Method
	
	public ArraySortingClass() {
		
	}
	
	
	//	Method for randomizing array
	
	public void Randomize(int[] _array) {
		
		var random = new java.util.Random();
		
		var tempList = new java.util.LinkedList<Integer>();
		
		for (int i : _array) {
			
			tempList.add(i);
		}
		
		int length = _array.length;
		
		for (int i = 0; i < length; i++) {
			
			int randomIndex = random.nextInt(tempList.size());
			
			_array[i] = tempList.remove(randomIndex);
		}
	}
	
	
	//	Method for swapping two elements in array using indexes
	
	private void swap(int[] _array, int _i, int _j) {
		
		int temp = _array[_i];
		_array[_i] = _array[_j];
		_array[_j] = temp;
	}
	
	
	//	Public Method for sorting array using bubbleSort
	
	public void bubbleSort(int[] _array) {
		
		int arrayLength = _array.length;
		
		for (int indexL = 0; indexL < arrayLength - 1; indexL++) {
			
			for (int indexR = indexL + 1; indexR < arrayLength; indexR++) {
				
				//	if left element more than right element, then swap elements
				
				if (_array[indexL] <= _array[indexR]) {
					
					continue;
				}
				
				swap(_array, indexL, indexR);
			}
		}
	}
	
	
	//	Public Method for sorting array using selectionSort
	
	public void selectionSort(int[] _array) {
		
		int arrayLength = _array.length;
		
		int minValueIndex;
		
		for (int indexL = 0; indexL < arrayLength - 1; indexL++) {
			
			minValueIndex = indexL;
			
			//	iterate over remaining part of the array for find index of element with next minimum value
			
			for (int indexR = indexL + 1; indexR < arrayLength; indexR++) {
				
				if (_array[minValueIndex] <= _array[indexR]) {
					
					continue;
				}
				
				minValueIndex = indexR;
			}
			
			//	if there is an element with a value less than the current element, then swap those elements
			
			if (minValueIndex != indexL) {

				swap(_array, indexL, minValueIndex);
			}
		}
	}
	
	
	//	Helper Method for sorting array using insertion sort by _startIndex and _gap(specific step value)
	
	private void insertionSortWithGap(int[] _array, int _startIndex, int _gap) {
		
		//	defining helper variables
		int arrayLength = _array.length;
		
		int i;
		int j;
		
		//	algorithm works like insertion sort, only using gap as step value and specific start index
		for (i = _startIndex + _gap; i < arrayLength; i += _gap) {
			
			//	getting the value of the current element
			int currentElement = _array[i];
			
			//	going back in array and moving elements _gap unit right until find an element that is less than or equal to currentElement
			//	or stop iterating at first index if can not find
			for (j = i; j >= _gap; j -= _gap) {
				
				if (_array[j - _gap] <= currentElement) {
					
					break;
				}
				
				_array[j] = _array[j - _gap];
			}
			
			//	putting currentElement to found index
			_array[j] = currentElement;
		}
	}
	
	
	//	Public Method for sorting array using insertionSort
	
	public void insertionSort(int[] _array) {
		
		//	calling helper method with values _startIndex = 1 and _gap = 1
		insertionSortWithGap(_array, 1, 1);
	}
	
	
	//	Public Method for sorting array using shellSortIterative
	
	public void shellSortIterative(int[] _arrayToSort) {
		
		int gap = _arrayToSort.length;
		
		//	dividing the gap in half each time as long as the gap is greater than 1
		while (gap > 1) {
			
			gap /= 2;
			
			//	calling the insertionSortWithGap method iteratively by using gap value and _startIndex is from 0(inclusive) to gap(exclusive)
			for (int i = 0; i < gap; i++) {
				
				insertionSortWithGap(_arrayToSort, i, gap);
			}
		}
	}
	
	
	//	Public Method for sorting array using shellSortRecursive
	
	public void shellSortRecursive(int[] _arrayToSort) {
		
		int gap = _arrayToSort.length;
		
		shellSortRecursive(_arrayToSort, gap / 2);
	}
	
	
	//	shellSortRecursive Helper Recursive Method for sorting elements in _gap unit intervals
	
	private void shellSortRecursive(int[] _arrayToSort, int _gap) {
		
		//	check if the size of array is less than 1, then finish the operation
		if (_gap < 1) {
			
			return;
		}
		
		//	calling the insertionSortWithGap method recursively by using gap value and _startIndex is from 0(inclusive) to gap(exclusive)
		for (int i = 0; i < _gap; i++) {
			
			insertionSortWithGap(_arrayToSort, i, _gap);
		}
		
		shellSortRecursive(_arrayToSort, _gap / 2);
	}
	
	
	//	Public Method for sorting array using quickSort
	
	public void quickSort(int[] _arrayToSort) {
		
		quickSort(_arrayToSort, 0, _arrayToSort.length - 1);
	}
	
	
	//	quickSort Helper Recursive Method for sorting sub-arrays between _indexL and _indexR (both inclusive)
	
	private void quickSort(int[] _arrayToSort, int _index, int _lastIndex) {
		
		//	check if size of sub-array is 1, then stop recursive calling
		if (_index >= _lastIndex) {
			
			return;
		}
		
		//	getting pivots
		int partitionIndex = getPartitionIndex(_arrayToSort, _index, _lastIndex);
		
		//	sub-array left:
		quickSort(_arrayToSort, _index, partitionIndex - 1);
		
		//	sub-array right:
		quickSort(_arrayToSort, partitionIndex + 1, _arrayToSort.length - 1);
	}
	
	
	//	quickSort Helper Method for grouping array elements by using two pivots and returning new indexes of pivots.
	//	( group_left < _indexL | _indexL < group_middle < _indexR | _indexR < group_right )
	
	private int getPartitionIndex(int[] _array, int _index, int _lastIndex) {
		
		//	next indexes of pivots
		int newIndex = _index;
		
		//	values of pivots
		int pivot = _array[_index];
		
		//	algorithm works like quickSort, only with two pivots
		for (int i = _index + 1; i <= _lastIndex; i++) {
			
			//	if element less than pivotL, then increase the index of left pivot and put the element in group_left by swap
			if (_array[i] < pivot) {
				
				newIndex++;
				swap(_array, newIndex, i);
			}
			
			//	if element is between pivotL and pivotR, then do nothing and let the element stay in group_middle
		}
		
		//	putting pivots to their new indexes
		swap(_array, newIndex, _index);
		
		//	returning new pivot indexes by using array
		return newIndex;
	}
	
	
	//	Public Method for sorting array using dualPivotQuickSort
	
	public void dualPivotQuickSort(int[] _arrayToSort) {
		
		dualPivotQuickSort(_arrayToSort, 0, _arrayToSort.length - 1);
	}
	
	
	//	dualPivotQuickSort Helper Recursive Method for sorting sub-arrays between _indexL and _indexR (both inclusive)
	
	private void dualPivotQuickSort(int[] _arrayToSort, int _indexL, int _indexR) {
		
		//	check if size of sub-array is 1, then stop recursive calling
		if (_indexL >= _indexR) {
			
			return;
		}
		
		//	getting pivots
		int[] partitionIndexes = getPartitionIndexes(_arrayToSort, _indexL, _indexR);
		
		int partitionIndexL = partitionIndexes[0];
		int partitionIndexR = partitionIndexes[1];
		
		//	sub-array left:
		dualPivotQuickSort(_arrayToSort, _indexL, partitionIndexL - 1);
		
		//	sub-array middle:
		dualPivotQuickSort(_arrayToSort, partitionIndexL + 1, partitionIndexR - 1);
		
		//	sub-array right:
		dualPivotQuickSort(_arrayToSort, partitionIndexR + 1, _indexR);
	}
	
	
	//	dualPivotQuickSort Helper Method for grouping array elements by using two pivots and returning new indexes of pivots.
	//	( group_left < _indexL | _indexL < group_middle < _indexR | _indexR < group_right )
	
	private int[] getPartitionIndexes(int[] _array, int _indexL, int _indexR) {
		
		//	check if left pivot is more than right pivot, then swap pivots to ensure "pivotL <= pivotR"
		if (_array[_indexL] > _array[_indexR]) {
			
			swap(_array, _indexL, _indexR);
		}
		
		//	next indexes of pivots
		int newIndexL = _indexL;
		int newIndexR = _indexR;
		
		//	values of pivots
		int pivotL = _array[_indexL];
		int pivotR = _array[_indexR];
		
		//	algorithm works like quickSort, only with two pivots
		for (int i = _indexL + 1; i < newIndexR; i++) {
			
			//	if element less than pivotL, then increase the index of left pivot and put the element in group_left by swap
			if (_array[i] < pivotL) {
				
				newIndexL++;
				swap(_array, newIndexL, i);
			}
			
			//	if element more than pivotR, then decrease the index of right pivot and put the element in group_right by swap
			else if (_array[i] > pivotR) {
				
				newIndexR--;
				swap(_array, newIndexR, i);
				
				i--;
			}
			
			//	if element is between pivotL and pivotR, then do nothing and let the element stay in group_middle
		}
		
		//	putting pivots to their new indexes
		swap(_array, newIndexL, _indexL);
		swap(_array, newIndexR, _indexR);
		
		//	returning new pivot indexes by using array
		return new int[] { newIndexL, newIndexR };
	}
	
	
	//	Public Method for sorting array using mergeSort
	
	public void mergeSort(int[] _array) {
		
		mergeSort(_array, 0, _array.length - 1);
	}
	
	
	//	mergeSort Helper Recursive Method for split array into two parts, and sort them seperately, then merge them finally 
	
	private void mergeSort(int[] _array, int _indexL, int _indexR) {

		//	check if size of sub-array is 1, then stop recursive calling
		if (_indexL >= _indexR)
		{
			return;
		}

		//	find the middle point
		int indexM = (_indexL + _indexR) / 2;
		
		//	sort left and right halves
		mergeSort(_array, _indexL, indexM);
		mergeSort(_array, indexM + 1, _indexR);
		
		//	merge the sorted halves
		merge(_array, _indexL, indexM, _indexR);
	}
	
	
	//	mergeSort Helper Method for merging two sorted array parts by iterate over elements and compare them at each step, finally end up with a single sorted part
	
	private void merge(int[] _array, int _indexL, int _indexM, int _indexR) {
		
		//	get lengths of left and right parts
		int lengthL = _indexM - _indexL + 1;
		int lengthR = _indexR - _indexM;
		
		//	define arrays for parts
		int[] partL = new int[lengthL];
		int[] partR = new int[lengthR];
		
		//	fill the left part
		for (int i = 0; i < lengthL; i++) {

			partL[i] = _array[i + _indexL];
		}
		
		//	fill the right part
		for (int i = 0; i < lengthR; i++) {

			partR[i] = _array[i + _indexM + 1];
		}
		
		//	define index holders
		int indexL = 0;
		int indexR = 0;
		int indexCurrent = _indexL;
		
		//	iterate over elements and compare left and right at each step
		//	iteration ends when left or right part reaches to end
		while (indexL < lengthL && indexR < lengthR) {
			
			if (partL[indexL] <= partR[indexR]) {
				
				//	left element < right element, so add left element to current index of main array
				_array[indexCurrent] = partL[indexL];
				
				//	increase left index
				indexL++;
			}
			else {
				
				//	right element < left element, so add right element to current index of main array
				_array[indexCurrent] = partR[indexR];

				//	increase right index
				indexR++;
			}

			//	increase current index
			indexCurrent++;
		}
		
		//	add remaining left-part elements to main array (if any)
		while (indexL < lengthL) {
			
			_array[indexCurrent] = partL[indexL];
			indexL++;
			indexCurrent++;
		}

		//	add remaining right-part elements to main array (if any)
		while (indexR < lengthR) {
			
			_array[indexCurrent] = partR[indexR];
			indexR++;
			indexCurrent++;
		}
	}
}
