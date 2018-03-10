public class Main {
    public static void main(String[] args) {
        AccountRepo accountRepo = new AccountRepoImpl(FIleHelper.readAccountsFromFile(FIleHelper.getDefaultPath()));
        double av = accountRepo.getAverageBalance();
        System.out.println(av);
    }
}
