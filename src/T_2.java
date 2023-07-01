import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;


// 2)* Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

public class T_2 {
    public static void main(String[] args) throws IOException {
        int[] array = {92, 71, 54, 32, 41, 922, 77};
        Logger logger = Logger.getLogger(T_2.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        SimpleFormatter Format = new SimpleFormatter();
        fh.setFormatter(Format);
        logger.addHandler(fh);
        boolean Sorted = false;
        int temp;
        while(!Sorted) {
            Sorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    Sorted = false;

                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
                logger.info(Arrays.toString(array));
            }
        }
        System.out.println(Arrays.toString(array));
    }
}