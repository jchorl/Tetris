import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameFrame extends JFrame{
	private GamePanel gp;
	private ScorePanel sp;
	private ImageIcon[] images= setImages();
	private int[][] board;
	private Timer t= new Timer();
	private int type;
	private int score= 0;
	private int difficulty= 0;
	private JFrame jf= this;
	private JPanel mainPanel= new JPanel(new GridBagLayout());
	private GameOver go;
	private GridBagConstraints mc= new GridBagConstraints();
	private boolean isPaused= false;
	public GameFrame(final int width, final int height, final int speed, final int d){
		super.setSize(38*width+80, 38*height+40+super.getInsets().top);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		difficulty= d;
		board= new int[width][height+2];
		gp= new GamePanel(board, images);
		mc.anchor= GridBagConstraints.NORTHWEST;
		mc.gridx= 0;
		mc.weightx= 1;
		mc.gridy= 0;
		mainPanel.add(gp, mc);
		mc.weightx= 0;
		mc.gridx= 1;
		sp= new ScorePanel(score);
		mainPanel.add(sp, mc);
		super.add(mainPanel);
		super.setVisible(true);
		gp.revalidate();
		gp.repaint();
		mainPanel.revalidate();
		mainPanel.repaint();
		type= Intel.drawShape(board, GameFrame.this);
		super.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
			}
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_R){
					if(!isPaused){
						t.cancel();
					}
					GameFrame.this.setVisible(false);
					GameFrame g= new GameFrame(width, height, speed, d);
				}
				else if(e.getKeyCode()==KeyEvent.VK_M){
					if(!isPaused){
						t.cancel();
					}
					GameFrame.this.setVisible(false);
					SettingsFrame sf= new SettingsFrame();
				}
				else if(e.getKeyCode()==KeyEvent.VK_Q){
					System.exit(0);
				}
				else if(e.getKeyCode()==KeyEvent.VK_P){
					if(!isPaused){
						isPaused= true;
						t.cancel();
					}
					else if(isPaused){
						isPaused= false;
						t= new Timer();
						t.schedule(new TimerTask(){
							public void run(){
								int counter= 0;
								int[] x= new int[4];
								int[] y= new int[4];
								try{
									for(int i= board[0].length-1; i>=0; i--){
										for(int j= 0; j<board.length; j++){
											if(board[j][i]!=0&&board[j][i]<8){
												x[counter]= j;//x coordinates for active block
												y[counter]= i;//y coordinates for active block
												counter++;
											}
										}
									}
									if(board[x[0]][y[0]-1]>7){//if block 1 cant go down
										throw new Exception();
									}
									else if(board[x[1]][y[1]-1]>7){//if block 2 cant go down
										throw new Exception();
									}
									else if(board[x[2]][y[2]-1]>7){
										throw new Exception();
									}
									else if(board[x[3]][y[3]-1]>7){
										throw new Exception();
									}
									else{
										Intel.move(board, 2);//it can go down, so move it down
										gp.Refresh(board, images);
										jf.repaint();
									}
								}catch(Exception f){//if it cannot go down anymore
									board[x[0]][y[0]]= board[x[0]][y[0]]+8;
									board[x[1]][y[1]]= board[x[1]][y[1]]+8;
									board[x[2]][y[2]]= board[x[2]][y[2]]+8;
									board[x[3]][y[3]]= board[x[3]][y[3]]+8;//adds 8 to all the cells part of the active shape, showing that it is no longer active
									boolean fullLine= true;
									for(int i= board[0].length-2; i>=0; i--){//goes through y values starting at top
										fullLine= true;
										for(int z= 0; z<board.length; z++){//check at board[][i] to see if there is a full line
											if(board[z][i]==0){
												fullLine= false;
												break;
											}
										}
										if(fullLine){//if there is a full line
											for(int g= i; g<board[0].length-1; g++){//starts at the full line and goes up, moving everything down a line
												for(int q= 0; q<board.length; q++){
													board[q][g]= board[q][g+1];
												}
											}
											for(int l= 0; l<board.length; l++){
												board[l][board[0].length-1]= 0;
											}//clears the top row because everything has been moved down
											score++;
											//refresh the score panel
											sp.refresh(score);
											mainPanel.validate();
										}
									}
									type= Intel.drawShape(board, GameFrame.this);
									gp.Refresh(board, images);
									jf.repaint();
								}
							}
						}, 400, 160+(10-speed)*20);
					}
				}
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&!isPaused){
					Intel.move(board, 0);
					gp.Refresh(board, images);
					jf.repaint();
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT&&!isPaused){
					Intel.move(board, 1);
					gp.Refresh(board, images);
					jf.repaint();
				}
				else if(e.getKeyCode()==KeyEvent.VK_DOWN&&!isPaused){
					int counter= 0;
					int[] x= new int[4];
					int[] y= new int[4];
					try{
						for(int i= board[0].length-1; i>=0; i--){
							for(int j= 0; j<board.length; j++){
								if(board[j][i]!=0&&board[j][i]<8){
									x[counter]= j;
									y[counter]= i;
									counter++;
								}
							}
						}
						if(board[x[0]][y[0]-1]>7){
							throw new Exception();
						}
						else if(board[x[1]][y[1]-1]>7){
							throw new Exception();
						}
						else if(board[x[2]][y[2]-1]>7){
							throw new Exception();
						}
						else if(board[x[3]][y[3]-1]>7){
							throw new Exception();
						}
						else{
							Intel.move(board, 2);
							gp.Refresh(board, images);
							jf.repaint();
						}
					}catch(Exception f){
						board[x[0]][y[0]]= board[x[0]][y[0]]+8;
						board[x[1]][y[1]]= board[x[1]][y[1]]+8;
						board[x[2]][y[2]]= board[x[2]][y[2]]+8;
						board[x[3]][y[3]]= board[x[3]][y[3]]+8;//adds 8 to all the cells part of the active shape, showing that it is no longer active
						boolean fullLine= true;
						for(int i= board[0].length-2; i>=0; i--){//goes through y values starting at top
							fullLine= true;
							for(int z= 0; z<board.length; z++){//check at board[][i] to see if there is a full line
								if(board[z][i]==0){
									fullLine= false;
									break;
								}
							}
							if(fullLine){//if there is a full line
								for(int g= i; g<board[0].length-1; g++){//starts at the full line and goes up, moving everything down a line
									for(int q= 0; q<board.length; q++){
										board[q][g]= board[q][g+1];
									}
								}
								for(int l= 0; l<board.length; l++){
									board[l][board[0].length-1]= 0;
								}//clears the top row because everything has been moved down
								score++;
								//refresh the score panel
								sp.refresh(score);
								mainPanel.validate();
							}
						}
						type= Intel.drawShape(board, GameFrame.this);
						gp.Refresh(board, images);
						jf.repaint();
					}
				}
				else if(e.getKeyCode()==KeyEvent.VK_UP&&!isPaused){
					Intel.rotateShapeCW(type, board);
					gp.Refresh(board, images);
					jf.repaint();
				}
			}
			public void keyTyped(KeyEvent e){
			}
		});
		t.schedule(new TimerTask(){
			public void run(){
				int counter= 0;
				int[] x= new int[4];
				int[] y= new int[4];
				try{
					for(int i= board[0].length-1; i>=0; i--){
						for(int j= 0; j<board.length; j++){
							if(board[j][i]!=0&&board[j][i]<8){
								x[counter]= j;//x coordinates for active block
								y[counter]= i;//y coordinates for active block
								counter++;
							}
						}
					}
					if(board[x[0]][y[0]-1]>7){//if block 1 cant go down
						throw new Exception();
					}
					else if(board[x[1]][y[1]-1]>7){//if block 2 cant go down
						throw new Exception();
					}
					else if(board[x[2]][y[2]-1]>7){
						throw new Exception();
					}
					else if(board[x[3]][y[3]-1]>7){
						throw new Exception();
					}
					else{
						Intel.move(board, 2);//it can go down, so move it down
						gp.Refresh(board, images);
						jf.repaint();
					}
				}catch(Exception f){//if it cannot go down anymore
					board[x[0]][y[0]]= board[x[0]][y[0]]+8;
					board[x[1]][y[1]]= board[x[1]][y[1]]+8;
					board[x[2]][y[2]]= board[x[2]][y[2]]+8;
					board[x[3]][y[3]]= board[x[3]][y[3]]+8;//adds 8 to all the cells part of the active shape, showing that it is no longer active
					boolean fullLine= true;
					for(int i= board[0].length-2; i>=0; i--){//goes through y values starting at top
						fullLine= true;
						for(int z= 0; z<board.length; z++){//check at board[][i] to see if there is a full line
							if(board[z][i]==0){
								fullLine= false;
								break;
							}
						}
						if(fullLine){//if there is a full line
							for(int g= i; g<board[0].length-1; g++){//starts at the full line and goes up, moving everything down a line
								for(int q= 0; q<board.length; q++){
									board[q][g]= board[q][g+1];
								}
							}
							for(int l= 0; l<board.length; l++){
								board[l][board[0].length-1]= 0;
							}//clears the top row because everything has been moved down
							score++;
							//refresh the score panel
							sp.refresh(score);
							mainPanel.validate();
						}
					}
					type= Intel.drawShape(board, GameFrame.this);
					gp.Refresh(board, images);
					jf.repaint();
				}
			}
		}, 400, 160+(10-speed)*20);
	}
	public ImageIcon[] setImages(){
		ImageIcon[] images= new ImageIcon[16];
		URL[] url= new URL[16];
		url[0]= getClass().getResource("0.jpg");
		url[1]= getClass().getResource("J.jpg");
		url[2]= getClass().getResource("L.jpg");
		url[3]= getClass().getResource("Line.jpg");
		url[4]= getClass().getResource("S.jpg");
		url[5]= getClass().getResource("Square.jpg");
		url[6]= getClass().getResource("T.jpg");
		url[7]= getClass().getResource("Z.jpg");
		url[8]= getClass().getResource("0.jpg");
		url[9]= getClass().getResource("J.jpg");
		url[10]= getClass().getResource("L.jpg");
		url[11]= getClass().getResource("Line.jpg");
		url[12]= getClass().getResource("S.jpg");
		url[13]= getClass().getResource("Square.jpg");
		url[14]= getClass().getResource("T.jpg");
		url[15]= getClass().getResource("Z.jpg");
		try{
			for(int i= 0; i<16; i++){
				images[i]= new ImageIcon(ImageIO.read(url[i]));
			}
		}catch(Exception e){}
		return images;
	}
	public void endGame(){
		t.cancel();
		gameOverMenu();
	}
	public JFrame getFrame(){
		return GameFrame.this;
	}
	public void gameOverMenu(){
		mainPanel.removeAll();
		HighScore[] hsdb= HighScore.readFromFile();
		if(difficulty!=3){
			if(score>hsdb[difficulty].getScore()||hsdb[difficulty].getScore()==0){//if they set a new highscore
				go= new GameOver(score, difficulty, GameFrame.this);
				mainPanel.add(go, mc);
				mainPanel.repaint();
				GameFrame.this.setSize(380, 220);
				GameFrame.this.validate();
			}
			else{//otherwise, new game
				GameFrame.this.setVisible(false);
				SettingsFrame m= new SettingsFrame();
			}
		}
		else{
			GameFrame.this.setVisible(false);
			SettingsFrame m= new SettingsFrame();
		}
	}
}
