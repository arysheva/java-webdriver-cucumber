package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gherkin.ast.ScenarioOutline;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
       /* if (site.equals("google"))
        {
            System.out.println("http://www.google.com");
        }
        else if (site.equals("sample")) {
            System.out.println("https://skryabin.com/webdriver/html/sample.html");
        }
        else
        {
            System.out.println("Sorry, " + site + " is unknown site");
        }*/

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
        info.put("firstName", "George");
        info.put("middleName", swap);

        for(String key : info.keySet()) {
            System.out.println(key + ": " + info.get(key));
        }

    }
}
