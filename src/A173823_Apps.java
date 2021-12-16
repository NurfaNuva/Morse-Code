import java.util.*;

public class A173823_Apps {
	public ArrayList<Character> eng = new ArrayList<Character>(Arrays.asList(
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			'.',',',':','\"','\'','!','?','@','-',';','(',')','=',
			'1','2','3','4','5','6','7','8','9','0'));
	public ArrayList<String> morse = new ArrayList<String>( Arrays.asList(
			".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", 
			".-.-.-","--..--","---...",".-..-.",".----.","-.-.--","..--..",".--.-.","-....-","-.-.-.","-.--.","-.--.-","-...-",
			".----","..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.","-----"));   
	public ArrayList<String> compare;
	public int scan;
	
	public void menu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nMenu:");
		System.out.println("\t1. Send Morse Message\n\t2. Receive Morse Message\n\t3. Print Letters and Morse Code\n\t4. Exit");
		System.out.println("\nInput code:");
		
		int input=sc.nextInt();
		if(input==1) {
			MorseSend();
		}
		else if(input==2) {
			MorseReceive();
		}
		else if(input==3) {
			MorseDisplay();
		}
		else if(input==4) {
			MorseExit();
		}
		else {
			menu();
		}
	}
	
	public void MorseSend() {
		Scanner in=new Scanner(System.in);
		ArrayList<String> raw=new ArrayList<String>();
		compare=new ArrayList<String>();
		compare.clear();
		scan=0;
		int line=0;
		int word=0;
		int alpha=0;
		int symbol=0;
		int num=0;
		String input=in.nextLine().toUpperCase();
		
		if(input.equals("VV")) {
			while(!input.equals("EOM")) {
				raw.add(input);
				input=in.nextLine().toUpperCase();
			}
			raw.add("EOM");
			
			for(int k=0; k<raw.size(); k++) {
				String reads[]=raw.get(k).split(" ");
				line++;
				for(int j=0; j<reads.length; j++) {
					char c[]=reads[j].toCharArray();
					word++;
					for(int i=0; i<c.length; i++) {
						int index=eng.indexOf(c[i]);
						String code=morse.get(index);
						System.out.print(code+" ");		
						if(c[i]=='A'||c[i]=='B'||c[i]=='C'||c[i]=='D'||c[i]=='E'||c[i]=='F'||c[i]=='G'||c[i]=='H'||c[i]== 'I'||c[i]=='J'||
								c[i]=='K'||c[i]=='L'||c[i]=='M'||c[i]=='N'||c[i]=='O'||c[i]=='P'||c[i]=='Q'||c[i]=='R'||c[i]=='S'||c[i]== 'T'||
								c[i]=='U'||c[i]== 'V'||c[i]== 'W'||c[i]== 'X'||c[i]=='Y'||c[i]=='Z') {
							alpha++;}	
						else if(c[i]=='1'||c[i]=='2'||c[i]=='3'||c[i]=='4'||c[i]=='5'||c[i]=='6'||c[i]=='7'||c[i]=='8'||c[i]=='9'||c[i]=='0') {
							num++;alpha++;}
						else {
							symbol++;}
					}
					if(j!=reads.length-1)
						System.out.print(" ");
				}
				System.out.println();
			}
			scan=line;
			
			String count[]=new String[5];
			count[0]=Integer.toString(line);
			count[1]=Integer.toString(word);
			count[2]=Integer.toString(alpha);
			count[3]=Integer.toString(symbol);
			count[4]=Integer.toString(num);
			
			for(int j=0; j<count.length; j++) {
				String counts=count[j];
				compare.add(count[j]);
				for(int k=0; k<counts.length(); k++) {
					char Ccount=counts.charAt(k);
					String l=morse.get(eng.indexOf(Ccount));
					System.out.print(l);
					if(k!=counts.length()-1)
						System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println(". --- -");
			menu();
		}
		else {
			System.out.println("Must start with VV(no space)");
			MorseSend();
		}
	}
	
	public void MorseReceive() {
		Scanner in=new Scanner(System.in);
		ArrayList<String> trans=new ArrayList<String>();
		int sline=0;
		String summary="";
		String summary2="";
		String reason="";
		String input=in.nextLine();
		
		if(input.equals("...- ...-")) {
			while(!input.equals(". --- -")) {
				trans.add(input);
				input=in.nextLine();
			}
			trans.add(". --- -");
			
			for(int k=0; k<trans.size(); k++) {
				String reads[]=trans.get(k).split(" "+" ");
				sline++;
				for(int j=0; j<reads.length; j++) {
					String read[]=reads[j].split(" ");
					for(int i=0; i<read.length; i++) {
						int index=morse.indexOf(read[i]);
						char code=eng.get(index);
						System.out.print(code);
						if(sline>scan) {
							if(code=='1'||code=='2'||code=='3'||code=='4'||code=='5'||code=='6'||code=='7'||code=='8'||code=='9'||code=='0') {
								summary+=code;}}
					}
					if(j!=reads.length-1)
						System.out.print(" ");
				}
				System.out.println();
			}
				
			Iterator it=compare.iterator();
			while(it.hasNext()) {
				summary2+=(String) it.next();
			}
			Iterator it2=compare.iterator();
			while(it2.hasNext()) {
				reason+=(String) it2.next();
				if(it2.hasNext())
					reason+=" ";
			}
			System.out.println("\n"+reason);
			if(summary.equals(summary2)) {
				System.out.println("Result: Consistent Summary");}
			else {
				System.out.println("Result: Inconsistent Summary");}
			
			menu();
		}
		else {
			System.out.println("Must start with ...- ...-(only space at middle)");
			MorseReceive();
		}
	}
	
	public void MorseDisplay() {
		String display[]= {
				"A .-","B -...","C -.-.","D -..","E .","F ..-.","G --.","H ....","I ..","J .---","K -.-","L .-..","M --","N -.",
				"O ---","P .--.","Q --.-","R .-.","S ...","T -","U ..-","V ...-","W .--","X -..-","Y -.--","Z --..",
				". .-.-.-",", --..--",": ---...","\" .-..-.","' .----.","! -.-.--","? ..--..",
				"@ .--.-.","- -....-","; -.-.-.","( -.--.",") -.--.-","= -...-",
				"1 .----","2 ..---","3 ...--","4 ....-","5 .....","6 -....","7 --...","8 ---..","9 ----.","0 -----"
				};
		
		A173823_MorseTree <String> tree = new A173823_MorseTree <String>();		
		for(int i=0; i<display.length; i++) {
			tree.add(display[i], morse.get(i));
		}
		System.out.println();
		tree.inorder();
		System.out.println();
		menu();
	}
	
	public void MorseExit() {
		System.out.println("Bye dits-dahs..");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		A173823_Apps mc=new A173823_Apps();
		mc.menu();
	}
}
