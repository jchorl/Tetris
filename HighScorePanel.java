import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Josh Chorlton
 * Creates a {@link JPanel} displaying the high scores to be displayed with the {@link Settings} JPanel in the {@link Minesweeper} class
 * @see HighScore
 *
 */

public class HighScorePanel extends JPanel{
	public HighScorePanel(){
		super.setLayout(new GridBagLayout());
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.insets= new Insets(10,0,0,0);

		HighScore[] hsdb= HighScore.readFromFile();
		int easyScore= hsdb[0].getScore();
		int medScore= hsdb[1].getScore();
		int hardScore= hsdb[2].getScore();

		String easy= easyScore+"";
		String med= medScore+"";
		String hard= hardScore+"";
		String easyN= hsdb[0].getUserName();
		String medN= hsdb[1].getUserName();
		String hardN= hsdb[2].getUserName();
		JLabel easyLabel= new JLabel("Easy:");
		Font f= easyLabel.getFont();
		easyLabel.setFont(f.deriveFont(f.getStyle()^Font.BOLD));
		JLabel easyNameLabel= new JLabel("Name: "+easyN);
		JLabel easyScoreLabel= new JLabel("Score: "+easy);
		JLabel medLabel= new JLabel("Medium:");
		medLabel.setFont(f.deriveFont(f.getStyle()^Font.BOLD));
		JLabel medNameLabel= new JLabel("Name: "+medN);
		JLabel medScoreLabel= new JLabel("Score: "+med);
		JLabel hardLabel= new JLabel("Hard:");
		hardLabel.setFont(f.deriveFont(f.getStyle()^Font.BOLD));
		JLabel hardNameLabel= new JLabel("Name: "+hardN);
		JLabel hardScoreLabel= new JLabel("Score: "+hard);
		JLabel highScores= new JLabel("High Scores");
		gbc.gridy= 0;
		super.add(highScores, gbc);
		gbc.gridy++;
		super.add(easyLabel, gbc);
		gbc.insets= new Insets(2,0,2,0);
		gbc.gridy++;
		super.add(easyNameLabel, gbc);
		gbc.gridy++;
		super.add(easyScoreLabel, gbc);
		gbc.insets= new Insets(10,0,0,0);
		gbc.gridy++;
		super.add(medLabel, gbc);
		gbc.insets= new Insets(2,0,2,0);
		gbc.gridy++;
		super.add(medNameLabel, gbc);
		gbc.gridy++;
		super.add(medScoreLabel, gbc);
		gbc.insets= new Insets(10,0,0,0);
		gbc.gridy++;
		super.add(hardLabel, gbc);
		gbc.insets= new Insets(2,0,2,0);
		gbc.gridy++;
		super.add(hardNameLabel, gbc);
		gbc.gridy++;
		super.add(hardScoreLabel, gbc);//initiates all labels and adds them
	}
}
