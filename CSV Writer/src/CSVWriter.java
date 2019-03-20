import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CSVWriter {

	public static void main(String[] args) {
		
		String fileName = "apex.csv";
		
		String response = null;
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String data = getData();
			appendToFile(fileName, data);
			//System.out.println(data);
			System.out.println("Add another?\n");
			try {
				response = input.readLine();
			} catch(IOException e) {
				System.out.println(e);
			}
			
			if(response.contains("y") || response.contains("yes")) {
				continue;
			} else {
				break;
			}
			
		}
		
		
	}
	
	public static String getInput(String prompt) {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println(prompt);
			System.out.println(" ");
			String response;
			
			try {
				response = input.readLine();
				if(response == null) {
					return " ";
				} 
			} catch(IOException e) {
				throw new RuntimeException("User Input Error", e);
			}
			return response;
		}
	}
	
	public static String getData() {
		DateFormat sdf = new SimpleDateFormat("MM-dd-yy");
		Date date = new Date();
		String damage = getInput("Damage: ");
		String kills = getInput("Kills: ");
		String survivalTime = getInput("Survival Time (0m0s): ");
		String level = getInput("Level: ");
		String rank = getInput("Squad Rank: ");
		String friends = getInput("With Friends? (0/1) ");
		String dateString = sdf.format(date);
		String output = damage + "," + kills + "," + survivalTime + ',' + level + ',' + 
				rank + ',' + friends + ',' + dateString + '\n';
		return output;
	}
	
	public static void appendToFile(String filename, String input) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			writer.write(input);
			writer.close();
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	
	

}
