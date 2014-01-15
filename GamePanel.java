import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GamePanel extends JPanel{

	public GamePanel(final int[][] board, final ImageIcon[] images){
		Runnable createGamePanel= new Runnable(){
			public void run(){
				GamePanel.this.setLayout(new GridBagLayout());
				GamePanel.this.setBackground(Color.gray);
				GridBagConstraints gbc= new GridBagConstraints();
				gbc.anchor= GridBagConstraints.NORTHWEST;
				for(int i= 0; i<board[0].length-2; i++){
					for(int j= 0; j<board.length; j++){
						gbc.gridy= board[0].length-i;
						gbc.gridx= j;
						GamePanel.this.add(new JLabel(images[board[j][i]]), gbc);
					}
				}
			}
		};
		SwingUtilities.invokeLater(createGamePanel);
	}
	public void Refresh(final int[][] board, final ImageIcon[] images){
		Runnable refreshGamePanel= new Runnable(){
			public void run(){
				GamePanel.this.removeAll();
				GridBagConstraints gbc= new GridBagConstraints();
				gbc.anchor= GridBagConstraints.NORTHWEST;
				for(int i= 0; i<board[0].length-2; i++){
					for(int j= 0; j<board.length; j++){
						gbc.gridy= board[0].length-i;
						gbc.gridx= j;
						GamePanel.this.add(new JLabel(images[board[j][i]]), gbc);
					}
				}
				GamePanel.this.revalidate();
			}
		};
		SwingUtilities.invokeLater(refreshGamePanel);
	}
}
