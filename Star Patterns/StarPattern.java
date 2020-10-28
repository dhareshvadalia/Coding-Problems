package patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dharesh
 *
 */
public class StarPattern {
	
	int choice,i,j,k;
	static int n;
	
	public void patternExecution() {
		switch(choice) 
		{
			case 1:{
				starBasicTrianglePattern();
				break;
			}
			case 2:{
				starInvertedTrianglePattern();
				break;
			}
			case 3:{
				starBasicTriangleMirrorPattern();
				break;
			}
			case 4:{
				starInvertedTriangleMirrorPattern();
				break;
			}
			case 5:{
				starPyramidPattern();
				break;
			}
			case 6:{
				starTreePattern();
				break;
			}
			default :{
				System.out.println("Invalid choice");
				System.exit(0);
			}
		}
	}
	
	public void patternSelect() throws NumberFormatException, IOException {
		System.out.print("Select Choice Of Pattern To Execute\n");
		System.out.println("1. Star Basic Trinangle Pattern\n"
						 + "2. Star Inverted Triangle Pattern\n"
						 + "3. Star Mirriored Triangle Pattern\n"
						 + "4. Star Inverted Mirrored Triangle Pattern\n"
						 + "5. Star Pyramid Pattern\n"
						 + "6. Star Tree Pattern\n\n"
						 + "000. Exit");
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		choice = Integer.parseInt(input.readLine());
		System.out.print("Enter Pattern Size: ");
		n = Integer.parseInt(input.readLine()); 
	}

	public void starBasicTrianglePattern() {
		int i,j;
		System.out.println("Star Basic Trinangle Pattern\n");
		for (i=0; i<n; i++){
			for(j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void starInvertedTrianglePattern() {
		
		System.out.println("\nStar Inverted Triangle Pattern");
		for (i=0; i<n; i++){
			for(j=0;j<((n-1)-i);j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void starBasicTriangleMirrorPattern() {
		int i,j;
		System.out.println("\nStar Basic Triangle Mirror Pattern");
		for (i=0; i<n; i++){
			for(j=0;j<((n-1)-i);j++) {
				System.out.print(" ");
			}
			for(k=0;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public void starInvertedTriangleMirrorPattern() {
		int i,j;
		System.out.println("\nStar Inverted Mirrored Triangle Pattern");
		for (i=0; i<n; i++){
			for(j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(k=0;k<(n-i);k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void starPyramidPattern() {
		int i,j;
		System.out.println("\nStar Pyramid Pattern");
		for (i=0; i<n; i++){
			for(j=0;j<((n-1)-i);j++) {
				System.out.print(" ");
			}
			for(k=0;k<=i;k++) {
				System.out.print("*");
			}
			for(k=0;k<i;k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void starTreePattern() {
		int i,j;
		System.out.println("\nStar Tree Pattern");
		for (i=0; i<n; i++){
			for(j=0;j<((n-1)-i);j++) {
				System.out.print(" ");
			}
			for(k=0;k<=i;k++) {
				System.out.print("*");
			}
			for(k=0;k<i;k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for(i=0; i<4; i++) {
			for(j=0;j<=(n/2)+1;j++) {
				System.out.print(" ");
			}
			for(j=0;j<(n/3)+1;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	
	public static void main(String... args) throws NumberFormatException, IOException {
		StarPattern ptn = new StarPattern();
		ptn.patternSelect();
		if(n < 20) {
			ptn.patternExecution();
		}else {
		System.out.println("Please Enter size value less then 20");
		}
	}
}
