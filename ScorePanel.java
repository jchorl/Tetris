import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ScorePanel extends JPanel{
	private JLabel label;
	public ScorePanel(final int lines){
		Runnable createScorePanel= new Runnable(){
			public void run(){
				label= new JLabel("Score: "+lines);
				ScorePanel.this.add(label);
			}
		};
		SwingUtilities.invokeLater(createScorePanel);
	}
	public void refresh(final int score){
		Runnable refreshScorePanel= new Runnable(){
			public void run(){
				ScorePanel.this.remove(label);
				label= new JLabel("Score: "+score);
				ScorePanel.this.add(label);
				ScorePanel.this.validate();
			}
		};
		SwingUtilities.invokeLater(refreshScorePanel);
	}
}
