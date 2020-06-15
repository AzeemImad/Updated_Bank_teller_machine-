package ATM;

import java.io.*;

public class FileHandler {

    /**
     * Writes into a file. prints a success message when successfully written to a file otherwise prints an error
     * message
     *
     * @param filename string used to recognize what file to write to
     * @param object  object being written into the file
     *
     * */
    static void writeObject(String filename, Object object){
        try{
            FileOutputStream file = new FileOutputStream(filename, false);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
            System.out.println("Saved successfully to " + filename);
        } catch(IOException e){
            System.out.println("ERROR saving " + filename);
        }
    }

    /**
     * Reads from a file. Gives an error message if file is not read.
     *
     * @param filename string which is the filename
     *
     * @return Object which was read from file
     * */
    static Object readObject(String filename){
        Object object;
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            object = in.readObject();
            in.close();
            file.close();
            return object;
        } catch(Exception e){
            System.out.println(filename + " not read");
            return null;
        }
    }

    /**
     * Reads text from a file. Gives an error message if file is not read.
     *
     * @param filename string which is the filename
     *
     * @return string read from the file
     * */
    public static String readText(String filename){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(filename));
            String result = fileReader.readLine();
            fileReader.close();
            return result;
        } catch (Exception e) {
            System.out.println(filename + " not read");
            return "";
        }
    }

    /**
     * writes a file. Gives an error message if file is not saved. Writes the transactions into file
     *
     * @param filename The filename
     * @param message A string message to write to the file
     * */
    public static void writeText(String filename, String message){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            out.println(message);
            out.close();
        } catch (Exception e) {
            System.out.println("ERROR saving " + filename);
        }
    }

    /**
     * Reads the amount of bills present in the machine. prints error message if file not read
     * @param filename string containing the name of the file
     *
     * @return array containing the number of bills
     * */
    public static int[] readCash(String filename){
        int[] billCount = new int[4];
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(filename));
            fileReader.readLine();
            billCount[0] = Integer.parseInt(fileReader.readLine());
            billCount[1] = Integer.parseInt(fileReader.readLine());
            billCount[2] = Integer.parseInt(fileReader.readLine());
            billCount[3] = Integer.parseInt(fileReader.readLine());
            return billCount;
        } catch (Exception e) {
            return new int[4];
        }
    }

    /**
     * Writes amount of cash into a file. prints a success message when successfully written to a file otherwise prints
     * an error message.
     *
     * @param filename String containg the filename
     * @param fifties int containing no of fifty dollar bills
     * @param twenties int containing no of twenty dollar bills
     * @param tens  int containing no of ten dollar bills
     * @param fives  int containing no of five dollar bills
     * */
    public static void writeCash(String filename, int fifties, int twenties, int tens, int fives){
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            out.println("");
            out.println(fifties);
            out.println(twenties);
            out.println(tens);
            out.println(fives);
            out.close();
            System.out.println("cash saved to " + filename);
        } catch (Exception e) {
            System.out.println("ERROR saving cash");
        }
    }
}
