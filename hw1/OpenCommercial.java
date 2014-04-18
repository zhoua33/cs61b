/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *  *   Web page and print them in reverse order, given the name of a company.
 *   */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
 *    *  the Web site corresponding to www.X.com, and prints the first five lines
 *       *  of the Web page in reverse order.
 *          *  @param arg is not used.
 *             *  @exception Exception thrown if there are any problems parsing the 
 *                *             user's input or opening the connection.
 *                   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;
    //String s1,s2,s3,s4;
    URL u;    

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();
    u = new URL("http://www."+inputLine+".com/");
    InputStream ins = u.openStream();
    InputStreamReader isr = new InputStreamReader(ins);
    BufferedReader content = new BufferedReader(isr);
  
    String s1 = content.readLine();
    String s2 = content.readLine();
    String s3 = content.readLine();
    String s4 = content.readLine();
    System.out.println(content.readLine());
    /*System.out.println(s4);
    System.out.println(s3);
    System.out.println(s2);
    System.out.println(s1);
    */
    System.out.printf("%s\n%s\n%s\n%s",s4,s3,s2,s1);
    /* Replace this comment with your solution.  */

  }
}
