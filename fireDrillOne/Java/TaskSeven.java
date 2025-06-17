// TaskSeven.java

public class TaskSeven {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                int multipleResult = i;
                for (int j = 0; j < 5; j++) {
                    multipleResult = multipleResult * i;
                		int result = multipleResult + multipleResult;
                     System.out.print(result + " ");
                     
                }
                System.out.println();
            }
        }
    }
}

