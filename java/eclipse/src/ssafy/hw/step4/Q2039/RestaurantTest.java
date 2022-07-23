package ssafy.hw.step4.Q2039;

public class RestaurantTest {

	public static void main(String[] args) {
		Restaurant R1 = new Restaurant(101, "을밀대", "서울", "냉면", 4);
		Restaurant R2 = new Restaurant(401, "도마29", "대구", "연어초밥", 3);
		
		Review r1 = new Review(1, 101, "김싸피", "너무 맛있네요.");
		Review r2 = new Review(2, 401, "나싸피", "연어초밥은 여기가 최고!");
		
		System.out.println("********************맛집목록********************");
		System.out.println(R1);
		System.out.println(R2);
		System.out.println("********************리뷰목록********************");
		System.out.println(r1);
		System.out.println(r2);
	}

}
