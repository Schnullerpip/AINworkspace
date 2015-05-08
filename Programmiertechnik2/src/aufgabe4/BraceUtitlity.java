package aufgabe4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Deque;
import java.util.LinkedList;

public class BraceUtitlity {

	public static void printBrackets(String fn) throws FileNotFoundException,
			IOException {
		LineNumberReader in = new LineNumberReader(new FileReader(fn));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
			System.out.print("Klammern: ");
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				switch (c) {
				case '(':
				case '{':
				case '[':
					System.out.print(c + ", ");
					break;
				case ')':
				case '}':
				case ']':
					System.out.print(c + ", ");
					break;
				}
			}
			System.out.println();
			in.close();
		}
	}

	public static void checkBrackets(String fn) throws FileNotFoundException,
			IOException {
		LineNumberReader in = new LineNumberReader(new FileReader(fn));
		Deque<Char_Line_Pair> stack = new LinkedList<Char_Line_Pair>();

		/*conditional or helping variables------------------*/
		String line;
		int lineNumber = 1;
		int tabs;
		boolean inString = false, inChar = false;
		Char_Line_Pair popped;
		/*--------------------------------------------------*/
		
		while ((line = in.readLine()) != null) {
			tabs = 0;
			for (int i = 0; i < line.length(); i++) {
				switch (line.charAt(i)) {
				case '\t':
					tabs++;
					break;
				case '"':
					if(!inChar)
						inString = !inString;
					break;
				case '\'':
					if(inString)break;
					char charAt_1 = line.charAt(i-1), charAt_2 = line.charAt(i-2);
					if((charAt_1 == '\\') && (charAt_2=='\\')){
						inChar= !inChar;
					}else if(!(charAt_1 == '\\')){
						inChar= !inChar;
					}
					break;
				case '{':
				case '[':
				case '(':
					if (inString || inChar)
						break;
					stack.push(new Char_Line_Pair(line.charAt(i), lineNumber, i, line, tabs));
					break;
				case '}':
					if (inString || inChar)
						break;
					if(stack.isEmpty()){
						System.out.println("[checkBrackets] -> \tDelete this '}' at "+lineNumber+":"+tabs*4+i);
						System.out.println(line);
						break;
					}
					if ((popped = stack.pop()).character != '{') {
						printError(popped, lineNumber, line, tabs, i);
						in.close();
						return;
					}
					break;
				case ']':
					if (inString || inChar)
						break;
					if(stack.isEmpty()){
						System.out.println("[checkBrackets] -> \tDelete this ']' at "+lineNumber+":"+tabs*4+i);
						System.out.println(line);
						break;
					}
					if ((popped = stack.pop()).character != '[') {
						printError(popped, lineNumber, line, tabs, i);
						in.close();
						return;
					}
					break;
				case ')':
					if (inString || inChar)
						break;
					if(stack.isEmpty()){
						System.out.println("[checkBrackets] -> \tDelete this ')' at "+lineNumber+":"+tabs*4+i);
						System.out.println(line);
						break;
					}
					if ((popped = stack.pop()).character != '(') {
						printError(popped, lineNumber, line, tabs, i);
						
						in.close();
						return;
					}
					break;
				}
			}
			++lineNumber;
		}
		in.close();
		
		if(stack.isEmpty()){System.out.println("Everything is fine!");return;}
		
		while(!stack.isEmpty()){
			Char_Line_Pair clp = stack.pop();
			System.out.println("missing closing Bracket for '" + clp.character + "' at " + clp.lineNumber + ":" + clp.column);
		}
	}
	
	private static void printError(Char_Line_Pair popped,int lineNumber, String line, int tabs, int column){
		System.out.println("[checkBrackets] -> \tat " + popped.lineNumber + ":" + popped.column + " -> attempt to close '" + popped.character +"' with '"+line.charAt(column)+"' from "+lineNumber+":"+column+tabs*4);
		System.out.println("At Line: "+popped.lineNumber+"\t"+popped.line);
		System.out.print("\t\t");
		for(int o=0;o<popped.tabs;o++)
			System.out.print("\t");
		for(int o=0;o<popped.column-popped.tabs;o++)
			System.out.print(" ");
		System.out.print("^\n");
		
		System.out.println("At Line: "+lineNumber+"\t"+line);
		System.out.print("\t\t");
		for(int o=0;o<tabs;o++)System.out.print("\t");
		for(int o=0;o<column-tabs;o++)System.out.print(" ");
		System.out.print("^");
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		checkBrackets(args[0]);
	}
	
	private static class Char_Line_Pair{
		
		public char character;
		public int lineNumber;
		public int tabs;
		public int column;
		public String line;
		
		public Char_Line_Pair(char charAt, int lineN, int col, String line, int tab) {
			character = charAt;
			lineNumber = lineN;
			column = col;
			this.line = line;
			tabs =tab;
		}
	}

}
