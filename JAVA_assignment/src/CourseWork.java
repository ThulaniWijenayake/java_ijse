
import java.util.InputMismatchException;
import java.util.Scanner;
    public class CourseWork {

        // static variables
        static int s_count = 0;
        static int i,j;
        static String name,ID,answer;
        static String [] student_name = new String [100];
        static String [] student_ID = new String [100];
        static int [] CSF_marks = new int [100];
        static int [] DBMS_marks = new int [100];

        // main method
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            while (true){
                System.out.println("----------------------------------------------------------------------------------");

                System.out.println("|                      WELCOME TO GDSE MARKS MANAGMENT SYSTEM                    |");

                System.out.println("----------------------------------------------------------------------------------");
                System.out.println();
                System.out.print("[1] Add New Student ");
                System.out.print("                       [2] Add New Student with Marks");
                System.out.println("");
                System.out.print("[3] Add Marks");
                System.out.print("                              [4] Update Student Details");
                System.out.println("");
                System.out.print("[5] Update Marks");
                System.out.print("                           [6] Delete Student");
                System.out.println("");
                System.out.print("[7] Print Student Details");
                System.out.print("                  [8] Print Student Ranks");
                System.out.println();
                System.out.print("[9] Best in Programming Fundementals");
                System.out.print("       [10] Best in Database Managment System");
                System.out.println();
                System.out.println();

                System.out.println("Enter an option to continue >  ");
                try{
                    int option = input.nextInt();

                    switch(option) {
                        case 1:
                            Addnewstudent();
                            break;
                        case 2:
                            AddNewStudentWithMarks();
                            break;
                        case 3:
                            Addmarks();
                            break;
                        case 4:
                            updateStudentDetails();
                            break;
                        case 5:
                            updateMarks();
                            break;
                        case 6:
                            deleteStudent();
                            break;
                        case 7:
                            printStudentDetails();
                            break;
                        case 8:
                            printStudentRanks();
                            break;
                        case 9:
                            bestInProgrammingFundamentals();
                            break;
                        case 10:
                            bestIndbms();
                            break;
                        default:
                            System.out.println("Invalid Option!");
                    }}catch (InputMismatchException e) {
                    System.out.println("PLease enter an Integer !!");
                    input.next();
                }
            }


        }




        // Adding a new student to the system
        public static void Addnewstudent(){

            System.out.println("----------------------------------------------------------------------------------");

            System.out.println("                              Add New Student                                     ");

            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();



            outer:
            while (s_count != 100) {
                Scanner input = new Scanner(System.in);

                System.out.print("Enter Student ID: ");
                String ID = input.nextLine();

                // validating the student id and if not repeating the process
                if (ID.length() != 4 || !(ID.charAt(0) == 's' || ID.charAt(0) == 'S')) {
                    System.out.println("Invalid Student ID format. Please check again!");
                    continue;
                }

                // iterating through student_ID array to see whether the ID already  exists or not
                for (int i = 0; i < s_count; i++) {
                    if (ID.equals(student_ID[i])) {
                        System.out.println("Student ID already exists! Do you want add another student? ");
                        String choice = input.nextLine();
                        if (choice.equalsIgnoreCase("y")) {
                            continue outer;
                        }else if (choice.equalsIgnoreCase("n")) {
                            break outer;

                        }
                    }
                }
                System.out.print("Enter Student Name: ");
                String name = input.nextLine();

                // storing the student ID and the name in arrays respectively
                student_ID[s_count] = ID;
                student_name[s_count] = name;

                System.out.print("Student added successfully! Do you want to add a new student (y/n)? ");
                String answer = input.next();
                s_count++;
                if (answer.equalsIgnoreCase("n")) {
                    break;
                }else if(answer.equalsIgnoreCase("y")){
                    continue;
                }



            }
        }

        // method to validate marks
        public static boolean validate_marks(int marks) {
            return marks >= 0 && marks <= 100;
        }


        // Adding new student with marks
        public static void AddNewStudentWithMarks() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                          Add New Student with Marks                              ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();

            outer:
            while (s_count != 100) {
                Scanner input = new Scanner(System.in);

                System.out.print("Enter Student ID: ");
                String ID = input.nextLine();

                if (ID.length() != 4 || !(ID.charAt(0) == 's' || ID.charAt(0) == 'S')) {
                    System.out.println("Invalid Student ID format. Please check again!");
                    continue;
                }

                for (int i = 0; i < s_count; i++) {
                    if (ID.equals(student_ID[i])) {
                        System.out.println("Student ID already exists!");
                        continue outer;
                    }
                }

                System.out.print("Enter Student Name: ");
                String name = input.nextLine();

                // taking csf and dbms marks from the user
                int dbms_marks;
                while (true) {
                    System.out.print("Enter DBMS marks: ");

                    dbms_marks = input.nextInt();
                    if (validate_marks(dbms_marks)) {

                        break;
                    } else {
                        System.out.println("Invalid Marks, Please enter the correct Marks (0-100)!");
                    }

                }

                int csf_marks;
                while (true) {
                    System.out.print("Enter CSF marks: ");

                    csf_marks = input.nextInt();
                    if (validate_marks(csf_marks)) {

                        break;
                    } else {
                        System.out.println("Invalid Marks, Please enter the correct Marks (0-100)!");
                    }

                }

                // storing the info in arrays respectively

                student_ID[s_count] = ID;
                student_name[s_count] = name;
                CSF_marks[s_count] = csf_marks;
                DBMS_marks[s_count] = dbms_marks;


                System.out.print("Student added successfully! Do you want to add a new student (y/n)? ");
                String answer = input.next();
                s_count++;
                if (answer.equalsIgnoreCase("n")) {
                    break;
                }


            }
        }


        // method to find the array index from the array student_ID
        public static int findindex(String ID) {

            for (int i = 0; i < s_count; i++) {

                if (ID.equals(student_ID[i])) {

                    return i;
                }
            }
            return -1;
        }


        // Adding marks for the students who haven't added their marks
        public static void Addmarks() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                               Add Marks                                          ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.print("Enter Student ID: ");
                String ID = input.nextLine();

                if (ID.length() != 4 || !(ID.charAt(0) == 's' || ID.charAt(0) == 'S')) {
                    System.out.println("Invalid Student ID format. Do you want to check again?");
                    String choice = input.nextLine();
                    if (choice.equalsIgnoreCase("y")) {
                        continue;
                    }else if (answer.equalsIgnoreCase("n")) {
                        break;

                    }
                }

                //getting the student index from using the entered student ID and the findindex method
                int studentIndex = findindex(ID);


                //checking whether the student ID exists in the array or not
                if (studentIndex == -1) {
                    System.out.println("Invalid Student ID!");
                    System.out.print("Do you want to continue searching (y/n)? ");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }else if(answer.equalsIgnoreCase("y")){
                        continue;
                    }

                }
                // checking whether the marks are already assigned or not
                else if (CSF_marks[studentIndex] != 0 || DBMS_marks[studentIndex] != 0) {
                    System.out.println("Marks for this student have already been assigned! \4n if you want to update the marks,please use [4] Update Marks option.");
                    System.out.print("Do you want to add marks for another student (y/n)? ");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    } else if(answer.equalsIgnoreCase("y")){
                        continue;
                    }
                } else {
                    // printing the student name according to the student ID
                    System.out.println("Student Name: " + student_name[studentIndex]);

                    int csf_marks;
                    while (true) {
                        System.out.print("Enter CSF marks: ");

                        csf_marks = input.nextInt();
                        if (validate_marks(csf_marks)) {

                            CSF_marks[studentIndex] = csf_marks;
                            break;
                        } else {
                            System.out.println("Invalid Marks, Please enter the correct Marks (0-100)!");
                        }

                    }


                    while (true) {
                        System.out.print("Enter DBMS marks: ");

                        int dbms_marks = input.nextInt();
                        if (validate_marks(dbms_marks)) {

                            DBMS_marks[studentIndex] = dbms_marks;
                            break;
                        } else {
                            System.out.println("Invalid Marks, Please enter the correct Marks (0-100)!");
                        }

                    }




                    System.out.println("Marks added successfully!");

                    System.out.print("Do you want to add marks for another student (y/n)? ");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }else if(answer.equalsIgnoreCase("y")){
                        continue;
                    }
                }
            }
        }




        //updating student name as user wants
        public static void updateStudentDetails() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                           Update Student Details                                 ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.print("Enter Student ID: ");
                String ID = input.nextLine();

                if (ID.length() != 4 || !(ID.charAt(0) == 's' || ID.charAt(0) == 'S')) {
                    System.out.println("Invalid Student ID format. Please check again!");
                    System.out.print("Do you want to continue updating student details (y/n)? ");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }
                    continue;
                }

                int studentIndex = findindex(ID);

                if (studentIndex == -1) {
                    System.out.println("Invalid Student ID!");
                    System.out.print("Do you want to continue searching (y/n)? ");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }
                } else {

                    // printing the current student name  and asking for the new name
                    System.out.println("Current Student Name: " + student_name[studentIndex]);


                    System.out.print("Enter New Student Name: ");
                    String newName = input.nextLine();

                    // assigning the new name to the respective array index
                    student_name[studentIndex] = newName;

                    System.out.println("Student details updated successfully!");

                    System.out.print("Do you want to update details for another student (y/n)? ");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            }
        }

        // updating the entered marks as user wants
        public static void updateMarks() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                           Update Student Marks                                   ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.print("Enter Student ID: ");
                String ID = input.nextLine();

                if (ID.length() != 4 || !(ID.charAt(0) == 's' || ID.charAt(0) == 'S')) {
                    System.out.println("Invalid Student ID format. Please check again!");
                    System.out.print("Do you want to continue updating marks (y/n)? ");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }
                    continue;
                }

                int studentIndex = findindex(ID);

                if (studentIndex == -1) {
                    System.out.println("Invalid Student ID!");
                    System.out.print("Do you want to continue searching (y/n)? ");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }else{
                        continue;
                    }
                } else {

                    // printing out the entered details if the marks indexes aren't empty
                    if (CSF_marks[studentIndex] != 0 || DBMS_marks[studentIndex] != 0) {
                        System.out.println("Current Details:");
                        System.out.println("Student Name: " + student_name[studentIndex]);
                        System.out.println("CSF Marks: " + CSF_marks[studentIndex]);
                        System.out.println("DBMS Marks: " + DBMS_marks[studentIndex]);

                        int csf_marks;
                        while (true) {
                            System.out.print("Enter new CSF marks: ");
                            csf_marks = input.nextInt();
                            if (validate_marks(csf_marks)) {

                                CSF_marks[studentIndex] = csf_marks;
                                break;
                            } else {
                                System.out.println("Invalid Marks, Please enter the correct Marks (0-100)!");
                            }
                        }

                        int dbms_marks;
                        while (true) {
                            System.out.print("Enter new DBMS marks: ");
                            dbms_marks = input.nextInt();
                            if (validate_marks(dbms_marks)) {

                                DBMS_marks[studentIndex] = dbms_marks;
                                break;
                            } else {
                                System.out.println("Invalid Marks, Please enter the correct Marks (0-100)!");
                            }
                        }

                        System.out.println("Marks updated successfully!");

                        System.out.print("Do you want to update marks for another student (y/n)? ");
                        String answer = input.next();
                        if (answer.equalsIgnoreCase("n")) {
                            break;
                        }
                    } else {
                        System.out.println("This student's marks yet to be added!");
                        System.out.print("Do you want to continue updating marks (y/n)? ");
                        String answer = input.next();
                        if (answer.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                }
            }
        }


        // deleting the student with all the details
        public static void deleteStudent() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                             Delete Student                                      ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();

            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.print("Enter Student ID: ");
                String ID = input.nextLine();

                if (ID.length() != 4 || !(ID.charAt(0) == 's' || ID.charAt(0) == 'S')) {
                    System.out.println("Invalid Student ID format. Please check again!");
                    System.out.print("Do you want to continue deleting a student (y/n)? ");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }
                    continue;
                }

                int studentIndex = findindex(ID);

                if (studentIndex == -1) {
                    System.out.println("Invalid Student ID!");
                    System.out.print("Do you want to continue searching (y/n)? ");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }else if(answer.equalsIgnoreCase("y")){
                        continue;
                    }
                } else {


                    System.out.print("Are you sure you want to delete this student (y/n)? ");
                    String confirm = input.next();
                    if (confirm.equalsIgnoreCase("y")) {
                        // Delete the student
                        for (int i = studentIndex; i < s_count - 1; i++) {
                            student_ID[s_count - 1] = null;
                            student_name[s_count - 1] = null;
                            CSF_marks[s_count - 1] = 0;
                            DBMS_marks[s_count - 1] = 0;
                        }


                        s_count--;

                        System.out.println("Student deleted successfully!");

                    }

                    System.out.print("Do you want to delete another student (y/n)? ");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }else if(answer.equalsIgnoreCase("y")){
                        continue;
                    }
                }
            }
        }


        // printing the student details when the user enters a student ID
        public static void printStudentDetails() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                            Student Details                                      ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();

            Scanner input = new Scanner(System.in);
            while(true){
                if (s_count == 0) {
                    System.out.println("No student records found!");
                    return;
                }

                System.out.print("Enter Student ID: ");
                String ID = input.nextLine();

                if (ID.length() != 4 || !(ID.charAt(0) == 's' || ID.charAt(0) == 'S')) {
                    System.out.println("Invalid Student ID format. Please check again!");
                    System.out.print("Do you want to continue printing student details (y/n)? ");
                    String answer = input.nextLine();
                    if (answer.equalsIgnoreCase("n")) {
                        break;
                    }
                    continue;
                }

                // finding the student index via student ID
                int index = -1;
                for (int i = 0; i < s_count; i++) {
                    if (student_ID[i].equals(ID)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("No student found with the entered ID.");
                    continue;
                }

                // checking whether the marks have been added or not
                if (CSF_marks[index] == -1 || DBMS_marks[index] == -1) {
                    System.out.println("Marks haven't been added yet for this student.");
                } else {
                    // calculating the total , average marks and the ranks
                    int totalMarks = CSF_marks[index] + DBMS_marks[index];
                    double averageMarks = totalMarks / 2.0;
                    int rank = calculateRank(index);

                    // printing out all the details
                    System.out.println( "Student name: "+student_name[index]);
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("Programming Fundementals Marks \t\t |"+ CSF_marks[index] );
                    System.out.println("Database Management System Marks \t |"+ DBMS_marks[index] );

                    System.out.println("Total Marks \t\t\t\t |" + totalMarks);
                    System.out.println("Average Marks \t\t\t\t |" + averageMarks);
                    System.out.println("Rank \t\t\t\t\t |" + rank + getRankText(rank));
                    System.out.println("----------------------------------------------------------------------------------");

                    System.out.println();


                }

                System.out.println();
                System.out.println("Do you want to continue seeking student details? (Y/N)");
                String choice = input.next();

                if (choice.equalsIgnoreCase("n")) {
                    break;
                }else if(choice.equalsIgnoreCase("y")){
                    continue;
                }
            }
        }

        // calculating the student ranks using the student index
        public static int calculateRank(int index) {
            int rank = 1;
            int totalMarks = CSF_marks[index] + DBMS_marks[index];

            for (int i = 0; i < s_count; i++) {
                if (i != index && (CSF_marks[i] + DBMS_marks[i]) > totalMarks) {
                    rank++;
                }
            }

            return rank;
        }

        // calculating the rank number in text
        public static String getRankText(int rank) {
            switch (rank) {
                case 1:
                    return " (First Rank)";
                case 2:
                    return " (Second Rank)";
                case 3:
                    return " (Third Rank)";
                case 100:
                    return " (Last Rank)";
                default:
                    return "";
            }
        }


        // printing out the student ranks in ascending order
        public static void printStudentRanks() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                           Print Student Ranks                                   ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();


            Scanner input = new Scanner(System.in);


            while(true){

                // initializing three new arrays to store calculated total marks, average marks and ranks
                int[] totalMarks = new int[s_count];
                int[] ranks = new int[s_count];
                double[] avgMarks = new double[s_count];

                // Calculate total marks for each student
                for (int i = 0; i < s_count; i++) {
                    totalMarks[i] = CSF_marks[i] + DBMS_marks[i];
                }
                // Calculate average marks for each student
                for (int i = 0; i < s_count; i++) {
                    avgMarks[i] = totalMarks[i]/2.0;
                }

                // Assign ranks to students based on total marks
                for (int i = 0; i < s_count; i++) {
                    ranks[i] = 1;
                    for (int j = 0; j < s_count; j++) {
                        if (totalMarks[j] > totalMarks[i]) {
                            ranks[i]++;
                        }
                    }
                }

                // Sort ranks and corresponding student details in ascending order
                for (int i = 0; i < s_count - 1; i++) {
                    for (int j = i + 1; j < s_count; j++) {
                        if (ranks[j] < ranks[i]) {
                            // Swap ranks
                            int tempRank = ranks[i];
                            ranks[i] = ranks[j];
                            ranks[j] = tempRank;

                            // Swap totalMarks
                            int tempMarks = totalMarks[i];
                            totalMarks[i] = totalMarks[j];
                            totalMarks[j] = tempMarks;

                            // Swap student_ID
                            String tempID = student_ID[i];
                            student_ID[i] = student_ID[j];
                            student_ID[j] = tempID;

                            // Swap student_name
                            String tempName = student_name[i];
                            student_name[i] = student_name[j];
                            student_name[j] = tempName;

                            // Swap Average Marks
                            double avgmarks = avgMarks[i];
                            avgMarks[i] = avgMarks[j];
                            avgMarks[j] = avgmarks;
                        }
                    }
                }


                // Print student details with ranks in a table
                System.out.println();
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("| Rank\t|Student ID\t|Student Name\t|Total Marks\t|Average Marks|");
                System.out.println("-----------------------------------------------------------------------");

                for (int i = 0; i < s_count; i++) {
                    System.out.println("|" +ranks[i] + "\t|" + student_ID[i] + "\t\t|" + student_name[i] + "\t\t|" + totalMarks[i]+ "\t\t|" + avgMarks[i]+"         |");
                }
                System.out.println("-----------------------------------------------------------------------");

                System.out.println();
                System.out.print("Do you want to go back to the menu or stay here (y/n)? ");
                String answer = input.next();
                if (answer.equalsIgnoreCase("y")) {
                    break ;
                }
            }
        }


        // printing the best results in csf module
        public static void bestInProgrammingFundamentals() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                       Best in Programming Fundamentals                            ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();

            while(true){
                if (s_count == 0) {
                    System.out.println("No students found!");
                    return;
                }

                // Create a new array to store the details of the students so that the previous array won't be harmed
                int[] array = new int[s_count];
                for (int i = 0; i < s_count; i++) {
                    array[i] = i;
                }

                // Sort the marks using Bubble Sort
                for (int i = 0; i < s_count - 1; i++) {
                    for (int j = 0; j < s_count - 1 - i; j++) {
                        if (CSF_marks[array[j]] < CSF_marks[array[j + 1]]) {
                            int temp = array[j];
                            array[j]= array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }

                //printing out the table
                System.out.println("------------------------------------------------------------");
                System.out.println("| Student ID\t|Student Name\t|CSF Marks\t|DBMS Marks|");
                System.out.println("------------------------------------------------------------");
                for (int i = 0; i < s_count; i++) {
                    int index = array[i];
                    System.out.println("|"+student_ID[index] + " \t\t| " + student_name[index] + " \t\t| " + CSF_marks[index] + " \t\t| " + DBMS_marks[index]+"       |");
                }
                System.out.println("------------------------------------------------------------");
                System.out.println();


                Scanner input = new Scanner(System.in);
                System.out.print("Do you want to go back to the menu (y/n)? ");
                String answer = input.next();


                if (answer.equalsIgnoreCase("y")) {
                    break;
                }
            }

        }

        // printing the best results in dbms module
        public static void bestIndbms() {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("                       Best in Database Managment Systems                         ");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println();

            while(true){
                if (s_count == 0) {
                    System.out.println("No students found!");
                    return;
                }

                // Create a new array to store the details of the students so that the previous array won't be harmed
                int[] array = new int[s_count];
                for (int i = 0; i < s_count; i++) {
                    array[i] = i;
                }

                // Sort the marks using Bubble Sort
                for (int i = 0; i < s_count - 1; i++) {
                    for (int j = 0; j < s_count - 1 - i; j++) {
                        if (CSF_marks[array[j]] < CSF_marks[array[j + 1]]) {
                            int temp = array[j];
                            array[j]= array[j + 1];
                            array[j + 1] = temp;
                        }
                    }
                }

                System.out.println("------------------------------------------------------------");
                System.out.println("| Student ID\t|Student Name\t|CSF Marks\t|DBMS Marks|");
                System.out.println("------------------------------------------------------------");
                for (int i = 0; i < s_count; i++) {
                    int index = array[i];
                    System.out.println("|"+student_ID[index] + " \t\t| " + student_name[index] + " \t\t| " + CSF_marks[index] + " \t\t| " + DBMS_marks[index]+"       |");
                }
                System.out.println("------------------------------------------------------------");
                System.out.println();


                Scanner input = new Scanner(System.in);
                System.out.print("Do you want to go back to the menu (y/n)? ");
                String answer = input.next();


                if (answer.equalsIgnoreCase("y")) {
                    break;
                }
            }

        }

    }









