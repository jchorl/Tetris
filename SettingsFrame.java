import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsFrame extends JFrame{
	private JPanel mainPanel= new JPanel(new GridBagLayout());
	private SettingsPanel s= new SettingsPanel();
	private HighScorePanel h= new HighScorePanel();
	private GridBagConstraints mc= new GridBagConstraints();
	public SettingsFrame(){
		super.setSize(460, 500);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel headerPanel= new JPanel(new GridBagLayout());
		ImageIcon header= new ImageIcon();
		try{
			URL url= getClass().getResource("Header.jpg");
			header= new ImageIcon(ImageIO.read(url)); // it says "TETRIS"
		}catch(Exception e){}
		GridBagConstraints hc= new GridBagConstraints();
		hc.anchor= GridBagConstraints.NORTH;
		headerPanel.add(new JLabel(header), hc);
		mc.gridy= 0;
		mc.gridwidth= 3;
		mc.anchor= GridBagConstraints.NORTH;
		mainPanel.add(headerPanel, mc);//header panel set up and added
		mc.gridy= 1;
		mc.gridwidth= 2;
		mc.gridx= 0;
		mainPanel.add(s, mc);//adds settings panel
		mc.gridx= 2;
		mc.gridwidth=1;
		mc.insets= new Insets(40,0,0,0);
		mainPanel.add(h, mc);//adds high score panel
		JButton start= new JButton("Start");
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				SettingsFrame.this.setVisible(false);
				GameFrame gf= new GameFrame(s.getWidthSquares(), s.getHeightSquares(), s.getSpeed(), s.getDifficulty());
			}
		});//start button listeners are added
		mc.weighty++;
		mc.gridy++;
		mc.gridx= 1;
		mc.gridwidth= 1;
		mc.insets= new Insets(0,0,0,100);
		mainPanel.add(start, mc);//adds start button
		JButton quit= new JButton("Quit");
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		mc.insets= new Insets(0,0,0,25);
		mc.gridx= 0;
		mainPanel.add(quit, mc);//adds quit button
		JButton reset= new JButton("Reset High Scores");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					HighScore.newRecord(new HighScore("-", 0, 0));
					HighScore.newRecord(new HighScore("-", 0, 1));
					HighScore.newRecord(new HighScore("-", 0, 2));//writes blank highscores to file
				}catch(Exception f){}
				mainPanel.remove(h);
				h= new HighScorePanel();
				GridBagConstraints mc1= new GridBagConstraints();
				mc1.gridwidth= 1;
				mc1.gridy= 1;
				mc1.gridx= 2;
				mc1.insets= new Insets(40,0,0,0);//new constraints mirroring those from before so it looks the same
				mainPanel.add(h, mc1);
				mainPanel.repaint();
				SettingsFrame.this.validate();
			}
		});
		mc.gridx= mc.gridx+1;
		mc.gridwidth= 2;
		mc.insets= new Insets(0,200,0,0);
		mainPanel.add(reset, mc);
		JPanel directionsPanel= new JPanel(new GridBagLayout());
		JLabel during= new JLabel("During Gameplay:");
		JLabel arrows= new JLabel("Left and Right arrows: move the active shape");
		JLabel rotate= new JLabel("Up arrow: Rotate active shape");
		JLabel pause= new JLabel("P: Pause");
		JLabel restart= new JLabel("R: Restart");
		JLabel menu= new JLabel("M: Menu");
		JLabel quitLabel= new JLabel("Q: Quit");
		GridBagConstraints lc= new GridBagConstraints();
		lc.gridx= 0;
		lc.gridy= 0;
		lc.anchor= GridBagConstraints.NORTHWEST;
		lc.gridwidth= 2;
		directionsPanel.add(during, lc);
		lc.insets= new Insets(8,0,0,0);
		lc.gridy++;
		directionsPanel.add(arrows, lc);
		lc.gridy++;
		directionsPanel.add(rotate, lc);
		lc.gridy++;
		lc.gridwidth= 1;
		lc.insets= new Insets(8,0,0,0);
		directionsPanel.add(pause, lc);
		lc.gridx++;
		lc.insets= new Insets(8,50,0,0);
		directionsPanel.add(restart, lc);
		lc.gridx= 0;
		lc.insets= new Insets(8,0,0,0);
		lc.gridy++;
		directionsPanel.add(menu, lc);
		lc.gridx++;
		lc.insets= new Insets(8,50,0,0);
		directionsPanel.add(quitLabel, lc);
		mc.gridy= 3;
		mc.gridx= 0;
		mc.insets= new Insets(0,0,0,0);
		mc.gridwidth= 3;
		mainPanel.add(directionsPanel, mc);
		SettingsFrame.this.add(mainPanel);//add main panel to frame
		SettingsFrame.this.setVisible(true);
	}
	public static void main(String[] args){
		SettingsFrame mf= new SettingsFrame();
	}
}
