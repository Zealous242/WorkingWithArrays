public class Duplicates {
    public static int[] removeTheElement(int[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }
    public static int[] removeDuplicates(int[] arr) {

        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {
                    int shiftLeft = j;
                    for (int k = j+1; k < end; k++, shiftLeft++) {
                        arr[shiftLeft] = arr[k];
                    }
                    end--;
                    j--;
                }
            }
        }

        int[] whitelist = new int[end];
        for(int i = 0; i < end; i++){
            whitelist[i] = arr[i];
        }
        return whitelist;
    }
    public static void main(String[] args) {
        Random rand = new Random();

        String array1Str = new String();
        String array2Str = new String();

        int[] array1 = {rand.nextInt(20) + 1,
                rand.nextInt(20) + 1,
                rand.nextInt(20) + 1,
                rand.nextInt(20) + 1,
                rand.nextInt(20) + 1};

        int[] array2 = {rand.nextInt(20) + 1,
                rand.nextInt(20) + 1,
                rand.nextInt(20) + 1,
                rand.nextInt(20) + 1,
                rand.nextInt(20) + 1};

        removeDuplicates(array1);
        removeDuplicates(array2);

        if(array1[array1.length-1]==array1[array1.length-2]){
            removeTheElement(array1, array1.length-1);
        }
        if(array2[array2.length-1]==array2[array1.length-2]){
            removeTheElement(array2, array2.length-1);
        }

        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + ", ");
        }

        System.out.println(" ");
        System.out.println(" ");

        for(int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + ", ");
        }
        System.out.println(" \n");

        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array2.length; j++){
                if(array1[i]==array2[j]){
                    System.out.println(array1[i] + " from array1 is duplicated in array2");
                }
            }
        }
    }
}
