/**
 * The class "AlignText" contains a main method which
 * checks the inputs are of the correct format and calls the solve method.
 * The solve method calls upon the needed method from the 
 * "Aligners" class found in aligners.java.
 * @author  160014528
 */
public class AlignText {
    /**
     * This method checks that inputs are valid
     */
    public static void main(String[] args) {
        try {

            String[] paragraphs = FileUtil.readFile(args[0]);
            int length = Integer.parseInt(args[1]);
            if (length < 1) {
                throw new ArithmeticException("usage: java AlignText file_name line_length [align_mode]");
            } else if (args.length == 2) {
                String instruction = "L";
                solve(paragraphs, length, instruction);

            } else if (args.length == 3) {
                String instruction = args[2];  
                solve(paragraphs, length, instruction);   
            } else {
                throw new IllegalArgumentException("usage: java AlignText file_name line_length [align_mode]");    
            }
          
        }  catch (Exception e) {
            System.out.println("usage: java AlignText file_name line_length [align_mode]");
        }
    }
    /**
     * Solve calls upon the required method as per the argument, methods are stored in aligners.java
     * @param paragraphs An array of the paragraphs from the given text 
     * @param length The desired length for each line of text
     * @param instruction The alignment method as specified by the user. By default use left align.
     */
    public static void solve(String[] paragraphs, int length, String instruction) {
    
            if (instruction.equals("L")) {
                Aligners.left(paragraphs, length);
            } else if (instruction.equals("R")) {
                Aligners.right(paragraphs, length);     
            } else if (instruction.equals("C")) {
                Aligners.centre(paragraphs, length);
            } else if (instruction.equals("S")) {
                int width = Aligners.checkLength(paragraphs, length);
                Aligners.makeTop(width);
                Aligners.signPost(paragraphs, width, length);
                Aligners.makeBottom(width);
                Aligners.makeHandle();
                    
            } else {
                //If an instruction was given that isnt 'L' 'R' 'C' or 'S' an error is thrown
                throw new IllegalArgumentException("usage: java AlignText file_name line_length [align_mode]");
            }

        } 

}
       