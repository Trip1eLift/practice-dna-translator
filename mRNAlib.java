/**mRNAlib
 *
 * Description: mRNAlib can translate a DNA, DNA sequence, or
 * DNA sequences into mRNA, mRNA sequence, mRNA sequences
 *
 * Date: 10/14/2018
 * @author: Joseph Chang
 */

import java.util.ArrayList;

public class mRNAlib
{

    //convert single DNA char into mRNA string
    public String convert(char DNA)
    {
        switch(DNA)
        {
            case 'A':
                return "U";
            case 'T':
                return "A";
            case 'C':
                return "G";
            case 'G':
                return "C";
            default:
                System.err.println("Exception char in DNA");
                return "";

        }
    }

    //convert an entirely string of DNA into mRNA
    public String convertEntirely(String sequence)
    {
        String mRNA = "";
        for (int i = 0; i < sequence.length(); i++)
        {
            mRNA += convert(sequence.charAt(i));
        }

        return mRNA;
    }

    //convert an ArrayList<String> from DNA into mRNA
    public ArrayList<String> convertEntireSequences(ArrayList<String> sequences)
    {
        ArrayList<String> newSequences = new ArrayList<String>();

        for (int i = 0; i < sequences.size(); i++)
        {
            if (sequences.get(i).charAt(0) != '>')
                newSequences.add(convertEntirely(sequences.get(i)));
            else
                newSequences.add(sequences.get(i));
        }

        return newSequences;
    }

    //testing and debugging
    public static void main(String args[])
    {
        mRNAlib mRNA = new mRNAlib();
        System.out.println(mRNA.convert('A'));

        System.out.println(mRNA.convertEntirely("AGCATCCTCAGGAA" ));
    }
}
