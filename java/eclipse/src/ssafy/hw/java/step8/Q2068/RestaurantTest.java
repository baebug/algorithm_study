package ssafy.hw.step8.Q2068;

public class RestaurantTest {

	public static void main(String[] args) {
		Restaurant R1 = new Restaurant(1, "맥도날드", "금정구", "상하이스파이시치킨버거", 5);
		Restaurant R2 = new Restaurant(2, "피나치공", "금정구", "더블포테이토피자", 5);
		Restaurant R3 = new KoreanRestaurant(3, "토흐", "금정구", "김치돈까스", 5, "02-345-6789", "No");
		Restaurant R4 = new Restaurant(4, "혼돈", "금정구", "오븐돈까스", 1);
		Restaurant R5 = new KoreanRestaurant(5, "부대밀면", "금정구", "갈비탕", 4, "010-0010-0110", "15:00 ~ 17:00");
		
		Review r1 = new Review(1, 1, "baebug", "맛있어요");
		Review r2 = new Review(2, 1, "baebug", "맛있어요");
		Review r3 = new Review(3, 1, "baebug", "맛있어요");
		Review r4 = new Review(4, 1, "baebug", "맛있어요");
		Review r5 = new Review(5, 1, "baebug", "맛있어요");
		Review r6 = new Review(6, 2, "baebug", "맛있어요");
		Review r7 = new Review(7, 2, "baebug", "맛있어요");
		Review r8 = new Review(8, 2, "baebug", "맛있어요");
		Review r9 = new Review(9, 4, "baebug", "맛없어요");
		
		IRestaurantManager Rm = RestaurantManagerImpl.getInstance();
		
		Rm.addRestaurant(R1);
		Rm.addRestaurant(R2);
		Rm.addRestaurant(R3);
		Rm.addRestaurant(R4);
		Rm.addRestaurant(R5);
		
		Rm.getReviewManager(1).addReview(r1);
		Rm.getReviewManager(1).addReview(r2);
		Rm.getReviewManager(1).addReview(r3);
		Rm.getReviewManager(1).addReview(r4);
		Rm.getReviewManager(1).addReview(r5);
		Rm.getReviewManager(2).addReview(r6);
		Rm.getReviewManager(2).addReview(r7);
		Rm.getReviewManager(2).addReview(r8);
		Rm.getReviewManager(4).addReview(r9);
		
		System.out.println("********************전체 맛집 목록********************");
		for (Restaurant R : Rm.getRestaurantList()) {
			System.out.println(R);
		}
		System.out.println("********************한식 맛집 목록********************");
		for (KoreanRestaurant kr : Rm.getKoreanRestaurants()) {
			System.out.println(kr);
		}
		System.out.println("********************일반 맛집 목록********************");
		for (Restaurant nr : Rm.getNonKoreanRestaurants()) {
			System.out.println(nr);
		}
		System.out.println("********************맥도날드 리뷰 목록********************");
		for (Review r : Rm.getReviewManager(1).getReviewList()) {
			System.out.println(r);
		}
		System.out.println("********************피나치공 리뷰 목록********************");
		for (Review r : Rm.getReviewManager(2).getReviewList()) {
			System.out.println(r);
		}
		System.out.println("********************혼돈 리뷰 목록********************");
		for (Review r : Rm.getReviewManager(4).getReviewList()) {
			System.out.println(r);
		}
	}

}
