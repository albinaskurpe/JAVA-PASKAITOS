// import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
import java.util.Calendar;

public class Validator {
    // the first test is an example test
    // checking 
    public static boolean isSingleSentence(String text){
        // each sentence can has letters only
        // begins with uppercase letter
        // ends with a . or ... or ! or ?
        // space after , or ; or :
        // both spaces around - or none
        
        // preliminaries  
        if ((text == null) || (text.length() == 0))
            return true;

        // now we know it is not null and has length at least 1
        // first letter
        if (!Character.isUpperCase(text.charAt(0)))
            return false;
        // last letter
        if (".?!".indexOf(text.charAt(text.length()-1)) == -1)
            return false;

        // now we know length is at least 2 
        // check for dots
        int dotIndex = text.indexOf('.');
        if (dotIndex != -1 && /*gal čia || ??*/  dotIndex != text.length()-1){     // if there are dots in the middle
            if (dotIndex < text.length()-3)                     // if not at the end
                return false;
            if (text.indexOf("...") != text.length()-3)           // if we cannot find ...
                return false;
        }        

        // check for invalid symbols, dot is ok, we have processed it already
        for(int i = 1; i < text.length()-2; ++i){
            if (!(Character.isLetter(text.charAt(i))) && (" ,.;:-".indexOf(text.charAt(i)) == -1)){
                //System.out.println(i + " " + text.length() + " [" + (int)text.charAt(i) + "]");
                return false;
            }
        }

        // check special symbols
        for(int i = 1; i < text.length()-2; ++i){
            // check -
            if (text.charAt(i) == '-'){
                int errorFlag = 1;          // using a temporary variable to track errors
                if (text.charAt(i-1) == ' ' && text.charAt(i+1) == ' ')
                    errorFlag = 0;
                if ((Character.isLetter(text.charAt(i-1))) && (Character.isLetter(text.charAt(i+1))))
                    errorFlag = 0;
                if (errorFlag == 1)
                    return false;
            }
            // check space
            if ((text.charAt(i) == ' ') && (text.charAt(i+1) == ' '))
                return false;
            // check ,;:
            if (",;:".indexOf(text.charAt(i)) != -1){
                if ((!Character.isLetter(text.charAt(i-1)) || (text.charAt(i+1) != ' ')))
                    return false;
            }
        }

        return true;
    }
    public static boolean isFirstName(String text){
        
        //can be null or empty.
        if ((text == null) || (text.length() == 0)){
            return true;
        }

        // If text length is 1 and Char is UpperCase > True
        // Else if first letter is not uppercase and last is not lowercase > False
        if (text.length() == 1 && Character.isUpperCase(text.charAt(0))){
            return true;
        }   else if(!Character.isUpperCase(text.charAt(0)) ||
                    !Character.isLowerCase(text.charAt(text.length()-1))){
                return false;
            }
            
        //All remaining symbols must be letters except of space and '.
        //First and last are already tested!
        for(int i = 1; i < text.length()-2; i++){
            if (!(Character.isLetter(text.charAt(i))) && (" '".indexOf(text.charAt(i)) == -1)){
                return false;
            }
        }
            
        //Space can only be followed by a Capital letter.
        // 'can only be followed by lowercase letter.
        for(int i=1; i < text.length()-2; i++){
            if (((text.charAt(i) == ' ') && !Character.isUpperCase(text.charAt(i+1))) || 
                ((text.charAt(i) == '\'') && !Character.isUpperCase(text.charAt(i+1)))){
                return false;
            } 
        }

        //all letters are lowercase, unless they come after space or '.
        //First letter is sorted!
        for(int i=1; i < text.length()-2; i++ ){
            if(Character.isUpperCase(text.charAt(i)) && 
               text.charAt(i-1) != '\'' &&
               text.charAt(i-1) != ' '){
                return false;
            }
        }

        return true;
    }
    public static boolean isLastName(String text){

        //can be null or empty.
        if ((text == null) || (text.length() == 0)){
            return true;
        }

        // If text length is 1 and Char is UpperCase > True
        // Else if first letter is not uppercase and last is not lowercase > False
        if (text.length() == 1 && Character.isUpperCase(text.charAt(0))){
            return true;
        }   else if(!Character.isUpperCase(text.charAt(0)) ||
                    !Character.isLowerCase(text.charAt(text.length()-1))){
                return false;
            }
            
        //All remaining symbols must be letters except of space and '.
        //First and last are already tested!
        for(int i = 1; i < text.length()-2; i++){
            if (!(Character.isLetter(text.charAt(i))) && (" '".indexOf(text.charAt(i)) == -1)){
                return false;
            }
        }
            
        //Space can only be followed by a Capital letter.
        // 'can only be followed by lowercase letter.
        for(int i=1; i < text.length()-2; i++){
            if (((text.charAt(i) == ' ') && !Character.isUpperCase(text.charAt(i+1))) || 
                ((text.charAt(i) == '\'') && !Character.isUpperCase(text.charAt(i+1)))){
                return false;
            } 
        }

        //all letters are lowercase, unless they come after space or '.
        //First letter is sorted!
        for(int i=1; i < text.length()-2; i++ ){
            if(Character.isUpperCase(text.charAt(i)) && 
               text.charAt(i-1) != '\'' &&
               text.charAt(i-1) != ' '){
                return false;
            }
        }
        return true;
    }
    public static boolean isPersonalCode(String text){

        // initial check
        if(text == null || text.length() == 0){
            return true;
        }

        // length is 11 symbols
        if(text.length() != 11 ){
            return false;
        }

        // all symbols are digits
        for( int i=0; i < text.length()-1; i++ ){
            if( !(Character.isDigit(text.charAt(i))) ){
                return false;
            }
        }

        //starts only with 3,4,5,6
        if( "3456".indexOf(text.charAt(0)) == -1 ){
            return false;
        }
         
        Calendar cal = Calendar.getInstance();
        int currentYear = Integer.parseInt(String.valueOf(cal.get(Calendar.YEAR)).substring(2));
        int currentMonth = cal.get(Calendar.MONTH)+1;
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);

        int firstDigit = Character.getNumericValue(text.charAt(0));

        int year = Integer.parseInt(text.substring(1,3));
        int month = Integer.parseInt(text.substring(3,5));
        int day = Integer.parseInt(text.substring(5,7));

        //if born in XIX, year can't be > than current year
        if( (firstDigit > 4 && firstDigit < 7) && (year > currentYear) ) {
            // System.out.println("True");
            return false;
        }

        //no of month can't be more than 12
        if( month < 1 || month > 12 ){
            return false;
        }

        //  TODOfix max days according to months;
        // days can't be more than 31
        if( day < 1 || day > 31 ){
            return false;
        }

        // System.out.println(firstDigit + " " + firstDigit + " " + 
        // year + " " + currentYear + " " + 
        // month + " " + currentMonth + " * " + 
        // day + " " + currentDay );
        
        // if person born in this year
         if ( (firstDigit > 4 && firstDigit < 7) && 
            (year == currentYear) &&
            ((month > currentMonth) || (month == currentMonth && day > currentDay))){
            return false;       
        }
        return true;
    }
    public static boolean isOccupation(String text){
        // your code here
        return true;
    }
    public static boolean isCompanyName(String text){
        // your code here
        return true;
    }
    public static boolean isCompanyCode(String text){
        // your code here
        return true;
    }
    public static boolean isAddress(String text){
        // your code here
        return true;
    }    
    public static boolean isEmail(String text){
        // your code here
        return true;
    }
    public static boolean isPhone(String text){
        
        // preliminaries  
        if ((text == null) || (text.length() == 0)){
            return true;
        }
           
        // lenghth can be only 9, 12 or 13 symbols.
        if(text.length() != 9 && text.length() != 12 && text.length() != 13){
            return false;
        }
            
        // //First symbol can only be digit or "+".
        if (!Character.isDigit(text.charAt(0)) && (text.charAt(0) != '+')){
            return false;
        }

        //Check if all remaining symbols are digits.
        for(int i = 1; i < text.length(); i++){
            if (!Character.isDigit(text.charAt(i))){
                // System.out.println(1);
                return false;
            }
        }

        if( text.length() == 12 && (text.substring(0,4)).equals("+370") ){
            // System.out.println(2);
            return true;
        }   else if( text.length() == 13 && (text.substring(0,5)).equals("00370") ){
                // System.out.println(3);
                return true;
            }   else if( text.length() == 9 && text.charAt(0) == '8' ){
                    // System.out.println(4);
                    return true;
                }   else{
                        // System.out.println(5);
                        return false;
                    }
    }
    public static boolean isAccountNumber(String text){
        // your code here
        return true;
    }
    public static boolean isMoney(String text){
        // your code here
        return true;
    }
    public static boolean isDate(String text){
        // your code here
        return true;
    }  
}