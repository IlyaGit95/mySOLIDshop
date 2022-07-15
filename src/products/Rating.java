package products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rating {
    List<Integer> usersResponse = new ArrayList<>();
    String resultRating;
    private boolean isUsing = false;

    public Rating() {
    }

    public Rating(Integer[] rating) {
        this.usersResponse = new ArrayList<>(Arrays.asList(rating));
        calculateResultRating();
    }

    public void addUsersResponse(Integer newUsersResponse) {
        if (isUsing) {
            System.out.println("Вы уже оставляли свой отзыв по данному товару!");
            return;
        }
        usersResponse.add(newUsersResponse);
        calculateResultRating();
        isUsing = true;
    }

    public void calculateResultRating() {
        int sum = 0;
        for (int rating : usersResponse) {
            sum += rating;
        }
        this.resultRating = String.format("%.1f", ((double) sum / usersResponse.size()));
    }

    public String getResultRating() {
        return resultRating;
    }
}
