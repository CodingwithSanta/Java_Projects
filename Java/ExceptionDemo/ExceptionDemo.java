import java.util.Scanner;
public class ExceptionDemo
{
  public static void main(String[] args)
  {
   Scanner scanner = new Scanner(System.in);
   try
   {
    System.out.println("Enter two numbers for division:");
    int num1 = scanner.nextInt();
    int num2 = scanner.nextInt();
    int result = num1/num2;
    System.out.println("Result of division:" +result);
   }
    catch(ArithmeticException e)
    {
     System.out.println("ArithmeticException:" +e.getMessage());
    }
     try
      {
        System.out.println("Enter a number:");
        String input = scanner.next();
        int number = Integer.parseInt(input);
        System.out.println("Parsed number:" +number);        
       }
       catch(NumberFormatException e)
       {
         System.out.println("NumberFormatException:" +e.getMessage());
       }
        try 
         {
           int[] arr = {1,2,3,4,5};
           System.out.println("Enter an index to access array element:");
           int index = scanner.nextInt();
           System.out.println("Element at index" +index+ ":" +arr[index]);
          }
           catch(ArrayIndexOutOfBoundsException e)
            {
             System.out.println("ArrayIndexOutOfBoundsException:" +e.getMessage());
            }
             try
             {
              System.out.println("Enter the size of an array (must be positive):");
              int size = scanner.nextInt();
              if(size<0)
              {
               throw new NegativeArraySizeException("Negative array size entered.");
              }
               int[] newArray = new int[size];
               System.out.println("Array created with size:" +size);
             }
              catch(NegativeArraySizeException e)
              {
               System.out.println("NegativeArraySizeException:" +e.getMessage());
              }
               scanner.close();
            }
          }
