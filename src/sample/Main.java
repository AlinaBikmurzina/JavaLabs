package sample;

public class Main {

    public static void main(String[] args) {

        System.out.println(CalcExpression(1,2,3,4));

        System.out.println(CheckSum(12, 1));

        System.out.println(NumSign(-12));

        System.out.println(NegativeNum(0));

        System.out.println(NameMessage("Алина"));

        System.out.println(LeapYear(2020));

    }

    public static void InitVariables ()
    {
        int a = 5;
        double b = 5.3;
        char c = 'a';
        boolean d = true;

        String abc = "Alina";
    }

    public static double CalcExpression (double a, double b, double c, double d)
    {
        double result;
        result = a * (b + (c / d));

        return result;
    }

    public static boolean CheckSum (double a, double b)
    {
        double sum = a + b;

        if ((sum <= 20) && (sum >= 10))
        {
            return true;
        }

        else {
            return false;
        }
    }


    public static String NumSign (int a)
    {
        String result;
        if (a>=0)
        {
            result = "Число положительное";
        }
        else
        {
            result = "Число отрицательное";
        }
        return result ;
    }


    public static boolean NegativeNum (int a)
    {
        if (a<0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public static String NameMessage (String A)
    {
        String result ;
        result = "Привет, " + A;
        return result ;
    }

    public static String LeapYear (int a)
    {
        String result;
        int b = a % 4;
        int c = a % 400;
        int d = a % 100;
        if (((b==0) || (c==0)) && (d!=0))
        {
            result = "високосный год";
        }
        else
        {
            result = "невисокосный год";
        }
        return result;

    }
}


