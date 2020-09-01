package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.*;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello world");
    }

    @And("I perform actions with {string} and {string}")
    public void iPerformActionsWithMyAnd(String str1, String str2) {
        String result;
        System.out.println("1: String 1: " + str1);
        System.out.println("1: String 2: " + str2);
        System.out.println("2: String 1 Upper case: " + str1.toUpperCase());
        System.out.println("2: String 2 Upper case: " + str2.toUpperCase());
        System.out.println("3: Length of String 1: " + str1.length());
        System.out.println("3: Length of String 2: " + str2.length());
        if (str1.equals(str2))
            result="Yes";
        else
            result="No";
        System.out.println("4: Is String 1 equal String 2?: " + result);
        if (str1.equalsIgnoreCase(str2))
            result="Yes";
        else
            result="No";
        System.out.println("5: Is String 1 equal String 2 ignoring cases?: " + result);
        if (str1.contains(str2))
            result="Yes";
        else
            result="No";
        System.out.println("6: Does String 1 contain String 2?: " + result);
        System.out.println("------------------------------------------------");

    }

    @And("I work with String")
    public void iWorkWithString() {
        String s1 = "foobar";
        String s2 = "foobar";
        String s3 = "foo"+"bar";

        System.out.println(s1 == s2);
        System.out.println(s1==s3);

        s2 = new String("foobar");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    @And("I calculate numbers")
    public void iCalculateNumbers() {

        int i=5;
        Integer ii=2;
        double f = 2.;
        float a = 0.5f;
        System.out.println(i/ii);
        System.out.println(i/f);
        System.out.println(a/3);
        int num1 = 555;
        int num2 = 123;
        int sum =  num1+num2;
        int difference = num1-num2;
        int quotient = num1/num2;
        int product = num1*num2;


    }

    @When("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        switch (site){
            case "google":
                System.out.println("http://www.google.com");
                break;
            case "sample":
                System.out.println("https://skryabin.com/webdriver/html/sample.html");
                break;
            default:
                System.out.println("Sorry, " + site + " is unknown site");
        }


    }


    @And("My favorite color is {string}")
    public void myFavoriteColorIs(String color) {

    }

    @And("I work with arrays")
    public void iWorkWithArrays() {

        String[] groceryList = {"salmon", "rise", "wine"};

        System.out.println(groceryList);
        System.out.println(groceryList[0]);
        System.out.println(groceryList[2]);

        System.out.println();
        for (String item : groceryList) {
            System.out.println(item);
        }
        for (int i=0; i< groceryList.length; i++)
        {
            System.out.println(groceryList[i]);
        }


    }

    @And("And I print if number {string} is positive")
    public void andIPrintIfNumberIsPositive(String myNum) {
        if (Integer.valueOf(myNum) > 0 )
        {
            System.out.println("Positive");
        }
        else if (Integer.valueOf(myNum) < 0)
        {
            System.out.println("Negative");
        }
        else
        {
            System.out.println("It is Zero!");
        }
    }

    @And("I print {string} th day of week")
    public void iPrintThDayOfWeek(String day) {
        switch (Integer.valueOf(day)){
            case 1:
                System.out.println("Monday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("It is not a day");

        }


    }

    @And("I work with map")
    public void iWorkWithMap() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");

        String swap;
        swap = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", swap);

        for(String key : info.keySet()) {
            System.out.println(key + ": " + info.get(key));
        }

    }

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        int n, m;
        n = 15;
        m = 10;
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");

        swapMap(info);
        swap(n, m);

        System.out.println(n);
        System.out.println(m);

        int[] numbers = {5, 2, 9, 7, 3};
        System.out.println("---------------------------");
        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\n---------------------------");

        swapElementsInArray(numbers, 3, 5);

        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
        String S;
        S = divisibleInt(17);
        System.out.println(S);
        S = divisibleInt(12);
        System.out.println(S);
        S = divisibleInt(6);
        System.out.println(S);
        S = divisibleInt(8);
        System.out.println(S);

    }

    void swap(int a, int b)
    {
        a = a + b;
        b = a - b;
        a = a - b;

    }

    void swapElementsInArray(int[] arr, int index1, int index2)
    {
        int temp;
        temp = arr[index1-1];
        arr[index1-1] = arr[index2-1];
        arr[index2-1] = temp;
    }

    public String divisibleInt(int number)
    {
        String result = "";
        if (number % 3 == 0)
        {
            if(number %4 == 0)
            {
                result = "Divisible by 3 and 4";
            }
            else
            {
                result = "Divisible by 3";
            }
        }else if (number % 4 == 0)
        {
            result = "Divisible by 4";
        }
        else{
            result = "not divisible by 3 or 4";
        }
        return result;
    }

    void swapMap(Map<String, String> info)
    {
        System.out.println("info: " + info );

        String temp = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", temp);

        System.out.println("info: " + info );

    }


    @And("I solve more coding challenges")
    public void iSolveMoreCodingChallenges() {
//        PrintNumFrom0(10);
//        System.out.println();
//
//        PrintAllNumbers(-10, -5);
//        System.out.println();
//
//        int[] myArray = {2, 5, 6, 7, 8, 9, 9, 9, 0 ,-5, -23};
//        int[] array = {};
//        PrintArray(myArray);
//        System.out.println();
//
//        PrintEvenNum(myArray);
//        System.out.println();
//
//        System.out.println(IsEmpty(array));
//        System.out.println(IsEmpty(myArray));
//
//        System.out.println(ContainsElement(myArray, 100));
//
//        //PrintFizzBuzz(20);
        String s = "Hello Everyone!";

        System.out.println(getReverse(s));
        reverse(s);

        System.out.println(s);

    }

    void reverse(String s)
    {
        System.out.println("Reversed string: ");
        for (int i=s.length()-1; i>=0;i--)
        {
            System.out.print(s.charAt(i));
        }
        System.out.println();

    }

    String getReverse(String s)
    {
        String reversed = "";
        for (int i=s.length()-1; i>=0;i--)
        {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    // 1) Write a function that prints all numbers from 0 up to n
    void PrintNumFrom0(int n)
    {
        for(int i=0; i<=n;i++)
        {
            System.out.print(i + " ");
        }
    }
    //2) Write a function that supports also negative numbers

    void PrintAllNumbers(int start, int n)
    {
        for(int i=start; i<=n;i++)
        {
            System.out.print(i + " ");
        }
    }

    //3) Write a function that prints all integer array

    void PrintArray(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    //4) Write a function that prints all even numbers from integer array

    void PrintEvenNum(int[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] % 2 == 0)
            {
                System.out.print(arr[i] + " ");
            }
        }
    }

    // 5) Write a function that checks if array is empty
    boolean IsEmpty(int[] arr)
    {
        if (arr == null || arr.length == 0) { //null first!! it is safe
            return true;
        }
        else
        {
            return false;
        }

    }

    // 6) Write a function that checks if array contains another element
    boolean ContainsElement(int[] arr, int n)
    {
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == n) {
                return true;
            }
        }
        return false;
    }

    // 7) Write a function, accepts integer argument
    //It should print all the numbers up to the argument
    // BUT:
    //if number is multiple of 3, it should print Fizz instead of number
    //if number is multiple of 5, it should print Buzz instead of number
    //If it is multiple of both 3 and 5, it should print FizzBuzz instead of number

    void PrintFizzBuzz(int n)
    {
        for(int i=1; i<=n; i++)
        {
            if(i%3 == 0)
            {
                if(i%5 == 0) {
                    System.out.print("FizzBuzz ");
                }
                else
                {
                    System.out.print("Fizz ");
                }
            }else if (i%5 == 0)
            {
                System.out.print("Buzz ");
            }
            else
            {
                System.out.print(i + " ");
            }
        }
    }


    @And("I write lambda")
    public void iWriteLambda() {
        var intList= Arrays.asList(3,8,11,2,1,0);
        System.out.println(intList);
//        intList.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
        intList.sort((o1,o2) -> o1-o2);

        System.out.println(intList);


    }

    @Given("I write functions")
    public void iWriteFunctions() {
        printRange(2);
        printRange(20);
        printRange(13);
        printRange(130);
        printRange(30);
        printRange(19);
        printRange(21);
        printRange(29);
        printEveryN("WebDriver", 3);
        System.out.println();
        System.out.println(Yoda("I am happy"));

    }
    //User inputs two numbers which are divided by 5.
    // If a number is in a range of 1..10 - print it saying it
    // is in the range of 1 from 10. If a number is in the range of 10..20
    // - print it saying it's in the range of 10..20.
    void printRange(int number)
    {
        int n = number/10*10;
        System.out.println(number + " it is the range of " + (n) + " and " + (n+10));
    }

    //Reverse every third character of a string. (Example: "WebDriver" => "vDW")

    void printEveryN (String s, int n)
    {
        for (int i=s.length()-n; i>=0; i-=n)
        {
            System.out.print(s.charAt(i));
        }
    }

    //Speak like Yoda - reverse words in a sentence
    // (Example: "I am Automation Engineer" => "Engineer Automation am I")
    // (hint - method .split(" "))

    String Yoda(String s)
    {
        String result = "";
        String arr[] = s.split(" ");
        for (int i=arr.length-1; i>=0; i--)
        {
            result += arr[i] + " ";
        }

        return result;
    }

    
}

