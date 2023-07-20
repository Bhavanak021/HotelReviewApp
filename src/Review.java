class Review {
    private String userId;
    private double rating;
    private String review;

    public Review(String userId, double rating, String review) {
        this.userId = userId;
        this.rating = rating;
        this.review = review;
    }

    public String getUserId() {
        return userId;
    }

    public double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}