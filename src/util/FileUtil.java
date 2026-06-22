package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void saveExpense(
            String data) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(
                                    "expenses.txt",
                                    true
                            )
                    );

            writer.write(data);

            writer.newLine();

            writer.close();

        }
        catch (IOException e) {

            System.out.println(
                    "Error Saving File"
            );
        }
    }
}