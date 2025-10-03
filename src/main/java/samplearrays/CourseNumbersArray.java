package samplearrays;

public class CourseNumbersArray {

    public static int[] addCourse(int[] lista,int num){
        int[] updatedCourse = new int[lista.length+1];
        for (int i=0; i< lista.length ; i++){
            updatedCourse[i] = lista[i];
        }
        updatedCourse[lista.length] = num;
        return updatedCourse;
    }

    public static void displayInfo(int[] lista){
        System.out.println("the elements : ");
        for (int i=0; i<lista.length; i++){
            System.out.print(lista[i]+" ");
        }
        System.out.println();

    }

    public static void contains(int[] lista, int num){
        for (int i=0; i<lista.length; i++){
            if (lista[i] == num){
                System.out.println("the list does contain "+num);
                return;
            }
        }
        System.out.println("the list does not contain "+num);

    }

    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = addCourse(registeredCourses,12);
        displayInfo(updatedCourses);
        contains(updatedCourses,12);
    }
}