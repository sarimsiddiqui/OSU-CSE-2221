import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test arrays, references, and arrays of references.
 *
 * @author Sarim Siddiqui
 *
 */
public final class ArraysAndReferences {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ArraysAndReferences() {
    }

    /**
     * Computes the product of the {@code NaturalNumber}s in the given array.
     *
     * @param nnArray
     *            the array
     * @return the product of the numbers in the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * productOfArrayElements =
     *    [nnArray[0] * nnArray[1] * ... * nnArray[nnArray.length-1]]
     * </pre>
     */
    private static NaturalNumber productOfArrayElements(
            NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        // create product
        NaturalNumber product = new NaturalNumber2(1);

        // for loop to go through each iteration
        for (int i = 0; i < nnArray.length; ++i) {
            // multiply product by the index of the array
            product.multiply(nnArray[i]);
        }
        // return final product
        return product;
    }

    /**
     * Replaces each element of {@code nnArray} with the partial product of all
     * the elements in the incoming array, up to and including the current
     * element.
     *
     * @param nnArray
     *            the array
     * @updates nnArray
     * @requires nnArray.length > 0
     * @ensures <pre>
     * for all i: integer where (0 <= i < nnArray.length)
     *   (nnArray[i] = [#nnArray[0] * #nnArray[1] * ... * #nnArray[i]])
     * </pre>
     */
    private static void computePartialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        // create product
        NaturalNumber product = new NaturalNumber2(1);

        // for loop to go through each iteration
        for (int i = 0; i < nnArray.length; ++i) {
            // multiply product by the index of the array
            product.multiply(nnArray[i]);

            // turn product into int
            int number = product.toInt();
            // create new natural number with int number
            NaturalNumber copy = new NaturalNumber2(number);
            // update array at index i with copy value
            nnArray[i] = copy;
        }

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Initialize an array of NaturalNumbers with values 1 through 42.
         */
        NaturalNumber[] array = new NaturalNumber[42];

        for (int i = 0; i < array.length; i++) {
            NaturalNumber count = new NaturalNumber2(i + 1);
            array[i] = count;
        }
        /*
         * Compute and output the product of the numbers in the array (should be
         * 42!, i.e., the factorial of 42).
         */
        NaturalNumber product = productOfArrayElements(array);

        out.println(product);

        out.close();
    }

}
