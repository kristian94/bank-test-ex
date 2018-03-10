import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FIleHelper {

    public static Path getDefaultPath(){
        String filePath = new File("").getAbsolutePath();
        Path p = Paths.get(filePath + "/data.txt");
        return p;
    }

    public static ArrayList<Account> readAccountsFromFile(Path path) {
        ArrayList<Account> accounts = new ArrayList();
        try {
            Files.lines(path).forEach((String line) -> {
                String[] cells = line.split(",");
                String name = cells[0];
                int balance = Integer.parseInt(cells[1]);
                String bank = cells[2];
                Account account = new Account(name, balance, bank);
                accounts.add(account);
            });
        } catch (IOException e) {
            System.out.println(e.toString());
        }finally{
            return accounts;
        }


    }
}
