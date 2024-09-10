public class DynamicArray {
    private Object[] baseArray;

    // constructors
    
    // initialize a base array
    public DynamicArray(String dataType, int length) {
        // dataType = string
        if (dataType.equals("String")) {
            baseArray = new String[length];
        }
        // dataType != string
        else {
            System.out.println("That data type is not supported");
        }   
    }

    // methods

    // get
    public Object get(int index) {
        // condition to make sure index value is in array length
        if (index > baseArray.length){ // fail
            System.out.println("Invalid index");
            return null;
        }
        else { // pass
            return baseArray[index];
        }
    }


    // set
    public Object set(int index, String i) {
        // condition to make sure index value is in array length
        if (index > baseArray.length){ // fail
            System.out.println("Invalid index");
            return null;
        }
        else { // pass
            // set new value
            baseArray[index] = i;

            // return new value at index
            return baseArray[index];
        }
    }


    // toString as "print()"
    public Object print(DynamicArray array) {
        // print array as a string
        // iterate through values in array and add them to a string
        // then, return string

        // create a new string to hold array values
        String string = new String();

        // iterate through values in array in increments of 1 from index 0 to the end of the array
        for (int index = 0; index < baseArray.length; index++) {
            if (index == 0) { // if the first value in array
                string += ((String) get(index)); // not adding a space to the first value
            }
            else { // otherwise, if not the first value in array
                string += " " + ((String) get(index)); // adding a space between values
            }
        }
        
        return string;
    }

    // add
    public Object add(String i) {
        // make new array that is 1 longer than base array (for now only supporting 1 addition at a time)
        // take base array length and add 1
        // iterate through new empty array and assign values using set(), including new index position at the end

        String dataType = "String"; // temp placeholder
        
        //figure out how long list is
        int length = baseArray.length;

        // add to length
        int newLength = length + 1;

        // make new empty array
        DynamicArray newArray = new DynamicArray(dataType, newLength);

        // store values of baseArray
        for (int index = 0; index < baseArray.length; index++) {
            newArray.set(index, (String) get(index));
        }

        // finalize new array
        newArray.set(length, i);
        baseArray = newArray.baseArray;
        
        // return new array
        return baseArray;
    }


    // remove
    public Object remove(String i) {
        // make new array that is 1 shorter than base array (for now only supporting 1 removal at a time)
        // take base array length and remove 1
        // iterate through new empty array and assign values using set()

        String dataType = "String"; // temp placeholder
        
        //figure out how long list is
        int length = baseArray.length;

        // subtract from length
        int newLength = length - 1;

        // make new empty array
        DynamicArray newArray = new DynamicArray(dataType, newLength);

        // store values of baseArray
        for (int index = 0; index < baseArray.length; index++) {
            if (!baseArray[index].equals(i)) {
                newArray.set(index, (String) get(index));
            }
            else {
                // make exception case
            }
        }

        // finalize new array
        baseArray = newArray.baseArray;
        
        // return new array
        return baseArray;
    }   


    // splice
    public Object splice(int startIndex, String i) {
        // insert one sequence into another at the designated start point
        // take length, add one, and choose what index to add the new value to

        String dataType = "String"; // temp placeholder
        
        //figure out how long list is
        int length = baseArray.length;

        // add to length
        int newLength = length + 1;

        // make new empty array
        DynamicArray newArray = new DynamicArray(dataType, newLength);

        for (int index = 0; index < (baseArray.length + 1); index++) {
            if (index < startIndex) {
                newArray.set(index, (String) get(index));
            }
            else if (index == startIndex) {
                newArray.set(startIndex, i);
            }
            else if (index > startIndex) {
                if (index == startIndex + 1) {
                    newArray.set(index, (String) get(index - 1));
                } 
                else {
                    newArray.set(index, (String) get(index - 1));
                }
            }
        }

        // finalize new array
        baseArray = newArray.baseArray;

        // return new array
        return baseArray; 
    }


    // slice
    public Object slice(int startIndex, int endIndex) {
        // extract one sequence

        // establish data type
        String dataType = "String"; // temp placeholder
        
        // figure out how long list is
        int sliceLength = endIndex - startIndex + 1;
        System.out.println("Slice length: " + sliceLength);

        // make new empty array to hold slice
        DynamicArray slice = new DynamicArray(dataType, sliceLength);

        // track new index
        int newIndex = 0;

        // save segment to new array, and remove from old array
        // need separate loops for the two arrays?
         for (int index = startIndex; index <= endIndex; index++) { // starting at the start index, increment index by 1 until reaching end index
            slice.set(newIndex++, (String) get(index)); // use the set() function to add old value to its new spot in the array
        }

        // return new array
       return slice;        
    }


    // main
    public static void main(String[] args) {
        System.out.println(""); // line break
        System.out.println("Testing array creation...");
        System.out.println("Creating an array of data type 'String' and length of 4");
        DynamicArray dynamicArray = new DynamicArray("String", 4);
        System.out.println("Array created");
        System.out.println(""); // line break

        System.out.println("Confirming array creation...");
        // System.out.println("Array data type: " + dynamicArray.baseArray.dataType);
        System.out.println("Array length: " + dynamicArray.baseArray.length);
        System.out.println(""); // line break

        // test set
        System.out.println("Testing set()...");
        dynamicArray.set(0, "One");
        dynamicArray.set(1, "Two");
        dynamicArray.set(2, "Three");
        dynamicArray.set(3, "Four");
        System.out.println("Array values set");
        System.out.println(""); // line break

        // testing print
        System.out.println("Testing print()...");
        System.out.println(("Your array as a string: " + dynamicArray.print(dynamicArray)));
        System.out.println(""); // line break

        // test get
        System.out.println("Testing get()...");
        System.out.println("Value at index 0: " + dynamicArray.get(0));
        System.out.println("Value at index 1: " + dynamicArray.get(1));
        System.out.println("Value at index 2: " + dynamicArray.get(2));
        System.out.println("Value at index 3: " + dynamicArray.get(3));
        System.out.println("Array values got");
        System.out.println(""); // line break

        // test add
        System.out.println("Testing add()...");
        dynamicArray.add("Five");
        System.out.println("Value(s) added");
        System.out.println(""); // line break

        // confirm whether add worked
        System.out.println("Confirming add worked...");
        System.out.println("Value at index 0: " + dynamicArray.get(0));
        System.out.println("Value at index 1: " + dynamicArray.get(1));
        System.out.println("Value at index 2: " + dynamicArray.get(2));
        System.out.println("Value at index 3: " + dynamicArray.get(3));
        System.out.println("Value at index 4: " + dynamicArray.get(4) + " (new!!)");
        System.out.println(""); // line break

        // test remove
        System.out.println("Testing remove()...");
        System.out.println("Current length: " + dynamicArray.baseArray.length);
        dynamicArray.remove("Five");
        System.out.println("Value(s) removed");
        System.out.println(""); // line break

        // confirm whether remove worked
        System.out.println("Confirming remove worked...");
        System.err.println("New length: " + dynamicArray.baseArray.length);
        System.out.println(""); // line break
        System.out.println("Value at index 0: " + dynamicArray.get(0));
        System.out.println("Value at index 1: " + dynamicArray.get(1));
        System.out.println("Value at index 2: " + dynamicArray.get(2));
        System.out.println("Value at index 3: " + dynamicArray.get(3));
        System.out.println(""); // line break

        // test splice
        System.out.println("Testing splice()...");
        System.out.println("Current length: " + dynamicArray.baseArray.length);
        System.out.println("Splicing 'One and a half' at index 1...");
        dynamicArray.splice(1, "One and a half");
        System.out.println("Value(s) spliced");
        System.out.println(""); // line break

        // confirm whether splice worked
        System.out.println("Confirming splice worked...");
        System.err.println("New length: " + dynamicArray.baseArray.length);
        System.out.println(""); // line break
        System.out.println("Value at index 0: " + dynamicArray.get(0));
        System.out.println("Value at index 1: " + dynamicArray.get(1));
        System.out.println("Value at index 2: " + dynamicArray.get(2));
        System.out.println("Value at index 3: " + dynamicArray.get(3));
        System.out.println("Value at index 4: " + dynamicArray.get(4));
        System.out.println(""); // line break

        // test slice
        System.out.println("Testing slice()...");
        System.out.println("Current length: " + dynamicArray.baseArray.length);
        System.out.println("Slicing from index 1 to index 3");
        DynamicArray slice = (DynamicArray) dynamicArray.slice(1, 3);
        System.out.println("Value(s) sliced");
        System.out.println(""); // line break

        // confirm whether slice worked
        System.out.println("Confirming slice worked...");
        System.out.println("Extraction length: " + slice.baseArray.length); 
        System.out.println(""); // line break
        System.out.println("Value at index 0: " + dynamicArray.get(0));
        System.out.println("Value at index 1: " + dynamicArray.get(1));
        System.out.println("Value at index 2: " + dynamicArray.get(2));
        System.out.println(""); // line break
    }
}
