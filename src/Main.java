import java.util.*;

public class Main {

    public static void main(String[] args) {

        HotelReview App = new HotelReview();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*********************************************");
            System.out.println("\nHotel Ratings and Reviews Platform");
            System.out.println("1. Add User");
            System.out.println("2. Add Hotel");
            System.out.println("3. Add Review and Rating");
            System.out.println("4. Get Hotels Sorted by Rating");
            System.out.println("5. Get details of particular hotel");
            System.out.println("6. Get details of all the hotels registered");
            System.out.println("7. Exit");
            System.out.println("*********************************************");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter the user name: ");
                    String userName = scanner.nextLine();
                    App.addUser(userName);
                    System.out.println("User added successfully!");
                    break;

                case 2:

                    System.out.print("Enter the hotel id: ");
                    int hotelId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the hotel name: ");
                    String hotelName = scanner.nextLine();
                    System.out.print("Enter 'PLUS' if the hotel is plus hotel or any other key: ");
                    String hotelLabel = scanner.nextLine();

                    App.isHotelLabelPlus(hotelLabel, hotelId, hotelName);

                    System.out.println("Hotel added successfully!");
                    break;

                case 3:

                    App.GeneralInformation();

                    System.out.print("Enter the user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter the hotel id: ");
                    hotelId = scanner.nextInt();

                    if (!App.isValidUser(userName) && !App.isValidHotelID(hotelId)) {
                        System.out.println("You have entered Invalid username or hotelID. Please enter a valid username and hotelID");
                        break;
                    }

                    System.out.print("Enter your rating (1-5): ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();

                    if (!App.isValidRating(rating)) {
                        System.out.println("Invalid rating! Please provide a rating between 1 and 5.");
                        break;
                    }

                    System.out.print("Enter your review: ");
                    String review = scanner.nextLine();

                    App.addReview(userName, hotelId, rating, review);

                    break;

                case 4:

                    App.GeneralInformation();
                    break;

                case 5:

                    System.out.print("Enter the hotel ID: ");
                    hotelId = scanner.nextInt();

                    if (!App.isValidHotelID(hotelId)) {
                        System.out.println("The ID you have entered does not exist! Please try again with valid ID");
                        break;
                    }

                    App.HotelDetailsWithID(hotelId);

                    break;

                case 6:

                    for (Map.Entry<Integer, Hotel> entry : App.getHotelDetail().entrySet())
                    {
                        System.out.println("************* Hotel Detail *************");
                        Hotel existingHotelID = entry.getValue();
                        App.HotelDetailsWithID(existingHotelID.getId());
                    }
                    break;

                case 7:

                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}