package Sample_Day3_Programs;
	class VolumeCalculator {

	    void volume(int side) {
	        System.out.println("Volume of cube: " + (side * side * side));
	    }

	    
	    void volume(int length, int breadth, int height) {
	        System.out.println("Volume of rectangle: " + (length * breadth * height));
	    }
	}
	public class Method_Overloading {
	public static void main(String[] args) {
		VolumeCalculator V = new VolumeCalculator();
		V.volume(10);
		V.volume(10,20,30);	
	}


	
}



