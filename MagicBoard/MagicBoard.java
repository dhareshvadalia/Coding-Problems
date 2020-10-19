package games.magic_board;

/**
 * @author dharesh.vadalia
 *
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class MagicBoard {
	
	public boolean game_play(int[][] magicboard, int start_point) {
		System.out.format("\nStart point selected is %d, Game Onn...\n", start_point);
		int [] cr = {0,0,0,0}; //{row,col,val,dist}
		int val, c_val;
		int [][] board = Arrays.stream(magicboard).map(int[]::clone).toArray(int[][]::new);
		
		cr = set_start_point(board, start_point, cr);
		Queue<int []> traversal = new LinkedList<int []>();
		traversal.add(cr);
		try {
			while(traversal.peek() != null) {
				cr = traversal.remove();
				val = board[cr[0]][cr[1]];
				board[cr[0]][cr[1]] = -1;
				
				if(val == 0) {
					System.out.format("\n\nDestination cordinates (%d,%d) reached in %d steps",cr[0],cr[1],cr[3]);
					return true;
				}
				
				cr[3] += 1;
				
				if(val >= 0) {
					System.out.format("\nStep %d from %d\n",cr[3], val);
					if(cr[0]-val >= 0) { //move north
						c_val = board[cr[0]-val][cr[1]];
						if(c_val >= 0){
							System.out.format("N(%d,%d),%d | ",cr[0]-val,cr[1],board[cr[0]-val][cr[1]]);
							int [] temp = {cr[0]-val,cr[1],c_val,cr[3]};
							traversal.add(temp);
						}
					}
					if(cr[1]-val >= 0) {//move west
						c_val = board[cr[0]][cr[1]-val];
						if(c_val >= 0) {
							System.out.format("W(%d,%d),%d | ",cr[0],cr[1]-val,board[cr[0]][cr[1]-val]);
							int [] temp = {cr[0],cr[1]-val,c_val,cr[3]};
							traversal.add(temp);
						}
					}
					if(cr[0]+val < board.length) { //move south
						c_val = board[cr[0]+val][cr[1]];
						if(c_val >= 0) {
							System.out.format("S(%d,%d),%d | ",cr[0]+val,cr[1], board[cr[0]+val][cr[1]]);
							int [] temp = {cr[0]+val,cr[1],c_val,cr[3]};
							traversal.add(temp);
						}
					}
					if(cr[1]+val < board.length) { //move east					
						c_val = board[cr[0]][cr[1]+val];
						if(c_val >= 0) {
							System.out.format("E(%d,%d),%d | ",cr[0],cr[1]+val,board[cr[0]][cr[1]+val]);
							int [] temp = {cr[0],cr[1]+val,c_val,cr[3]};
							traversal.add(temp);
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int [] set_start_point(int[][] board, int start_point, int [] cordinates) {
		
		if(start_point == 1) {
			cordinates[0] = 0; //Top-Left
			cordinates[1] = 0;
		}else if(start_point == 2) {
			cordinates[0] = 0; //Top-Right
			cordinates[1] = board.length - 1;
		}else if(start_point == 3) {
			cordinates[0] = board.length - 1; //Bottom-Left
			cordinates[1] = 0;
		}else {
			cordinates[0] = board.length - 1; //Bottom-Right
			cordinates[1] = board.length - 1;
		}
		return cordinates;
	}

	public int[][] board_maker(int d) {
		Random ran = new Random();
		int[][] board = new int[d][d];
		int i, goal_pos, fill_counter = 0;
		goal_pos = ran.nextInt(d*d); 
		for(i = 0; i<board.length; i++) {
			for(int j = 0; j<board.length; j++) {
				fill_counter ++; 
				if (fill_counter == goal_pos) {
					board[i][j] = 0;
				}else {
					board[i][j] = ran.nextInt(d-1)+1;
				}
			}
		}
		return board;
	}
	
	public boolean val_input(int d) {
		if(d<5 || d>20)
			return false;
		return true;
	}
	
	
	public static void main(String... str) {
		try {
			MagicBoard mgb = new MagicBoard();
			Scanner sc = new Scanner(System.in);
			int[][] board;
			System.out.println("Enter size of magic board: ");
			int board_size = sc.nextInt();
			
			if (mgb.val_input(board_size)) {
				
				board = mgb.board_maker(board_size);
				//System.out.println(Arrays.deepToString(board));
				Stream.of(board).map(Arrays::toString).forEach(System.out::println);
				
				System.out.println("\nSelect start point\n1: Left-Top corner\n2: Right-Top corner\n3: Left-Bottom corner\n4: Right-Bottom corner");
				int start_point = sc.nextInt();
				
				if(start_point < 1 || start_point > 4) {
					System.out.println("\nInvalid start point selected");
					System.exit(1);
				}
				
				//Game starts from here
				while(start_point != 0) {
					if(!mgb.game_play(board, start_point)) 
						System.out.format("\nThis configration for magic board of size %dx%d has no solution", board_size, board_size);
					
					System.out.println("\n\nTo try from another start point enter your choice.\n1: Left-Top corner\n2: Right-Top corner\n3: Left-Bottom corner\n4: Right-Bottom corner\nTo exit enter 0.");
					start_point = sc.nextInt();
				}
				System.out.println("\n\n!!!Game terminated!!!");
			}else { 
				System.out.println("Invalid inupt parameters.\nAcceptable input range (5-20)");
			}
			sc.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
