package com.cs3560.service;


import com.cs3560.entity.Choice;
import com.cs3560.entity.Question;
import com.cs3560.entity.Student;

import java.util.*;

public class VotingServiceImpl implements QuestionInterface, StudentInterface {

    //Create container for list of questions
    private List<Question> questions;
    //Create container for list of students
    private List<Student> students;

    //Constant
    private final static int SINGLE_CHOICE = 2;
    private final static int MULTIPLE_CHOICE = 1;


    /**
     * Initialize students and questions
     */
    public VotingServiceImpl() {
        students = new ArrayList<>();
        questions = new ArrayList<>();
    }


    /**
     * Implement of create question
     * @return
     */
    @Override
    public int createQuestions() {

        //all the logical coding should use try-catch
        try {
            // create question #1
            //Initialize the choice of question
            List<Choice> listChoices = Helper.generateChoice(new char[]{'A', 'B', 'C', 'D'}, new String[]
                    {"Inheritance", "Encapsulation", "Polymorphism", "Abstraction"});
            //Initialize a question
            Question question = Helper.generateQuestion(1, "Where are the main features of OOPs? "
                    , MULTIPLE_CHOICE, listChoices);

            //  add question #1 to questions list
            questions.add(question);

            // Question #2
            //Initialize the choice of question
            listChoices = Helper.generateChoice(new char[]{'A', 'B', 'C', 'D'}, new String[]
                    {"System.out.println * \"Hello World\";", "System.out.println(\"Have a nice day\");",
                            "out.System.println{value);", "prntln. out (Programming is great fun);"});

            //Initialize a question
            question = Helper.generateQuestion(1, "Which of the following arc not valid println statements? " +
                    "(Indicate all that apply.)", MULTIPLE_CHOICE, listChoices);

            //add question #2 to questions list
            questions.add(question);

            // create question #3
            listChoices = Helper.generateChoice(new char[]{'A', 'B', 'C', 'D'}, new String[]
                    {"Andrea Ferro", "Adele Goldberg", "Alan Kay", "Dennis Ritchie"});
            //Initialize a question
            question = Helper.generateQuestion(1, "Who invented OOP? "
                    , SINGLE_CHOICE, listChoices);

            //  add question #3 to questions list
            questions.add(question);

            // Create Question #4
            listChoices = Helper.generateChoice(new char[]{'A', 'B', 'C', 'D'}, new String[]
                    {"Abstraction", "Polymorphism", "Encapsulation", "Inheritance"});
            //Initialize a question
            question = Helper.generateQuestion(1, "Which feature of OOP indicates code reusability?", SINGLE_CHOICE, listChoices);

            // add question #4 to questions list
            questions.add(question);

            // Create Question #5
            listChoices = Helper.generateChoice(new char[]{'A', 'B', 'C', 'D'}, new String[]
                    {"Kotlin", "SmallTalk", "Java", "C++"});
            //Initialize a question
            question = Helper.generateQuestion(1, "Which was the first purely object oriented programming" +
                    " language developed?", SINGLE_CHOICE, listChoices);

            // add question #5 to questions list
            questions.add(question);




        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }


    /**
     * return all the question in the list
     * @return
     */
    @Override
    public List<Question> getAllQuestion() {
        return questions;
    }

    /**
     * randomly generate student's ID
     * @param n
     */
    @Override
    public void randomStudent(int n) {


            Random random = new Random();
//            //randomly generate a student ID in range(0, 100]
//            Student s = new Student(random.nextInt(100)+"");
//            //add a student to student list
//            students.add(s);

            HashSet<Integer> num = Helper.generateUniqueNum(n);
            Iterator<Integer> numberOfStudent = num.iterator();
            while(numberOfStudent.hasNext()){

                int randomStudent = numberOfStudent.next() + random.nextInt(1001);
                Student s = new Student(randomStudent+"");
                students.add(s);
            }
            //randomly generate a student ID in range(0, 100]
            //Student s = new Student(random.nextInt(100)+"");
            //add a student to student list



    }


    /**
     * Simulate a student to answer question by using generate random number
     * @param question
     * @return Map<Character, Integer>
     */
    @Override
    public Map<Character, Integer> randomAnswerQuestion(Question question) {

        //Create a hashmap
        Map<Character, Integer> map = new HashMap<>();
        //get all the option that have been Initialized
        List<Choice> choiceList = question.getChoices();


        /**
         * Initialized the hashmap
         * key: A value: 0
         * key: B value: 0
         * key: C value: 0
         * key: D value: 0
         */
        for (int k = 0; k <choiceList.size(); k++){
            map.put(choiceList.get(k).getChoiceName(), 0);
        }

        // get the number of a question's choice
        int choiceSize = choiceList.size();
        // random generate a number between choice size
        Random random = new Random();

        //get each student to answer the questions
        for (int i = 0; i < students.size(); i++){

            // get the first student that we have generated
            Student student = students.get(i);

                //if we have single choice question
                if(question.getType() == SINGLE_CHOICE){

                    // Generate an answer between 0 and choice size - 1
                    // since list is using array structure begin in index 0
                    int studentAnswer = random.nextInt(choiceSize - 1);

                    String str = Helper.convertNumToLetter(studentAnswer);

                    System.out.println("Student " + student.getStudentID()+" selected " + str +" options");



                    // get the choice the student has answered
                    /**
                     * studentAnswer: 0 -> A
                     * studentAnswer: 1 -> B
                     * studentAnswer: 2 -> C
                     * studentAnswer: 3 -> D
                     */
                    Choice choice = choiceList.get(studentAnswer);

                    // if the key is existed
                    if(map.containsKey(choice.getChoiceName())){
                        // get the counter
                        int count = map.get(choice.getChoiceName());
                        // counter + 1
                        map.put(choice.getChoiceName(), ++ count);
                    }

                } else if (question.getType() == MULTIPLE_CHOICE){

                    //  how many answers are generated
                    int randomCounter = random.nextInt(choiceSize)+1 ;
                    // Print out each student' ID and how many choice they make
                    System.out.println("Student " + student.getStudentID()+" selected " + randomCounter +" option(s)");

                    // get the unique set of number by using helper function
                    HashSet<Integer> num = Helper.generateUniqueNum(randomCounter);
                    //using iterator to traverse the set
                    Iterator<Integer> numberOfAnswers = num.iterator();
                    // read from the set
                    while(numberOfAnswers.hasNext()){
                        // assign the studentAnswer from the hashset
                        int studentAnswer = numberOfAnswers.next();

                        // get the chioce the student has answered
                        Choice choice = choiceList.get(studentAnswer);

                        // if the key is existed
                        if(map.containsKey(choice.getChoiceName())){
                            // get the counter
                            int count = map.get(choice.getChoiceName());
                            // counter + 1
                            map.put(choice.getChoiceName(), ++ count);
                        }
                    }

                }

        }
        return map;
    }
}
