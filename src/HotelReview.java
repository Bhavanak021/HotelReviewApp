import java.util.*;

class HotelReview {
    private static final int RATING_STREAK_LEVEL_1 = 1;
    private static final int RATING_STREAK_LEVEL_2 = 4;
    private static final int RATING_STREAK_LEVEL_3 = 8;
    private static final int RATING_STREAK_LEVEL_4 = 16;
    private Map<Integer, Hotel> hotelsList;
    private Map<String, Integer> userLevel;

    public HotelReview() {
        hotelsList = new HashMap<>();
        userLevel = new HashMap<>();
    }

    public void addUser(String userName) {
        userLevel.put(userName, RATING_STREAK_LEVEL_1);
    }

    public void addHotel(int id, String name, Label hotelLabel) {
        if (!hotelsList.containsKey(id)) {
            hotelsList.put(id, new Hotel(id, name, hotelLabel));
        }
    }

//    public Map<Integer, Hotel> getHotelList() {
//        return hotelsList;
//    }

//    public Map<String, Integer> getUserList() {
//        return userLevel;
//    }

    public void displayReview(int Level) {
        System.out.println("Congratulations! You have reached on Level " + Level);
    }

    public void addReview(String userName, int hotelId, double rating, String review) {
        int userRatingStreak = userLevel.get(userName);
        Hotel hotel = hotelsList.get(hotelId);

        if (hotel != null)
        {
            hotel.addReview(userName, rating, review);
            if (userRatingStreak == RATING_STREAK_LEVEL_2) {
                displayReview(2);
            } else if (userRatingStreak == RATING_STREAK_LEVEL_3) {
                displayReview(3);
            } else if (userRatingStreak == RATING_STREAK_LEVEL_4) {
                displayReview(4);
            }

            userRatingStreak++;
            userLevel.put(userName, userRatingStreak);

            System.out.println("Rating and review added successfully");

        } else {
            System.out.println("Hotel not found!");
        }
    }

    public Map<Integer, Hotel> getHotelDetail() {
        return hotelsList;
    }

    public List<Hotel> getHotelsSortedByRating()
    {
        List<Hotel> hotelList = new ArrayList<>(hotelsList.values());

        Collections.sort (hotelList, (Hotel1, Hotel2) -> {
            int res = Hotel2.getHotelLabel().priority - Hotel1.getHotelLabel().priority;
            if (res != 0)
                return res;
            if (Hotel2.getAverageRating() > Hotel1.getAverageRating()) return 1;
            return -1;
        });
        return hotelList;
    }

    public boolean isValidRating(double rating) {
        return rating >= 1 && rating <= 5;
    }

    public boolean isValidUser(String userName) {
        return userLevel.containsKey(userName);
    }

    public boolean isValidHotelID(Integer hotelId) {
        return hotelsList.containsKey(hotelId);
    }

    public String FormatString(Double number) {
        return String.format("%.1f", number);
    }

    public void isHotelLabelPlus(String hotelLabel, int hotelId, String hotelName)
    {
        if (Label.PLUS.name().equals(hotelLabel)) {
            addHotel(hotelId, hotelName, Label.PLUS);
        } else {
            addHotel(hotelId, hotelName, Label.NORMAL);
        }
    }

    public void PrintHotelDetails(Hotel existingHotel) {
        System.out.println("Hotel ID: " + existingHotel.getId());
        System.out.println("Hotel Name: " + existingHotel.getName());
        System.out.println("Hotel Current Total Rating: " + existingHotel.getTotalRating());
        System.out.println("Hotel Average rating: " + FormatString(existingHotel.getAverageRating()));
        System.out.println("Hotel Reviews: ");
        List<Review> firstReview = existingHotel.getReviews();
        for (Review value : firstReview) {
            System.out.println(value.getReview());
        }
    }

    public void HotelDetailsWithID(Integer hotelId) {
        if (hotelsList.containsKey(hotelId)) {
            PrintHotelDetails(hotelsList.get(hotelId));
        }
    }

    public void GeneralInformation() {
        getHotelsSortedByRating()
                .forEach(hotel ->
                        System.out.println("Hotel: " + hotel.getName() + ", Average Rating: " + FormatString(hotel.getAverageRating()))
                );
    }
}