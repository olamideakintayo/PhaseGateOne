import java.util.Scanner;

public class MBTIPersonalityTest {

    static String[][] personalityQuestions = {
        {"Do you:", "expend energy, enjoy groups", "conserve energy, enjoy one-on-one", "EI"},
        {"Do you:", "Interpret literally", "look for meaning and possibilities", "SN"},
        {"Are you:", "logical, thinking, questioning", "empathetic, feeling, accommodating", "TF"},
        {"Are you:", "organized, orderly", "flexible, adaptable", "JP"},
        {"Are you:", "more outgoing, think out loud", "more reserved, think to yourself", "EI"},
        {"Are you:", "practical, realistic, experiential", "imaginative, innovative, theoretical", "SN"},
        {"Are you:", "candid, straight forward, frank", "tactful, kind, encouraging", "TF"},
        {"Do you prefer to:", "plan, schedule", "unplanned, spontaneous", "JP"},
        {"Do you:", "seek many tasks, public activities, interaction with others", "seek private, solitary activities with quiet to concentrate", "EI"},
        {"Are you:", "standard, usual, conventional", "different, novel, unique", "SN"},
        {"Are you:", "firm, tend to criticize, hold the line", "gentle, tend to appreciate, conciliate", "TF"},
        {"Do you prefer a:", "regulated, structured", "easy-going, live and let live", "JP"},
        {"Are you:", "external, communicative, express yourself", "internal, reticent, keep to yourself", "EI"},
        {"Do you:", "focus on here-and-now", "look to the future, global perspective, big picture", "SN"},
        {"Are you:", "tough-minded, just", "tender-hearted, merciful", "TF"},
        {"Do you:", "preparation, plan ahead", "go with the flow, adapt as you go", "JP"},
        {"Are you:", "active, initiate", "reflective, deliberate", "EI"},
        {"Do you focus on:", "facts, things, what is", "ideas, dreams, what could be, philosophical", "SN"},
        {"Are you:", "matter of fact, issue-oriented", "sensitive, people-oriented, compassionate", "TF"},
        {"Do you prefer to:", "control, govern", "latitude, freedom", "JP"}
    };
    
    public static void runPersonalityTest() {
    	Scanner input = new Scanner(System.in);
    	int ei = 0;
    	int sn = 0;
    	int tf = 0;
    	int jp = 0;
    	
    	char[] userResponses = new char[20];
    	System.out.print("Please Neter your name for your Personality Test: ");
    	String userName = input.nextLine();
    	
    	for(int i = 0; i < personalityQuestions.length; i++) {
    		System.out.println("\n" + (i + 1) + ". " + personalityQuestions[i][0]);
    		System.out.println("A. " + personalityQuestions[i][1]);
    		System.out.println("B. " + personalityQuestions[1][2]);
    		char userQuestionAnswer;
    		
    		while(true) {
    		System.out.print("Enter your answer (A/B): ");
    		userQuestionAnswer = input.next().toUpperCase().charAt(0);
    		if(userQuestionAnswer == 'A' || userQuestionAnswer == 'B') break;
    		else{
    		System.out.println("Invalid Input. Please Enter only A or B from the Options.");
    		}
    		userResponses[i] = userQuestionAnswer;
    	}
    }
    }
}