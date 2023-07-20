import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private Label hotelLabel;
    private int CurrentTotalRating = 0;
    private double SumOfTotalRating = 0;
    private List<Review> reviews = new ArrayList<>();

    public Hotel(int id, String name, Label hotelLabel) {
        this.id = id;
        this.name = name;
        this.hotelLabel = hotelLabel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Label getHotelLabel() {
        return hotelLabel;
    }

    public double getAverageRating() {
        if (reviews.size() == 0) {
            return 0;
        }
        return SumOfTotalRating / reviews.size();
    }

    public void addReview(String userId, double rating, String review) {
        for (Review existingReview : reviews) {
            if (existingReview.getUserId().equals(userId)) {
                CurrentTotalRating -= existingReview.getRating();
                reviews.remove(review);
                break;
            }
        }

        Review newReview = new Review(userId, rating, review);
        SumOfTotalRating += rating;
        CurrentTotalRating += rating;
        reviews.add(newReview);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public int getTotalRating() {
        return CurrentTotalRating;
    }
}

