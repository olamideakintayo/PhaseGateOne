// MBTIPersonalityTest.js

const prompt = require('prompt-sync')();

const personalityQuestions = [
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
];

function runPersonalityTest() {
    let ei = 0;
    let sn = 0;
    let tf = 0;
    let jp = 0;

    const userResponses = [];
    const userName = prompt("Please Enter your name for your Personality Test: ");

    for (let i = 0; i < personalityQuestions.length; i++) {
        console.log(`\n${i + 1}. ${personalityQuestions[i][0]}`);
        console.log(`A. ${personalityQuestions[i][1]}`);
        console.log(`B. ${personalityQuestions[i][2]}`);

        let userQuestionAnswer;
        while (true) {
            userQuestionAnswer = prompt("Enter your answer (A/B): ").toUpperCase();
            if (userQuestionAnswer === 'A' || userQuestionAnswer === 'B') break;
            else console.log("Invalid Input. Please Enter only A or B from the Options.");
        }

        userResponses[i] = userQuestionAnswer;

        switch (personalityQuestions[i][3]) {
            case "EI":
                ei += (userQuestionAnswer === 'A') ? 1 : 0;
                break;
            case "SN":
                sn += (userQuestionAnswer === 'A') ? 1 : 0;
                break;
            case "TF":
                tf += (userQuestionAnswer === 'A') ? 1 : 0;
                break;
            case "JP":
                jp += (userQuestionAnswer === 'A') ? 1 : 0;
                break;
        }
    }

    console.log(`\nHello ${userName}, you selected:\n`);

    for (let questionsBatch = 0; questionsBatch < 4; questionsBatch++) {
        let countA = 0;
        let countB = 0;

        for (let questionInBatch = 0; questionInBatch < 5; questionInBatch++) {
            let questionIndex = questionsBatch * 5 + questionInBatch;
            let selection = userResponses[questionIndex];

            let selectedAnswerDescription = (selection === 'A')
                ? personalityQuestions[questionIndex][1]
                : personalityQuestions[questionIndex][2];

            console.log(`[${selection}] ${selectedAnswerDescription}`);

            if (selection === 'A') countA++;
            else countB++;
        }

        console.log(`Number of A: ${countA}, Number of B: ${countB}\n`);
    }

    let personalityType = ""
        + (ei >= 3 ? "E" : "I")
        + (sn >= 3 ? "S" : "N")
        + (tf >= 3 ? "T" : "F")
        + (jp >= 3 ? "J" : "P");

    console.log(`Your MBTI personality type is: ${personalityType}\n`);
    showPersonalityDescription(personalityType);
}

function showPersonalityDescription(personalityType) {
    switch (personalityType) {
        case "INTJ":
            console.log(
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
            break;
        default:
            console.log("MBTI description for this type is not yet implemented.");
    }
}


runPersonalityTest();
