import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsPanel extends JPanel{
	private JSlider widthSlider= new JSlider(8, 15, 10);
	private JSlider heightSlider= new JSlider(15, 24, 18);
	private JSlider speedSlider= new JSlider(1, 10, 8);
	private JRadioButton easyButton= new JRadioButton("Easy", false);
	private JRadioButton moderateButton= new JRadioButton("Moderate", false);
	private JRadioButton hardButton= new JRadioButton("Difficult", true);
	private JRadioButton customButton= new JRadioButton("Custom", false);
	private int height;
	private int width;
	private int speed;
	private int difficulty;

	public SettingsPanel(){
		super.setLayout(new GridBagLayout());
		JPanel settingsPanel= new JPanel(new GridBagLayout());
		GridBagConstraints sc= new GridBagConstraints();
		JPanel radioPanel= new JPanel(new GridBagLayout());
		ButtonGroup bg= new ButtonGroup();
		bg.add(easyButton);
		bg.add(moderateButton);
		bg.add(hardButton);
		bg.add(customButton);
		GridBagConstraints rc= new GridBagConstraints();
		rc.gridx= 0;
		radioPanel.add(easyButton, rc);
		rc.gridx++;
		radioPanel.add(moderateButton, rc);
		rc.gridx++;
		difficulty= 2;
		radioPanel.add(hardButton, rc);
		rc.gridx++;
		radioPanel.add(customButton, rc);
		//^^just put the buttons all in a row

		JLabel widthLabel= new JLabel("Width");
		sc.gridy= 0;
		sc.insets= new Insets(30,20,0,0);
		sc.anchor= GridBagConstraints.SOUTH;
		settingsPanel.add(widthLabel, sc);
		widthSlider.setMajorTickSpacing(2);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		widthSlider.setSnapToTicks(true);
		sc.insets= new Insets(0,0,0,0);
		sc.anchor= GridBagConstraints.NORTH;
		sc.gridwidth= 1;
		sc.gridx= 0;
		sc.gridy= 1;
		settingsPanel.add(widthSlider, sc);
		heightSlider.setMajorTickSpacing(3);
		heightSlider.setMinorTickSpacing(1);
		heightSlider.setOrientation(JSlider.VERTICAL);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);
		heightSlider.setSnapToTicks(true);
		sc.gridwidth= 1;
		sc.gridx= 1;
		sc.gridy= 1;
		sc.gridheight= 3;
		settingsPanel.add(heightSlider, sc);
		JLabel heightLabel= new JLabel("Height");
		sc.insets= new Insets(30,0,0,0);
		sc.gridheight= 1;
		sc.gridy= 0;
		sc.gridx= 1;
		settingsPanel.add(heightLabel, sc);
		//width and height sliders done

		JLabel speedLabel= new JLabel("Speed");
		sc.gridy= 1;
		sc.gridx= 0;
		sc.insets= new Insets(100,20,0,0);
		sc.anchor= GridBagConstraints.NORTH;
		settingsPanel.add(speedLabel, sc);
		speedSlider.setMajorTickSpacing(2);
		speedSlider.setMinorTickSpacing(1);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setSnapToTicks(true);
		sc.insets= new Insets(0,0,0,0);
		sc.anchor= GridBagConstraints.NORTH;
		sc.gridwidth= 1;
		sc.gridx= 0;
		sc.gridy= 2;
		settingsPanel.add(speedSlider, sc);
		//speed slider done
		width= widthSlider.getValue();
		height= heightSlider.getValue();
		speed= speedSlider.getValue();
		easyButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				width= 15;
				height= 24;
				speed= 1;
				widthSlider.setValue(15);
				heightSlider.setValue(24);
				speedSlider.setValue(1);
				easyButton.setSelected(true);
				difficulty= 0;
			}
		}); //if clicked on easy button
		moderateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				width= 12;
				height= 21;
				speed= 6;
				widthSlider.setValue(12);
				heightSlider.setValue(21);
				speedSlider.setValue(6);
				moderateButton.setSelected(true);
				difficulty= 1;
			}
		}); //if clicked on moderate button
		hardButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				width= 10;
				height= 18;
				speed= 8;
				widthSlider.setValue(10);
				heightSlider.setValue(18);
				speedSlider.setValue(8);
				hardButton.setSelected(true);
				difficulty= 2;
			}
		}); //if clicked on hard button
		widthSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent c){
				width= widthSlider.getValue();
				customButton.setSelected(true);
				difficulty= 3;
				if(widthSlider.getValue()==15 && heightSlider.getValue()==24 && speedSlider.getValue()==1){
					easyButton.setSelected(true);
					difficulty= 0;
				}
				else if (widthSlider.getValue()==12 && heightSlider.getValue()==21 && speedSlider.getValue()==6){
					moderateButton.setSelected(true);
					difficulty= 1;
				}
				else if(widthSlider.getValue()==10 && heightSlider.getValue()==18 && speedSlider.getValue()==8){
					hardButton.setSelected(true);
					difficulty= 2;
				}
			}
		});//if moved width slider
		heightSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent c){
				customButton.setSelected(true);
				height= heightSlider.getValue();
				difficulty= 3;
				if(widthSlider.getValue()==15 && heightSlider.getValue()==24 && speedSlider.getValue()==1){
					easyButton.setSelected(true);
					difficulty= 0;
				}
				else if (widthSlider.getValue()==12 && heightSlider.getValue()==21 && speedSlider.getValue()==6){
					moderateButton.setSelected(true);
					difficulty= 1;
				}
				else if(widthSlider.getValue()==10 && heightSlider.getValue()==18 && speedSlider.getValue()==8){
					hardButton.setSelected(true);
					difficulty= 2;
				}
			}
		});//if moved height slider
		speedSlider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent c){
				customButton.setSelected(true);
				speed= speedSlider.getValue();
				difficulty= 3;
				if(widthSlider.getValue()==15 && heightSlider.getValue()==24 && speedSlider.getValue()==1){
					easyButton.setSelected(true);
					difficulty= 0;
				}
				else if (widthSlider.getValue()==12 && heightSlider.getValue()==21 && speedSlider.getValue()==6){
					moderateButton.setSelected(true);
					difficulty= 1;
				}
				else if(widthSlider.getValue()==10 && heightSlider.getValue()==18 && speedSlider.getValue()==8){
					hardButton.setSelected(true);
					difficulty= 2;
				}
			}
		});//if moved speed slider
		GridBagConstraints mc= new GridBagConstraints();
		mc.anchor= GridBagConstraints.NORTH;
		mc.gridy= 0;
		super.add(radioPanel, mc);
		mc.gridy= 1;
		super.add(settingsPanel, mc);
	}

	public int getWidthSquares(){
		setWidthSquares(widthSlider.getValue());
		return width;
	}

	public void setWidthSquares(int i){
		width= i;
	}

	public int getHeightSquares(){
		setHeightSquares(heightSlider.getValue());
		return height;
	}

	public void setHeightSquares(int i){
		height= i;
	}

	public int getSpeed(){
		setSpeed(speedSlider.getValue());
		return speed;
	}

	public void setSpeed(int i){
		speed= i;
	}

	public int getDifficulty(){
		return difficulty;
	}
}
