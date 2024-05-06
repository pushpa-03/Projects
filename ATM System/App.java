public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome... To ATM System");

        Location location = new Location("India", 91, "Karnakata", "Banahatti", "XXX", "ttt");
        CurrencyComposition composition = new CurrencyComposition(5, 5, 10, 1, 3);
        ATM atm = new ATM("12345", location, composition);
        User user = new User("SSS", 123, "8293", 984, 5000, 5, 10);
        machineFeatures mFeatures = new machineFeatures();
        mFeatures.checkUserBalance(user);

        mFeatures.createATM(location, composition);
        mFeatures.seeComposition(composition);

        // checking working of all function
        // composition = new CurrencyComposition(500, 200, 50, 50, 1000);
        // mFeatures.updateATMComposition(atm, composition);
        // mFeatures.seeComposition(composition);
        // location = new Location("RRR", 81, "aaa", "uuu", "www", "yyy");
        // mFeatures.updateATMLocation(atm,location);
        // mFeatures.seeLocation(location);

        mFeatures.withdraw(5000, user, atm);

    }
}
