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
        System.out.print("Please Enter your name for your Personality Test: ");
        String userName = input.nextLine();

        for (int i = 0; i < personalityQuestions.length; i++) {
            System.out.println("\n" + (i + 1) + ". " + personalityQuestions[i][0]);
            System.out.println("A. " + personalityQuestions[i][1]);
            System.out.println("B. " + personalityQuestions[i][2]);

            char userQuestionAnswer;
            while (true) {
                System.out.print("Enter your answer (A/B): ");
                userQuestionAnswer = input.next().toUpperCase().charAt(0);
                if (userQuestionAnswer == 'A' || userQuestionAnswer == 'B') break;
                else System.out.println("Invalid Input. Please Enter only A or B from the Options.");
            }

            userResponses[i] = userQuestionAnswer;

            switch (personalityQuestions[i][3]) {
                case "EI" -> ei += (userQuestionAnswer == 'A') ? 1 : 0;
                case "SN" -> sn += (userQuestionAnswer == 'A') ? 1 : 0;
                case "TF" -> tf += (userQuestionAnswer == 'A') ? 1 : 0;
                case "JP" -> jp += (userQuestionAnswer == 'A') ? 1 : 0;
            }
        }

        System.out.println("\nHello " + userName + ", you selected:\n");

        for (int questionsBatch = 0; questionsBatch < 4; questionsBatch++) {
            int countA = 0;
            int countB = 0;

            for (int questionInBatch = 0; questionInBatch < 5; questionInBatch++) {
                int questionIndex = questionsBatch * 5 + questionInBatch;
                char selection = userResponses[questionIndex];

                String selectedAnswerDescription = (selection == 'A')
                        ? personalityQuestions[questionIndex][1]
                        : personalityQuestions[questionIndex][2];

                System.out.println("[" + selection + "] " + selectedAnswerDescription);

                if (selection == 'A') countA++;
                else countB++;
            }

            System.out.println("Number of A: " + countA + ", Number of B: " + countB + "\n");
        }

        String personalityType = ""
                + (ei >= 3 ? "E" : "I")
                + (sn >= 3 ? "S" : "N")
                + (tf >= 3 ? "T" : "F")
                + (jp >= 3 ? "J" : "P");

        System.out.println("Your MBTI personality type is: " + personalityType + "\n");
        showPersonalityDescription(personalityType);
    }
public static void showPersonalityDescription(String personalityType) {
        switch (personalityType) {
        	case "INTJ" -> System.out.println(
            "The INTJ personality type is imaginative and strategic, often planning for the future with meticulous precision. " +
            "Architects have a deep-seated thirst for knowledge and constantly seek to understand complex systems. " +
            "They are highly analytical and thrive on logic, often seeing through hypocrisy and inefficiencies. " +
            "Independent and self-confident, they prefer pursuing their goals alone or with like-minded peers. " +
            "INTJs value competence and are not afraid to challenge traditions or established norms. " +
            "They are creative problem-solvers, applying foresight to anticipate challenges. " +
            "While reserved, they form deep and lasting bonds with a select few. " +
            "INTJs often struggle with emotional nuance but respect authenticity when they encounter it. " +
            "They set high standards for themselves and others, which can come across as aloof. " +
            "Their strategic mindset helps them outmaneuver seemingly insurmountable obstacles. " +
            "Though private, they feel deeply and strive for meaningful understanding of the world. " +
            "Their lifelong mission is mastering their interests and pushing intellectual boundaries.\n\n" +

            "What INTJ stands for is Introverted, Intuitive, Thinking, and Judging. " +
            "Introversion means they recharge in solitude and think deeply before acting. " +
            "Intuition points to a preference for ideas, abstractions, and big-picture thinking. " +
            "Thinking shows their reliance on logic and objective reasoning in decision-making. " +
            "Judging reflects their structured and organized approach to life. " +
            "Together, these traits produce a personality that values order, insight, and long-term planning. " +
            "INTJs approach decisions rationally, preferring clear analysis over emotional impulses. " +
            "Their intuition allows them to spot patterns others miss and envision future trends. " +
            "With Judging, they impose structure to bring their visions into reality. " +
            "Their self-confidence stems from competence and internal validation. " +
            "Though not naturally expressive, they respect authenticity and intellectual honesty. " +
            "Their defining trait is using strategic thought to shape purposeful and efficient lives."
        );

        case "ENFP" -> System.out.println(
            "The ENFP personality type is enthusiastic and creative, often bringing optimism to every situation. " +
            "Campaigners have a vibrant curiosity and a deep desire to explore ideas and human connections. " +
            "They are empathetic and warm, easily sensing what others feel and need. " +
            "With imaginative thinking, they are drawn to original ideas and artistic expression. " +
            "Their joyful energy makes them natural storytellers and motivators. " +
            "They seek meaning in everyday interactions and believe deeply in human potential. " +
            "While they can be impulsive, they inspire others with boundless positivity. " +
            "They often live out their values by helping people or championing causes. " +
            "ENFPs thrive in flexible environments that allow freedom to explore. " +
            "They are resistant to routine yet capable of deep focus when passionate. " +
            "They may struggle with follow-through but are exceptional at generating possibilities. " +
            "Ultimately, they aim to connect authenticity with inspiration in everything they do.\n\n" +

            "What ENFP stands for is Extraverted, Intuitive, Feeling, and Perceiving. " +
            "Extraversion indicates they are energized by social interaction and active experiences. " +
            "Intuition means they prefer exploring ideas, big-picture thinking, and abstract concepts. " +
            "Feeling shows they base decisions on empathy, values, and harmony. " +
            "Perceiving highlights their spontaneous and adaptable nature. " +
            "Their extraversion makes them approachable and expressive. " +
            "Intuition fuels their creativity and ability to envision possibilities. " +
            "Feeling ensures they value emotional connections and human welfare. " +
            "Perceiving gives them flexibility and openness to new paths. " +
            "Combined, these traits form a soul-driven innovator who lights up rooms. " +
            "Their aim is to live authentically and connect deeply with others. " +
            "They are inspired to create positive change in both ideas and relationships."
        );
        
        case "ISTJ" -> System.out.println(
            "The ISTJ personality type is responsible and methodical, known for their strong sense of duty and dependability. " +
            "Often referred to as Logisticians, ISTJs take pride in their honesty and integrity. " +
            "They are meticulous and organized, ensuring that every task is completed correctly and efficiently. " +
            "ISTJs value traditions and prefer clearly defined structures and procedures. " +
            "They often become the backbone of families, organizations, and communities through their unwavering commitment. " +
            "While they may seem reserved, they show loyalty and care through actions rather than words. " +
            "They are practical thinkers who base decisions on facts, not feelings. " +
            "ISTJs thrive in environments where rules and expectations are clearly defined. " +
            "Although resistant to sudden change, they adapt well when given time and logical reasoning. " +
            "They uphold their responsibilities even in the face of adversity and prefer to work independently or with small, like-minded teams. " +
            "Their consistency, reliability, and loyalty make them indispensable in many roles.\n\n" +

            "What ISTJ stands for is Introverted, Sensing, Thinking, and Judging. " +
            "Introversion means they recharge in solitude and prefer reflection before action. " +
            "Sensing means they rely on real-world data and experience to understand the world. " +
            "Thinking shows they prioritize logic and objectivity in decision-making. " +
            "Judging reflects their need for structure, order, and planning. " +
            "Together, these traits result in a personality that values tradition, responsibility, and productivity. " +
            "ISTJs seek to uphold stability in their lives and institutions. " +
            "They believe in honoring their commitments and doing what is right, even when it is difficult. " +
            "They are focused, realistic, and believe in the power of perseverance."
        );

        case "ISFJ" -> System.out.println(
            "The ISFJ personality type is nurturing and reliable, often referred to as the Defender. " +
            "ISFJs are warm-hearted and devoted, placing great importance on the needs of others. " +
            "They are known for their deep sense of loyalty and responsibility, especially to friends, family, and causes they believe in. " +
            "Though reserved, ISFJs have a rich inner emotional life and remember even the smallest acts of kindness. " +
            "They are conscientious and meticulous in their efforts to create harmony and ensure others feel supported. " +
            "ISFJs often put the needs of others before their own, thriving in roles where they can quietly help and protect. " +
            "They respect tradition and prefer familiar routines that create stability. " +
            "While they may struggle with self-expression, their actions speak volumes. " +
            "ISFJs are often the unsung heroes who work behind the scenes to keep everything running smoothly. " +
            "They dislike conflict but will speak up when values or loved ones are threatened. " +
            "Their gentle nature, paired with their determination, makes them both loving and dependable.\n\n" +

            "What ISFJ stands for is Introverted, Sensing, Feeling, and Judging. " +
            "Introversion indicates they prefer calm, reflective environments. " +
            "Sensing shows they pay close attention to concrete details and practical realities. " +
            "Feeling emphasizes their empathy and concern for others' well-being. " +
            "Judging reflects their structured and orderly way of living. " +
            "Together, these traits make ISFJs compassionate caretakers who value harmony, tradition, and reliability. " +
            "They strive to do the right thing and serve others with quiet dedication. " +
            "Their memory for people and events helps them build strong, lasting relationships. " +
            "Though modest, they have a deep inner strength and a commitment to their responsibilities."
        );

	case "INFP" -> System.out.println(
            "The INFP personality type is deeply introspective and values authenticity above all. " +
            "Mediators are creative and idealistic, often using their imagination to envision a better world. " +
            "They care deeply about others and often express themselves through writing, art, or music. " +
            "INFPs are loyal to their values and tend to see the good in people. " +
            "They may appear quiet, but inside they are rich with emotion and passion.\n\n" +

            "What INFP stands for is Introverted, Intuitive, Feeling, and Perceiving. " +
            "Introversion gives them depth and sensitivity. " +
            "Intuition guides their creative exploration. " +
            "Feeling informs their values-based decisions. " +
            "Perceiving allows them to stay open and adaptable. " +
            "Together, these traits create a caring and artistic soul seeking harmony and expression."
        );

        case "ENTP" -> System.out.println(
            "The ENTP personality type is quick-witted, curious, and thrives on intellectual challenge. " +
            "Debaters love to argue—not for dominance, but to uncover truth. " +
            "They enjoy exploring ideas and playing devil’s advocate. " +
            "They value innovation, are often entrepreneurial, and find excitement in breaking norms.\n\n" +

            "What ENTP stands for is Extraverted, Intuitive, Thinking, and Perceiving. " +
            "Extraversion makes them energetic and socially confident. " +
            "Intuition lets them generate bold new ideas. " +
            "Thinking brings objectivity and logic. " +
            "Perceiving gives them flexibility and improvisation skills. " +
            "Together, these traits form a persuasive innovator who thrives in dynamic environments."
        );
        
        case "ENFJ" -> System.out.println(
            "The ENFJ personality type is charismatic, empathetic, and a natural leader of people. " +
            "Protagonists are driven by strong values and seek to inspire others to reach their full potential. " +
            "They are highly attuned to the emotions of those around them and excel at fostering unity. " +
            "ENFJs are organized, encouraging, and socially gifted.\n\n" +

            "What ENFJ stands for is Extraverted, Intuitive, Feeling, and Judging. " +
            "Extraversion makes them energetic and engaging. " +
            "Intuition fuels their big-picture thinking. " +
            "Feeling provides strong empathy and a values-driven approach. " +
            "Judging enables them to organize and take initiative. " +
            "Together, these traits create inspiring mentors who lead with passion and compassion."
        );
        
        case "INTP" -> System.out.println(
            "The INTP personality type is analytical, curious, and loves exploring abstract concepts. " +
            "Logicians are independent thinkers who constantly seek to understand how things work. " +
            "They enjoy problem-solving, theorizing, and intellectual debates. " +
            "INTPs can be reserved but are deeply passionate about their interests.\n\n" +

            "What INTP stands for is Introverted, Intuitive, Thinking, and Perceiving. " +
            "Introversion gives them space for deep thought. " +
            "Intuition helps them explore theoretical possibilities. " +
            "Thinking drives their logical analysis. " +
            "Perceiving allows flexibility and openness to new ideas. " +
            "Together, these traits make INTPs innovative thinkers who seek truth and understanding."
        );
        
        case "ENTJ" -> System.out.println(
            "The ENTJ personality type is commanding, ambitious, and natural at leading others. " +
            "Commanders are strategic thinkers who enjoy setting and achieving big goals. " +
            "They are decisive, confident, and often excel at organizing teams to accomplish complex objectives. " +
            "ENTJs value efficiency and are constantly seeking improvement.\n\n" +

            "What ENTJ stands for is Extraverted, Intuitive, Thinking, and Judging. " +
            "Extraversion gives them social assertiveness. " +
            "Intuition fuels their vision and strategic planning. " +
            "Thinking provides objective, logic-based decisions. " +
            "Judging grants structure and long-term planning skills. " +
            "Together, these traits create powerful leaders who thrive on challenge and achievement."
        );
        
        case "ISFP" -> System.out.println(
            "The ISFP personality type is gentle, sensitive, and artistic. " +
            "Adventurers express themselves through creativity and value living in the present moment. " +
            "They enjoy beautiful experiences, whether in nature, art, or personal relationships. " +
            "ISFPs are independent and deeply attuned to their emotions.\n\n" +

            "What ISFP stands for is Introverted, Sensing, Feeling, and Perceiving. " +
            "Introversion gives them inner reflection and focus. " +
            "Sensing keeps them grounded in real experiences. " +
            "Feeling makes them empathetic and compassionate. " +
            "Perceiving offers spontaneity and openness. " +
            "These traits combine to form creative, kind individuals who value freedom and self-expression."
        );
        
        case "ISTP" -> System.out.println(
            "The ISTP personality type is practical, independent, and analytical. " +
            "Virtuosos enjoy figuring out how things work and often excel at hands-on problem-solving. " +
            "They are adaptable and spontaneous, thriving in situations where quick thinking is required. " +
            "ISTPs are action-oriented and value personal freedom.\n\n" +

            "What ISTP stands for is Introverted, Sensing, Thinking, and Perceiving. " +
            "Introversion makes them self-reliant and reflective. " +
            "Sensing allows them to focus on real-time details. " +
            "Thinking gives them objective, logical decision-making. " +
            "Perceiving keeps them flexible and adaptable. " +
            "Together, these traits create pragmatic problem-solvers who enjoy mastering skills and tools."
        );
        
        case "ESFJ" -> System.out.println(
            "The ESFJ personality type is warm, caring, and community-oriented. " +
            "Consuls enjoy supporting others and creating harmony in their social groups. " +
            "They value traditions, loyalty, and social structure. " +
            "ESFJs are highly tuned into others' emotions and work hard to maintain peace and cooperation.\n\n" +

            "What ESFJ stands for is Extraverted, Sensing, Feeling, and Judging. " +
            "Extraversion makes them sociable and approachable. " +
            "Sensing keeps them focused on concrete facts. " +
            "Feeling drives their empathy and desire for harmony. " +
            "Judging enables them to organize and take responsibility. " +
            "Together, these traits make ESFJs nurturing leaders who foster positive relationships."
        );

	case "ESTJ" -> System.out.println(
            "The ESTJ personality type is organized, practical, and takes charge of situations. " +
            "Executives are natural leaders who enjoy bringing order and efficiency to their environments. " +
            "They value tradition, rules, and responsibility, often becoming pillars of their communities or workplaces. " +
            "ESTJs prefer clarity, logic, and measurable results.\n\n" +

            "What ESTJ stands for is Extraverted, Sensing, Thinking, and Judging. " +
            "Extraversion gives them confidence in social settings. " +
            "Sensing focuses them on facts and current realities. " +
            "Thinking helps them make objective decisions. " +
            "Judging allows them to plan and organize effectively. " +
            "These traits form decisive, disciplined leaders who take pride in their work and responsibilities."
        );

	case "ESTP" -> System.out.println(
            "The ESTP personality type is energetic, action-oriented, and loves living in the moment. " +
            "Entrepreneurs are bold risk-takers who enjoy excitement and hands-on problem-solving. " +
            "They are natural performers who thrive in dynamic environments where they can react quickly. " +
            "ESTPs value freedom and are often the life of the party, bringing enthusiasm wherever they go.\n\n" +

            "What ESTP stands for is Extraverted, Sensing, Thinking, and Perceiving. " +
            "Extraversion makes them outgoing and sociable. " +
            "Sensing keeps them grounded in real-world experiences. " +
            "Thinking brings logic and practicality to decisions. " +
            "Perceiving allows them flexibility and spontaneity. " +
            "Together, these qualities create an adventurous and adaptable personality."
        );
        
     case "ESFP" -> System.out.println(
            "The ESFP personality type is spontaneous, vibrant, and lives for the present moment. " +
            "Entertainers are outgoing, playful, and love to make others smile. " +
            "They seek fun and excitement, often thriving in lively social situations. " +
            "Their energetic nature draws people to them, and they enjoy creating memorable experiences. " +
            "ESFPs value freedom, avoid routine, and prefer to experience life through their senses. " +
            "They are highly observant, noticing small details that others might miss, and love to share joy with others. " +
            "Though sometimes seen as impulsive, they bring enthusiasm and warmth to any situation.\n\n" +

            "What ESFP stands for is Extraverted, Sensing, Feeling, and Perceiving. " +
            "Extraversion energizes them through social interaction. " +
            "Sensing keeps them grounded in the here and now, enjoying sensory pleasures. " +
            "Feeling allows them to empathize with others and build emotional connections. " +
            "Perceiving makes them flexible, spontaneous, and open to new experiences. " +
            "Together, these traits make ESFPs lively, fun-loving, and caring individuals who light up any room they enter."
        );
        
                           default -> System.out.println(
            "Visit https://www.16personalities.com/" + personalityType.toLowerCase() + "-personality for more details."
        );
   }
    }
}