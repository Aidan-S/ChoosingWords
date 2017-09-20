import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Console {
	
	public static PrintWriter openDictionary(String fname) {
		
		File file = new File(fname);
		PrintWriter output = null;
		try {
			output = new PrintWriter(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Can't open " + fname);
			return null;
		}
		
		return output;
	}
	
	public static Scanner openWords(String fname) {
		
		File file = new File(fname);
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("CAnt open " + fname);
			return null;
		}
		
		return input;
	}
	
	public static void writeJava(Scanner input, PrintWriter output) {
		
		while (input.hasNextLine()) {
			
			String word = input.nextLine().toUpperCase();
			
			if(word.length() >= 3 && word.length() <= 5) {
				
				
				output.println("\t\t\"" + word + "\"," );
			}
			
			
		}
	}
	
	public static void writeJavaHeader(PrintWriter output) {
		System.out.println("public class RamblecsDictionary\n{");
		System.out.println("\tprivate String[] words = \n\t{");
	}
	
	
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("You didnt supply enough files");
			System.exit(1);
		}
		
		Scanner in = openWords(args[0]);
		if(in == null) 
			System.exit(1);
		
		PrintWriter out = openDictionary(args[1]);
		
		writeJavaHeader(out);
		writeJava(in, out);
		
		
		out.println(in.nextLine());
		in.close();
		out.close();

	}

}
