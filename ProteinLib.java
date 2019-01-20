/**ProteinLib
 *
 * Description: ProteinLib can translate a DNA, DNA sequence,
 * or DNA sequences into amino acid, amino acids sequence, or
 * amino acids sequences.
 *
 * Date: 10/14/2018
 * @author: Joseph Chang
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProteinLib
{
    HashMap<String, String> map = new HashMap();

    //no parameter constructor, use to call the initialize method
    public ProteinLib()
    {
        buildMap();
    }

    //convert three DNA into a amino acid
    public String convert(String DNA)
    {
        if(map.containsKey(DNA))
            return map.get(DNA);
        else
        {
            System.err.println("Not found matching DNA in protein lib");
            return "";
        }
    }

    //convert an entire string of DNA sequence into amino acid
    public String convertEntirely(String sequence)
    {
        if (sequence.length() % 3 != 0)
        {
            System.err.println("Sequence's length exception!");
            return"";
        }
        else
        {
            String proteinChain = "";
            for (int i = 0; i < sequence.length(); i += 3)
            {
                proteinChain += convert(sequence.substring(i,i+3));
            }

            return proteinChain;
        }
    }

    //convert an ArrayList<String> of DNA sequences into an ArrayList<String> of amino acid
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

    //initialize the hashmap
    private void buildMap()
    {
        map.put("TTT", "F");
        map.put("TTC", "F");

        map.put("TTA", "L");
        map.put("TTG", "L");
        map.put("CTT", "L");
        map.put("CTC", "L");
        map.put("CTA", "L");
        map.put("CTG", "L");

        map.put("ATT", "I");
        map.put("ATC", "I");
        map.put("ATA", "I");

        map.put("ATG", "M");

        map.put("GTT", "V");
        map.put("GTC", "V");
        map.put("GTA", "V");
        map.put("GTG", "V");

        map.put("TCT", "S");
        map.put("TCC", "S");
        map.put("TCA", "S");
        map.put("TCG", "S");

        map.put("CCT", "P");
        map.put("CCC", "P");
        map.put("CCA", "P");
        map.put("CCG", "P");

        map.put("ACT", "T");
        map.put("ACC", "T");
        map.put("ACA", "T");
        map.put("ACG", "T");

        map.put("GCT", "A");
        map.put("GCC", "A");
        map.put("GCA", "A");
        map.put("GCG", "A");

        map.put("TAT", "Y");
        map.put("TAC", "Y");

        map.put("TAA", "stop");
        map.put("TAG", "stop");

        map.put("CAT", "H");
        map.put("CAC", "H");

        map.put("CAA", "Q");
        map.put("CAG", "Q");

        map.put("AAT", "N");
        map.put("AAC", "N");

        map.put("AAA", "K");
        map.put("AAG", "K");

        map.put("GAT", "D");
        map.put("GAC", "D");

        map.put("GAA", "E");
        map.put("GAG", "E");

        map.put("TGT", "C");
        map.put("TGC", "C");

        map.put("TGA", "stop");

        map.put("TGG", "W");

        map.put("CGT", "R");
        map.put("CGC", "R");
        map.put("CGA", "R");
        map.put("CGG", "R");

        map.put("AGT", "S");
        map.put("AGC", "S");

        map.put("AGA", "R");
        map.put("AGG", "R");

        map.put("GGT", "G");
        map.put("GGC", "G");
        map.put("GGA", "G");
        map.put("GGG", "G");
    }
}
