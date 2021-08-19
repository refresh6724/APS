public class Solution_Level_1_신규아이디추천 { // 제출일 2021-05-09 23:58

	// test
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm")); // "bat.y.abcdefghi"
		System.out.println(solution("z-+.^.")); // "z--"
		System.out.println(solution("=.=")); // "aaa"
		System.out.println(solution("123_.def")); // "123_.def"
		System.out.println(solution("abcdefghijklmn.p")); // "abcdefghijklmn"
	}

	public static String solution(String new_id) {		
		return new CheckID(new_id)
				.toLowerCase()
				.removeRestrictWord()
				.replaceMultipleDotsIntoSingleDot()
				.removeFirstAndLastDot()
				.checkEmtpy()
				.shorten()
				.lengthen()
				.getID();
	}

	static class CheckID {
		private String id;

		public CheckID() {}

		public CheckID(String id) {
			this.id = id;
		}

		public CheckID toLowerCase() {
			this.id = this.id.toLowerCase();
			return this;
		}

		public CheckID removeRestrictWord() {
			this.id = this.id.replaceAll("[^_a-z0-9.-]", "");
			return this;
		}

		public CheckID replaceMultipleDotsIntoSingleDot() {
			this.id = this.id.replaceAll("[.]{2,}", ".");
			return this;
		}

		public CheckID removeFirstAndLastDot() {
			this.id = this.id.replaceAll("[.]$|^[.]", "");
			return this;
		}

		public CheckID checkEmtpy() {
			if (this.id.isEmpty()) {this.id = "a";}
			return this;
		}

		public CheckID shorten() {
			this.id = this.id.substring(0, Math.min(15, this.id.length()))
					.replaceAll("[.]$", "");
			return this;
		}

		public CheckID lengthen() {
			if(this.id.length() == 1) {
				this.id = this.id + this.id + this.id;
			} else if(this.id.length() == 2) {
				this.id = this.id.concat(this.id.substring(1));
			}
			return this;
		}

		public String getID() {
			return this.id;
		}

	}

}
