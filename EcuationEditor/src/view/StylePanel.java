package view;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import controller.ControllerListener;

public class StylePanel extends JPanel{
	private static final long serialVersionUID = -3149095094743476480L;
	private JButton lineStyle;
	private JButton linesAndPointsStyle;
	private JButton pointStyle;
	private JButton squareStyle;
	private BufferedImage image;
	private ControllerListener controllerListener;
	
	public StylePanel(ControllerListener controllerListener) {
		init(controllerListener);
	}
	
	private void init(ControllerListener controllerListener) {
		this.controllerListener = controllerListener;
		initPanel();
		initButtons();
	}
	
	private void initPanel() {
		setLayout(new GridLayout(2,2));
		setBackground(Color.WHITE);
	}
	
	private void initButtons() {
		initButton(lineStyle, "/resources/styles/line.png", "LINE");
		initButton(linesAndPointsStyle, "/resources/styles/linesAndPoints.png", "LINE_AND_POINT");
		initButton(pointStyle, "/resources/styles/points.png", "POINTS");
		initButton(squareStyle, "/resources/styles/squares.png", "SQUARES");
	}
	
	private void initButton(JButton button, String address, String actionCommand) {
		initImage(address);
		button = new JButton(new ImageIcon(this.image));
		button.setBackground(Color.WHITE);
		button.setActionCommand(actionCommand);
		button.addActionListener(controllerListener);
		add(button);
	}
	
	private void initImage(String address){
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream(address));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
