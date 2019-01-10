import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PredictPatternsN_grams {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfLines = Integer.parseInt(br.readLine());

		String[] lines = new String[noOfLines];
		String input = "";
		for (int i = 0; i < noOfLines; i++) {
			input = input + " " + br.readLine();
		}

		input = input.trim();

		int ngram = Integer.parseInt(br.readLine());
		//input = input.replaceAll(".", " ");
		//input = input.replaceAll(",", " ");


	input = input.replaceAll("[.|,]", " ");
		String[] splitedLine = removeNullElements(input.split(" "));

		/*
		 * for(int j=0; j<elements.length; j++) { //
		 * System.out.println("is there any space" + splitedLine[j] + "here"); }
		 */
		ArrayList<String> elements = new ArrayList<String>();
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> ocurrancy = new ArrayList<>();

		for (int i = 0; i < splitedLine.length; i++) {
			
			for (int j = 0; j < splitedLine[i].length(); j++) {
				if (j + ngram < splitedLine[i].length())
					elements.add(splitedLine[i].substring(j, j + ngram));
			
			if (j + ngram == splitedLine[i].length())
				elements.add(splitedLine[i].substring(j));
		}
		}
		int j = 0;
		for (int i = 0; i < elements.size(); i++) {

			if (words.contains(elements.get(i))) {
				j = words.indexOf(elements.get(i));
				ocurrancy.set(j, ocurrancy.get(j) + 1);
			} else
				words.add(elements.get(i));
			    ocurrancy.add(1);
		}
		
		
//int temp=0;
		int indexOfPredictedPattern=0;
		String PredictedPattern="";
		ArrayList<String> list = new ArrayList<>();
		int maxOccurence = 0;
		
		int max=ocurrancy.get(0);
		
		for (int i = 0; i < ocurrancy.size(); i++) {
			
			if (ocurrancy.get(i)>max)
					max=ocurrancy.get(i);
		}
			
			indexOfPredictedPattern = ocurrancy.indexOf(max);
			PredictedPattern = words.get(indexOfPredictedPattern);
			
			maxOccurence = Collections.max(ocurrancy);
			
			for(int k=0; k<ocurrancy.size(); k++) {
				if(ocurrancy.get(k) == maxOccurence)
					list.add(words.get(k));
			}
			list = sortStringArray(list);
			System.out.println(ngram + " "  + list.get(0));
		}

	//public static String[] getPredictedPattern(String ) {

	public static String[] removeNullElements(String[] arr) {
		if (arr == null)
			return arr;
		else {
			List<String> newArray = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				if (!arr[i].isEmpty())
					newArray.add(arr[i]);
			}
			return newArray.toArray(new String[newArray.size()]);
		}
	}
	
	public static ArrayList<String> sortStringArray( ArrayList<String>  x)
    {
          int j;
          boolean flag = true;  // will determine when the sort is finished
          String temp;

          while ( flag )
          {
                flag = false;
                for ( j = 0;  j < x.size() - 1;  j++ )
                {
                        if ( x.get(j).compareToIgnoreCase( x.get(j+1) ) > 0 )
                        {                                             // ascending sort
                                    temp = x.get(j);
                                    x.set(j, x.get(j+1));     // swapping
                                    x.set(j+1, temp); 
                                    flag = true;
                         } 
                 } 
          }
          return x;
    }
}