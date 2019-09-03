public class Paskaita 
{ 
    public final static int NUMBER1 = 3;
    public static void main(String args[]) 
    { 
        // Integer number1 = 3;
        // int number2 = 2;
        // String text = "Hello, World ";
        // System.out.println(text + (NUMBER1 + number2)); 
        // System.out.println(text + (number1 - number2));
        // System.out.println(text + (number1 * number2));
        // System.out.println(text + (number1 / number2));
        // System.out.println(text + (number1 % number2));
        // System.out.println(text.charAt(0));
        // text = null;
        // System.out.println(text);
        // System.out.println(text.charAt(0));
        // System.out.println(text == null);
        // System.out.println(number1 != number2);
        // System.out.println(number1 >= number2);
        // System.out.println(number1 <= number2);
        // boolean b = (1<3) && (!(2<4) || (4!=5));
        // System.out.println(b);
 
        String name = "IrmanTas";
        System.out.println(Character.isUpperCase(name.charAt(0)));

        int i = 0;
        while (true) {
            System.out.println(Character.isUpperCase(name.charAt(i)));
            i++;
            if (name.length() == i) {
                break;
            }
        }
//         String output = "";
//         for (int j=0; j<name.length(); j++) {
//             if (Character.isUpperCase(name.charAt(j))) {
//                 output = output + name.charAt(j);  
//             }
            
//         }
System.out.println("asfasd " + Validator.isName("Irmantas"));
    } 
} 
