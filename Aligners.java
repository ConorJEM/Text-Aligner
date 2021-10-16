/**
 * This class "Aligners" contains the methods which align the text input as needed.
 * Includes the basic 'left align' and all additional specifications.
 * @author  160014528
 */
public class Aligners {
    /**
     * Aligns text to the left. Creates an empty string 'line'. Words are appended to the string 'line' until
     * the length of 'line' exceeds the specified length given in the arguments, and string 'line' is printed on a new line. Then 'line'
     * is reset back to an empty string and this repeats.
     * @param paragraphs The paragraphs from the given text
     * @param length The desired length for each line of text
     */
    public static void left(String[] paragraphs, int length) {
        for (int i = 0; i < paragraphs.length; i++) {

            String[] words = paragraphs[i].split(" ");
            /**
             * runningVal checks the space left to append words to string 'line'
             * Here initialise runningval = length + 1 because the last word of the line will have an extra space increasing the length by 1.
             */
            int runningVal = length + 1;
            String line = ("");
            for (int j = 0; j < words.length; j++) {

                if (runningVal - words[j].length() > 0) {

                    line = line + words[j] + " ";
                } else {
                        System.out.println(line);
                        //resetting runningval for the next line   
                        runningVal = length + 1;
                        //reset the string 'line' to an empty string
                        line = "";
                        //Add the current word that didnt fit onto the last line onto the new line.
                        line = line + words[j] + " ";
                }
                    /**
                     * Update runningval by subtracting length of last word added to 'line' and taking off -1 because of the space added
                     */
                    runningVal = runningVal - words[j].length() - 1;
            }
                System.out.println(line);
                System.out.println("");  
        }
    }
    /**
     * Right aligns a given text.
     * Creates lines fundamentally the same as the 'left' method. But now we calculate the difference
     * between the length of the line before it is printed, and the specified length given in the argument. 
     * We then add this amount of spaces at the start of the line (using method 'makeSpaces') before it is printed.
     * @param paragraphs The paragraphs from the given text
     * @param length The desired length for each line of text
     */
    public static void right(String[] paragraphs, int length) {
        for (int i = 0; i < paragraphs.length; i++) {   
            String[] words = paragraphs[i].split(" ");
            String line = ("");
            int runningVal = length + 1;
        
            for (int j = 0; j < words.length; j++) {
                if (runningVal - words[j].length() > 0) {
                    line = line + words[j] + " ";
                } else {
                    //spaces is how many spaces need added to the front of the string to right align the text
                    // add 1 because of the space at the end of the string 'line'
                    int spaces = length - line.length() + 1;
                       
                    System.out.println(makeSpaces(spaces) + line);               
                    runningVal = length + 1;
                    
                    line = ""; 
                    line = line + words[j] + " ";
                }
                    runningVal = runningVal - words[j].length() - 1;
            }
            int spaces = length - line.length() + 1;
            System.out.println(makeSpaces(spaces) + line);
            System.out.println("");
                    
        }    

    }
    /**
     * Centre aligns given text.
     * Centre fill functions the same as right fill but takes half of the number of spaces infront
     * of each line. Because of the specifications we need to round up after dividing by two, and I do this by using
     * (numerator+denominator-1)/denominator to round up after dividing.
     * @param paragraphs The paragraphs from the given text
     * @param length The desired length for each line of text
     */
    public static void centre(String[] paragraphs, int length) {
        for (int i = 0; i < paragraphs.length; i++) {

            String[] words = paragraphs[i].split(" ");
            String line = ("");
            int runningVal = length + 1;
            for (int j = 0; j < words.length; j++) {
                if (runningVal - words[j].length() > 0) {
                    line = line + words[j] + " ";
                } else { 
                    /**
                     * To make sure we round up after dividing by two,
                     * we do ((length - line.length() + 1) -1 + Denominator)/Denominator
                     * where denominator = 2.
                     *  */  
                    int spaces = ((length - line.length() + 1) + 1) / 2;
                        
                    System.out.println(makeSpaces(spaces) + line);               
                    runningVal = length + 1;
                    
                    line = ""; 
                    line = line + words[j] + " ";
                }
                    runningVal = runningVal - words[j].length() - 1;
            }
        int spaces = ((length - line.length() + 1) + 1) / 2;    
        System.out.println(makeSpaces(spaces) + line);
        System.out.println("");  
        }              
    }
    /**
     * This method returns a string filled with the number of spaces equal to the given argument when the
     * method is called.
     * @param spaces The required number of spaces needed to give the required alignment.
     * @return spacestr A string filled with the number of spaces given as an input to the method.
     */
    public static String makeSpaces(int spaces) {
            String spacestr = ("");
                
            for (int i = 0; i < spaces; i++) {
                     spacestr += " ";
            }
                return spacestr;
    }
    /**
     * Creates the handle at the bottom of the signpost.
     */

    public static void makeHandle() {
        System.out.println("        |  |");
        System.out.println("        |  |");
        System.out.println("        L_ |");
        System.out.println("       / _)|");
        System.out.println("      / /__L");
        System.out.println("_____/ (____)");
        System.out.println("       (____)");
        System.out.println("_____  (____)");
        System.out.println("     \\_(____)");
        System.out.println("        |  |");
        System.out.println("        |  |");
        System.out.println("        \\__/");
        System.out.println("       ");
        System.out.println("       ");
    }
    /**
     * Creates the bottom of the signpost.
     * @param length The desired length for each line of text
     */
    public static void makeBottom(int length) {
        String underline = "";
        //For loop until i=length-2 because we add in \ and / at the ends.
        for (int i = 0; i < length - 2; i++) {
            underline += "_";
       }
        System.out.println("\\" + underline + "/");
    }
    /**
     * Creates the top two lines of the signpost. 
     * Methods makeBottom and makeTop could be made into one method that takes an extra parameter to print either the 
     * bottom or top line, but they are split to improve readability.
     * @param length The desired length for each line of text
     */
    public static void makeTop(int length) {
        String underline = "";
        for (int i = 0; i < length - 2; i++) {
            underline += "_";
       }
        
       System.out.println(" " + underline + " ");
       System.out.println("/" + makeSpaces(length - 2) + "\\");
    }
    /**
     * Returns an integer width.
     * This method scans through every word in the text and compares the length of each word to the 'length' given as an argument.
     * If all words in the given text are shorter than (length - 4) ; width = length.
     * Otherwise width = 4 + the size of the longest word in the text.  
     * @param paragraphs The paragraphs from the given text
     * @param length The desired length for each line of text
     * @return width The required width of the signpost that ensures all words fit inside its edges.
     */
    public static int checkLength(String[] paragraphs, int length) {
        int width = length;
        for (int i = 0; i < paragraphs.length; i++) {
            String[] words = paragraphs[i].split(" ");
        
            for (int j = 0; j < words.length; j++) {
                /**
                 * we check if any any words length + 4 is > width because
                 * the sides of the sign post adds 4 characters at the ends of each line
                 */
                if (words[j].length() + 4 > width) {
                width = words[j].length() + 4;
                
                }                 
            }
        }

        return width;
    }
    /**
     * Prints the body of the signpost which includes the text.
     * The text inside the signpost is left aligned so it follows the same logic as the method 'left'
     * The width of the signpost is equal to the argument width.
     * @param paragraphs The paragraphs from the given text
     * @param width The output from checklength, equal to length if no words length is greater than (length - 4)
     * @param length The desired length for each line of text
     */

    public static void signPost(String[] paragraphs, int width, int length) {   
        for (int i = 0; i < paragraphs.length; i++) {
            String[] words = paragraphs[i].split(" ");
            String line = ("");
            // runningval = length + 1 - 4 = length -3. The +1 comes from the extra space after the last word at the end of the line,
            // -4 because the signpost edges add 4 characters to the line.
            int runningVal = length - 3;

            for (int j = 0; j < words.length; j++) {

                if (runningVal - words[j].length() > 0) {
                    line = line + words[j] + " ";
                } else {

                    int spaces = width - line.length();
                    //Prints the string 'line' where has line.length() <= length. Then append the required number of spaces 
                    //so that the width of the signpost is equal to width calculated by checkLength.   
                    System.out.println("| " + line + makeSpaces(spaces - 3) + "|");    
                    runningVal = length - 3;
                    line = "";
                    line = line + words[j] + " ";
                    }
                runningVal = runningVal - words[j].length() - 1;
            }
                int spaces = width - line.length();
                System.out.println("| " + line + makeSpaces(spaces - 3) + "|");                 
        }
    }
}
