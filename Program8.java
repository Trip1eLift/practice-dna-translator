/**Program8
 *
 * Description: Program8 is a driver which runs on DNAApp ProteinLib,
 * and mRNAlib. It can let the user enter the name of the file, then
 * search the file to find the header and coding region. And then it
 * will let the user choose 1:DNA, 2:mRNA, and 3:amino acids. After
 * printing the answer out, it will let user to enter a path to store
 * answer into a file.
 *
 * Date: 10/14/2018
 * @author: Joseph Chang
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Program8
{
    public Program8()
    {
        DNAApp dnaApp = new DNAApp();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter file name:");
        String fileName = keyboard.nextLine();

        if(dnaApp.readFile(fileName))
        {
            dnaApp.lengthOfHeader("2004"); //Give the last four char of the first
            // header to let the App to get the length of the header

            //send coding region into Arraylist after change char to A
            dnaApp.changeCharToA();
            ArrayList<String> sequences = new ArrayList<String>();
            sequences = dnaApp.searchAndStore();

            //let user pick task
            System.out.println("Enter a number (1~3):\n1:DNA, 2:mRNA, 3:amino acid sequence");
            if (!keyboard.hasNextInt())
            {
                System.err.println("User didn't enter a number between 1 and 3.");
            }
            else
            {
                //check what user enter
                boolean flag = true;
                switch(keyboard.nextInt())
                {
                    case 1:
                        break;
                    case 2:
                        mRNAlib mRNA = new mRNAlib();
                        sequences = mRNA.convertEntireSequences(sequences);
                        break;
                    case 3:
                        ProteinLib aminoAcid = new ProteinLib();
                        sequences = aminoAcid.convertEntireSequences(sequences);
                        break;
                    default:
                        System.err.println("User didn't enter a number between 1 and 3.");
                        flag = false;
                        break;
                }

                //store the information into a file, the name of the file can
                //be asigned by user
                if(flag)
                {
                    printSequences(sequences);

                    System.out.println("\nEnter the name of the file you want to store in:");
                    keyboard.nextLine();
                    fileName = keyboard.nextLine();
                    try
                    {
                        PrintWriter outPutFile = new PrintWriter(fileName);
                        printSequences(sequences, outPutFile);
                        outPutFile.close();
                    }
                    catch (FileNotFoundException fnfe)
                    {
                        System.err.println("Cannot find the output file!");
                    }
                }
            }
        }
        else
            System.out.println("Cannot find the file.");
    }

    public void printSequences(ArrayList<String> sequences)
    {
        for (int i = 0; i < sequences.size(); i++)
        {
            System.out.println(sequences.get(i));
        }
    }

    public void printSequences(ArrayList<String> sequences, PrintWriter outPutFile)
    {
        for (int i = 0; i < sequences.size(); i++)
        {
            outPutFile.println(sequences.get(i));
        }
    }

    public static void main(String args[])
    {
        new Program8();
    }
}
