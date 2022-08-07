package ssafy.algorithm.set;

import java.io.*;
import java.util.*;

// 문자열 S 의 서로 다른 부분문자열 개수 (길이 1000 이하)
public class BJ_서로다른부분문자열의개수_11478 {

	static String str;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();

		int l = str.length();
		char[] cl = str.toCharArray();
		Set<String> set = new HashSet<>();

		char[] tmp;
		
		// String 클래스의 subString 메서드...
		// 어차피 중복을 제거할 필요는 없으니 --> set 이 아닌 맵에 넣는 게 인상적이다.
		for (int k = 1; k <= l; k++) {
			for (int i = 0; i+k <= l; i++) {
				tmp = new char[k];
				for (int j = 0; j < k; j++) {
					tmp[j] = cl[i+j];
				}
				set.add(new String(tmp));
			}
		}
		
		
		System.out.println(set.size());
		
	}
}
