import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		
		int max=ocurrancy.get(0);
		
		for (int i = 0; i < ocurrancy.size(); i++) {
			/*for (int k = i+1; k < ocurrancy.size(); k++) {
		
			if(ocurrancy.get(i)< ocurrancy.get(i+1))
				temp=ocurrancy.get(i);
			ocurrancy.set(i,ocurrancy.get(i+1));
			ocurrancy.set(i+1,temp);

		}*/
			
		if (ocurrancy.get(i)>max)
				max=ocurrancy.get(i);
		}
		
		indexOfPredictedPattern = ocurrancy.indexOf(max);
		PredictedPattern = words.get(indexOfPredictedPattern);
		
		System.out.println(ngram + " "  + PredictedPattern  );
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
}