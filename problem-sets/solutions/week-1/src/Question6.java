import java.util.Arrays;

/**
 * Solution for Missing Number Product Question
 * @author Imad Dodin
 *
 */
public class Question6 {

	public static void main(String[] args) {
		int[] input = new int[] {5, 4, 3, 1};
		System.out.println(Arrays.toString(missingMultiplyBrute(input)));
		System.out.println(Arrays.toString(missingMultiplyNoDS(input)));
		System.out.println(Arrays.toString(missingMultiplyNoDivide(input)));
		
		input = new int[] {5, 4, 3, 0};
		
		System.out.println(Arrays.toString(missingMultiplyBrute(input)));
		System.out.println(Arrays.toString(missingMultiplyNoDS(input)));
		System.out.println(Arrays.toString(missingMultiplyNoDivide(input)));
		
		input = new int[] {0, 5, 4, 3, 0};
		
		System.out.println(Arrays.toString(missingMultiplyBrute(input)));
		System.out.println(Arrays.toString(missingMultiplyNoDS(input)));
		System.out.println(Arrays.toString(missingMultiplyNoDivide(input)));

	}
	
	/**
	 * Perform the operation with a nested loop and additional data structure.
	 * @param numbers - Array of integers to compute
	 * @return array of integers
	 */
	public static int[] missingMultiplyBrute(int[] numbers) {
		int[] out = new int[numbers.length];
		
		// For each integer...
		for(int i = 0; i<numbers.length; i++) {
			int product = 1;
			// Compute product of other integers in array...
			for(int j=0 ; j<numbers.length; j++) {
				if(j==i) continue;
				product *= numbers[j];
			}
			// And store in an external structure.
			out[i] = product;
		}
		
		return out;
	}
	
	/**
	 * Perform the operation with 2-pass and in-place.
	 * @param numbers - Array of integers to compute
	 * @return array of integers
	 */
	public static int[] missingMultiplyNoDS(int [] numbers) {
		// Clone just so we don't have to reconstruct array after 
		// using function.
		int[] copy = numbers.clone();
		
		int product = 1;
		int zeroCount = 0;
		
		// Count zeroes and compute product of non-zero integers.
		for(int i = 0; i<copy.length; i++) {
			if(copy[i] == 0) {
				zeroCount++;
				continue;
			}
			product *= copy[i];
		}
		
		// Fill in result by dividing product by integer
		for(int i = 0 ; i<copy.length; i++) {
			// If more than one zero - the whole array will be zeroes
			if(zeroCount > 1) {
				copy[i] = 0;
				continue;
			}
			
			// Case where we found the single zero in array
			if(copy[i] == 0) {
				// Product will be equal to the product of non-zero integers.
				copy[i] = product;
			} else {
				// Set to 0 if there is a zero in the array, otherwise quotient described above.
				copy[i] = zeroCount == 1 ? 0 : product / copy[i];
			} 
		}
		
		return copy;
	}
	
	/**
	 * Perform the operation in-place without dividing
	 * @param numbers - Array of integers to compute
	 * @return array of integers
	 */
	public static int[] missingMultiplyNoDivide(int[] numbers) {
		// Clone just so we don't have to reconstruct array after 
		// using function.
		int[] clone = numbers.clone();
		
		// Compute product of integers up to the current integer.
		int soFar = 1;
		
		for(int i=0; i<clone.length; i++) {
			// Take product of integers so far...
			int product = soFar;
			for(int j=i+1; j<clone.length; j++) {
				// and multiply by product of integers after the current integer.
				product *= clone[j];
			}
			// Update product of integers so far.
			soFar *= clone[i];
			// Update value of current integer in list.
			clone[i] = product;
			
		}
		return clone;
	}

}
