package Sample_Day9_Programs;

	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;

	class Collection_Comparable implements Comparable<Collection_Comparable> {
		private String name;
		private int age;

		public Collection_Comparable(String n, int a) {
			this.name = n;
			this.age = a;
		}

		@Override
		public int compareTo(Collection_Comparable other) {
			return this.age - other.age; 
		}

		@Override
		public String toString() {
			return name + " age is " + age;
		}
	}
		public class Comparable_Program{
		public static void main(String[] args) {
			List<Collection_Comparable> a = Arrays.asList(
				new Collection_Comparable("Person 1", 24),
				new Collection_Comparable("Person 2", 60)
			);
			
			Collections.sort(a);
			for (Collection_Comparable people : a) {
			System.out.println(people); 
		}

}
}

