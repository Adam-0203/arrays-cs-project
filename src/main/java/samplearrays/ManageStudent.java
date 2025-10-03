// package samplearrays;
package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        int max_index = 0;
        for (int i=0; i<students.length ; i++){
            if (students[i].getAge() > students[max_index].getAge()){
                max_index = i;
            }
        }
        return students[max_index];
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int res = 0;
        for (int i=0; i<students.length; i++){
            if (students[i].isAdult()){
                res++;
            }
        }
        return res;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        int sum = 0;
        for (int i=0; i<students.length; i++){
            sum += students[i].getGrade();
        }
        return (double) (sum/students.length);
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (int i=0; i<students.length ; i++){
            if (students[i].getName() == name){
                return students[i];
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, new Comparator<Student>(){
            @Override
            public int compare(Student a, Student b){
                return Integer.compare(b.getGrade(),a.getGrade());
            }

        });
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (int i=0; i<students.length ; i++){
            if (students[i].getGrade() >= 15){
                System.out.println(students[i].getName() + " ");
            }
        }
        System.out.println("\n");
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (int i=0; i<students.length ; i++){
            if (students[i].getId() == id){
                students[i].setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i=0; i<students.length; i++){
            for (int j=i+1; j<students.length; j++){
                if (students[i].getName() == students[j].getName()){
                    System.out.println("Duplicates found");
                    return true;
                }
            }
        }
        System.out.println("No Duplicates found");
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudentList = new Student[students.length+1];
        for (int i=0; i<students.length ; i++){
            newStudentList[i] = students[i];
        }
        newStudentList[students.length] = newStudent;
        return newStudentList;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students.
        Student student1 = new Student(1,"Hamid",18,12);
        Student student2 = new Student(2,"Adam",17,17);
        Student student3 = new Student(3,"Karim",18,14);
        Student student4 = new Student(4,"Zouhair",18, 15);
        Student student5 = new Student(5,"Hakim",17,20);
        Student student6 = new Student(6,"Zakariae",20,15);

        Student[] arr= {student1,student2,student3,student4,student5};
        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest

        System.out.println(findOldest(arr));
        // 3) Count adults
        System.out.println(countAdults(arr));

        // 4) Average grade

        System.out.println(averageGrade(arr));
        // 5) Find by name

        System.out.println(findStudentByName(arr, "Adam"));
        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        sortByGradeDesc(arr);
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        updateGrade(arr, 4, 20);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println(hasDuplicateNames(arr));

        // 10) Append new student
        arr = appendStudent(arr, student6);
        for (Student s : arr) System.out.println(s);



        Student[][] school = {{student1,student2,student3},{student4,student5,student6}};

        for (int i=0; i<school.length; i++){
            System.out.println("The classroom "+(i+1)+": ");
            for (int j=0; j<school[i].length; j++){
                System.out.println(school[i][j]);
            }
            System.out.println();
        }


        for (int i=0; i<school.length; i++){
            int max_index = 0;
            for (int j = 0; j<school[i].length; j++){
                if (school[i][j].getGrade() > school[i][max_index].getGrade()){
                    max_index = j;
                }
            }
            System.out.println("The Top student for the class "+i+": "+school[i][max_index].getName());
        }

    }
}

