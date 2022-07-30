package ssafy.hw.step10.Q2083;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReviewManagerImpl implements IReviewManager {
	private List<Review> reviews = new ArrayList<>();
	
	public ReviewManagerImpl() {
		this.loadData();
	}
	
	@Override
	public void addReview(Review review) {
		reviews.add(review);
	}

	@Override
	public void removeReview(int reviewId) {
		reviews.removeIf(r -> r.getReviewId() == reviewId);
	}

	@Override
	public List<Review> getReviewList() {
		return reviews;
	}

	@Override
	public Review searchByreviewId(int reviewId) throws ReviewNotFoundException {
		for (Review r : reviews) {
			if (r.getReviewId() == reviewId) {
				return r;
			}
		}

		throw new ReviewNotFoundException(reviewId);
	}

	@Override
	public List<Review> getRestaurantReview(int resId) {
		List<Review> tmpList = new ArrayList<>();
		
		for (Review r : reviews) {
			if (r.getResId() == resId) {
				tmpList.add(r);
			}
		}
		
		return tmpList;
	}
	
	public void loadData() {
		File file = new File("data/reviews.dat");
		
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				reviews = (List<Review>) ois.readObject();
			} catch (Exception e) {
				System.out.println("파일 불러오기 실패");
				e.printStackTrace();
			}
			
		}
	}
	
	public void saveData() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/reviews.dat"))) {
			oos.writeObject(reviews);
		} catch (Exception e) {
			System.out.println("파일 저장 실패");
			e.printStackTrace();
		}
	}
	

}
