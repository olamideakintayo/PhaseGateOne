# mbti_personality_test.py

personality_questions = [
    ["Do you:", "expend energy, enjoy groups", "conserve energy, enjoy one-on-one", "EI"],
    ["Do you:", "Interpret literally", "look for meaning and possibilities", "SN"],
    ["Are you:", "logical, thinking, questioning", "empathetic, feeling, accommodating", "TF"],
    ["Are you:", "organized, orderly", "flexible, adaptable", "JP"],
    ["Are you:", "more outgoing, think out loud", "more reserved, think to yourself", "EI"],
    ["Are you:", "practical, realistic, experiential", "imaginative, innovative, theoretical", "SN"],
    ["Are you:", "candid, straight forward, frank", "tactful, kind, encouraging", "TF"],
    ["Do you prefer to:", "plan, schedule", "unplanned, spontaneous", "JP"],
    ["Do you:", "seek many tasks, public activities, interaction with others", "seek private, solitary activities with quiet to concentrate", "EI"],
    ["Are you:", "standard, usual, conventional", "different, novel, unique", "SN"],
    ["Are you:", "firm, tend to criticize, hold the line", "gentle, tend to appreciate, conciliate", "TF"],
    ["Do you prefer a:", "regulated, structured", "easy-going, live and let live", "JP"],
    ["Are you:", "external, communicative, express yourself", "internal, reticent, keep to yourself", "EI"],
    ["Do you:", "focus on here-and-now", "look to the future, global perspective, big picture", "SN"],
    ["Are you:", "tough-minded, just", "tender-hearted, merciful", "TF"],
    ["Do you:", "preparation, plan ahead", "go with the flow, adapt as you go", "JP"],
    ["Are you:", "active, initiate", "reflective, deliberate", "EI"],
    ["Do you focus on:", "facts, things, what is", "ideas, dreams, what could be, philosophical", "SN"],
    ["Are you:", "matter of fact, issue-oriented", "sensitive, people-oriented, compassionate", "TF"],
    ["Do you prefer to:", "control, govern", "latitude, freedom", "JP"]
]

def run_personality_test():
    ei = sn = tf = jp = 0
    user_responses = [''] * 20

    user_name = input("Please Enter your name for your Personality Test: ")

    for i in range(len(personality_questions)):
        print(f"\n{i + 1}. {personality_questions[i][0]}")
        print(f"A. {personality_questions[i][1]}")
        print(f"B. {personality_questions[i][2]}")

        while True:
            user_question_answer = input("Enter your answer (A/B): ").strip().upper()
            if user_question_answer in ('A', 'B'):
                break
            else:
                print("Invalid Input. Please Enter only A or B from the Options.")

        user_responses[i] = user_question_answer

        category = personality_questions[i][3]
        if category == "EI":
            ei += 1 if user_question_answer == 'A' else 0
        elif category == "SN":
            sn += 1 if user_question_answer == 'A' else 0
        elif category == "TF":
            tf += 1 if user_question_answer == 'A' else 0
        elif category == "JP":
            jp += 1 if user_question_answer == 'A' else 0

    print(f"\nHello {user_name}, you selected:\n")

    for questions_batch in range(4):
        count_a = 0
        count_b = 0

        for question_in_batch in range(5):
            question_index = questions_batch * 5 + question_in_batch
            selection = user_responses[question_index]

            selected_answer_description = (
                personality_questions[question_index][1]
                if selection == 'A' else
                personality_questions[question_index][2]
            )

            print(f"[{selection}] {selected_answer_description}")

            if selection == 'A':
                count_a += 1
            else:
                count_b += 1

        print(f"Number of A: {count_a}, Number of B: {count_b}\n")

    personality_type = (
        ("E" if ei >= 3 else "I") +
        ("S" if sn >= 3 else "N") +
        ("T" if tf >= 3 else "F") +
        ("J" if jp >= 3 else "P")
    )

    print(f"Your MBTI personality type is: {personality_type}\n")
    show_personality_description(personality_type)
def show_personality_description(personality_type: str):
    descriptions = {
        "INTJ": (
            "The INTJ personality type is imaginative and strategic, often planning for the future with meticulous precision. "
            "Architects have a deep-seated thirst for knowledge and constantly seek to understand complex systems. "
            "They are highly analytical and thrive on logic, often seeing through hypocrisy and inefficiencies. "
            "Independent and self-confident, they prefer pursuing their goals alone or with like-minded peers. "
            "INTJs value competence and are not afraid to challenge traditions or established norms. "
            "They are creative problem-solvers, applying foresight to anticipate challenges. "
            "While reserved, they form deep and lasting bonds with a select few. "
            "INTJs often struggle with emotional nuance but respect authenticity when they encounter it. "
            "They set high standards for themselves and others, which can come across as aloof. "
            "Their strategic mindset helps them outmaneuver seemingly insurmountable obstacles. "
            "Though private, they feel deeply and strive for meaningful understanding of the world. "
            "Their lifelong mission is mastering their interests and pushing intellectual boundaries.\n\n"

            "What INTJ stands for is Introverted, Intuitive, Thinking, and Judging. "
            "Introversion means they recharge in solitude and think deeply before acting. "
            "Intuition points to a preference for ideas, abstractions, and big-picture thinking. "
            "Thinking shows their reliance on logic and objective reasoning in decision-making. "
            "Judging reflects their structured and organized approach to life. "
            "Together, these traits produce a personality that values order, insight, and long-term planning. "
            "INTJs approach decisions rationally, preferring clear analysis over emotional impulses. "
            "Their intuition allows them to spot patterns others miss and envision future trends. "
            "With Judging, they impose structure to bring their visions into reality. "
            "Their self-confidence stems from competence and internal validation. "
            "Though not naturally expressive, they respect authenticity and intellectual honesty. "
            "Their defining trait is using strategic thought to shape purposeful and efficient lives."
        ),

        "ENFP": (
            "The ENFP personality type is enthusiastic and creative, often bringing optimism to every situation. "
            "Campaigners have a vibrant curiosity and a deep desire to explore ideas and human connections. "
            "They are empathetic and warm, easily sensing what others feel and need. "
            "With imaginative thinking, they are drawn to original ideas and artistic expression. "
            "Their joyful energy makes them natural storytellers and motivators. "
            "They seek meaning in everyday interactions and believe deeply in human potential. "
            "While they can be impulsive, they inspire others with boundless positivity. "
            "They often live out their values by helping people or championing causes. "
            "ENFPs thrive in flexible environments that allow freedom to explore. "
            "They are resistant to routine yet capable of deep focus when passionate. "
            "They may struggle with follow-through but are exceptional at generating possibilities. "
            "Ultimately, they aim to connect authenticity with inspiration in everything they do.\n\n"

            "What ENFP stands for is Extraverted, Intuitive, Feeling, and Perceiving. "
            "Extraversion indicates they are energized by social interaction and active experiences. "
            "Intuition means they prefer exploring ideas, big-picture thinking, and abstract concepts. "
            "Feeling shows they base decisions on empathy, values, and harmony. "
            "Perceiving highlights their spontaneous and adaptable nature. "
            "Their extraversion makes them approachable and expressive. "
            "Intuition fuels their creativity and ability to envision possibilities. "
            "Feeling ensures they value emotional connections and human welfare. "
            "Perceiving gives them flexibility and openness to new paths. "
            "Combined, these traits form a soul-driven innovator who lights up rooms. "
            "Their aim is to live authentically and connect deeply with others. "
            "They are inspired to create positive change in both ideas and relationships."
        ),

        "ISTJ": (
            "The ISTJ personality type is responsible and methodical, known for their strong sense of duty and dependability. "
            "Often referred to as Logisticians, ISTJs take pride in their honesty and integrity. "
            "They are meticulous and organized, ensuring that every task is completed correctly and efficiently. "
            "ISTJs value traditions and prefer clearly defined structures and procedures. "
            "They often become the backbone of families, organizations, and communities through their unwavering commitment. "
            "While they may seem reserved, they show loyalty and care through actions rather than words. "
            "They are practical thinkers who base decisions on facts, not feelings. "
            "ISTJs thrive in environments where rules and expectations are clearly defined. "
            "Although resistant to sudden change, they adapt well when given time and logical reasoning. "
            "They uphold their responsibilities even in the face of adversity and prefer to work independently or with small, like-minded teams. "
            "Their consistency, reliability, and loyalty make them indispensable in many roles.\n\n"

            "What ISTJ stands for is Introverted, Sensing, Thinking, and Judging. "
            "Introversion means they recharge in solitude and prefer reflection before action. "
            "Sensing means they rely on real-world data and experience to understand the world. "
            "Thinking shows they prioritize logic and objectivity in decision-making. "
            "Judging reflects their need for structure, order, and planning. "
            "Together, these traits result in a personality that values tradition, responsibility, and productivity. "
            "ISTJs seek to uphold stability in their lives and institutions. "
            "They believe in honoring their commitments and doing what is right, even when it is difficult. "
            "They are focused, realistic, and believe in the power of perseverance."
        ),

        }

    description = descriptions.get(personality_type.upper())
    if description:
        print(description)
    else:
        print(f"Visit https://www.16personalities.com/{personality_type.lower()}-personality for more details.")


if __name__ == "__main__":
    run_personality_test()
