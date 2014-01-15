import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import javax.naming.InvalidNameException;

/**
 * A HighScore object including name, time, and difficulty
 * @author Josh Chorlton
 *
 */

public class HighScore{
	private String un;
	private int s;
	public int d;

	/**
	 * 
	 * @param userName the user's name
	 * @param score the user's time
	 * @param difficulty the difficulty level
	 * @throws Exception if the name or score are impossible values
	 */

	public HighScore(String userName, int score, int difficulty) throws Exception{
		setUserName(userName);
		setScore(score);
		setDifficulty(difficulty);
	}

	/**
	 * Sets the user name
	 * @param userName the user's name
	 * @throws Exception if the name is not valid
	 */

	public void setUserName(String userName) throws Exception{
		for(char a:userName.toCharArray()){
			if(!(((int)a>96&&(int)a<123)||((int)a>64&&(int)a<91)||(int)a==45||(int)a==32)){
				throw new InvalidNameException();
			}
		}
		un= userName;
	}

	/**
	 * Sets the score
	 * @param score the user's time
	 * @throws Exception if the score is not valid
	 */

	public void setScore(int score) throws Exception{
		s= score;
	}

	/**
	 * Sets the difficulty
	 * @param difficulty the user's difficulty
	 */

	public void setDifficulty(int difficulty){
		d= difficulty;
	}

	/**
	 * Returns the user's name
	 * @return the user's name
	 */

	public String getUserName(){
		return un;
	}

	/**
	 * Returns the user's score
	 * @return the user's score
	 */

	public int getScore(){
		return s;
	}

	/**
	 * Returns the record's difficulty
	 * @return the record's difficulty
	 */

	public int getDifficulty(){
		return d;
	}

	/**
	 * Reads 3 high score objects from a file, one from each difficulty, and returns them in an array
	 * @return the high scores for each difficulty in a HighScore[]
	 */

	public static HighScore[] readFromFile(){
		HighScore[] hsdb= new HighScore[3];
		try{
			RandomAccessFile raf= new RandomAccessFile("Records2.txt", "rw");
			if(raf.length()==0){
				for(int i= 0; i<3; i++){
					hsdb[i]= new HighScore("-", 0, i);
				}
			}
			else{
				int seek= 0;
				for(int i= 0; i<3; i++){
					raf.seek(seek);
					String name= "";
					char a= raf.readChar();
					char[] ints= {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
					while(Arrays.binarySearch(ints, a)<0){
						name= name+a;
						raf.seek(seek+name.length()*2);
						a= raf.readChar();
					}
					seek= seek+name.length()*2;
					raf.seek(seek);
					String scoreS= "";
					while(!(Arrays.binarySearch(ints, a)<0)){
						scoreS= scoreS+a;
						if(seek+scoreS.length()*2<raf.length()){
							raf.seek(seek+scoreS.length()*2);
							a= raf.readChar();
						}
						else{
							break;
						}
					}
					int score= 0;
					if(scoreS.equals("-")){
						score= 0;
					}
					else{
						score= Integer.parseInt(scoreS);
					}
					seek= seek+(scoreS.length()*2);
					hsdb[i]= new HighScore(name, score, i);
				}
				raf.close();
			}
		}catch(Exception e){};
		return hsdb;
	}

	/**
	 * Adds a new high score and writes it to file
	 * @param h the new high score to write to file
	 */

	public static void newRecord(HighScore h){
		HighScore[] hsdb= readFromFile();
		try{
			hsdb[h.getDifficulty()]= new HighScore(h.getUserName(), h.getScore(), h.getDifficulty());
			RandomAccessFile raf= new RandomAccessFile("Records2.txt", "rw");
			raf.setLength(0);
			for(int i= 0; i<3; i++){
				raf.writeChars(hsdb[i].getUserName()+hsdb[i].getScore());
			}
			raf.close();
		}catch(Exception e){}
	}
}
