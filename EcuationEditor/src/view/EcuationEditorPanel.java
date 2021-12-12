package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import controller.ControllerListener;

public class EcuationEditorPanel extends JPanel{
	private static final long serialVersionUID = 4263451680791940980L;
	private JButton binomiumButton;
	private JButton fractionButton;
	private JButton trinomiumButton;
	private Binomium binomiumPanel;
	private Trinomium trinomiumPanel;
	private Fraction fractionPanel;
	private IntervalPanel intervalPanel;
	private JPanel buttonPanel;
	private JPanel ecuationPanel;
	private JPanel ecuationEditorPanel;
	private ControllerListener controllerListener;
	private GridBagConstraints gridBagConstraints;
	private CardLayout cardLayout;
	private BufferedImage image;
	  
	public EcuationEditorPanel(ControllerListener controllerListener) {
		init(controllerListener);
		initFrame();
	}

	private void initFrame() {
		setLayout(new GridLayout(1,2));
		setVisible(true);
	}

	private void init(ControllerListener controllerListener) {
		this.controllerListener = controllerListener;
		this.cardLayout = new CardLayout();
		this.gridBagConstraints = new GridBagConstraints();
		initButtonPanel();
		initEcuationEditorPanel();
	}

	private void initButtonPanel() {
		this.buttonPanel = new JPanel();
		buttonPanel.setBorder(new TitledBorder("Ecuaciones disponibles"));
		buttonPanel.setBackground(Color.WHITE);
//		buttonPanel.setLayout(new GridLayout(3,1));
		buttonPanel.setLayout(new GridBagLayout());
		initFractionButton();
		initBinomiumButton();
		initTrinomiumButton();
		add(buttonPanel);
	}

	private void initEcuationEditorPanel() {
		this.ecuationEditorPanel = new JPanel();
		ecuationEditorPanel.setLayout(new GridLayout(2,1));
		initEcuationPanel();
		initIntervalPlane();
		add(ecuationEditorPanel);
	}
	
	private void initEcuationPanel() {
		ecuationPanel = new JPanel();
		ecuationPanel.setBorder(new TitledBorder("Panel de creacion"));
		ecuationPanel.setBackground(Color.WHITE);
		ecuationPanel.setLayout(cardLayout);
		initFractionPanel();
		initBinomiumPanel();
		initTriomiumPanel();
		ecuationEditorPanel.add(ecuationPanel);
	}
	
	
	private void initImage(String address){
		try {
			image = ImageIO.read(getClass().getResourceAsStream(address));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initIntervalPlane() {
		this.intervalPanel = new IntervalPanel(controllerListener);
		this.ecuationEditorPanel.add(intervalPanel);
	}
	
	private void initBinomiumButton() {
		gridBagConstraints.gridy = 1;
		initImage("/Resources/EcuationButtons/1.png");
		binomiumButton = new JButton(new ImageIcon(image));
		binomiumButton.setBackground(Color.WHITE);
		binomiumButton.addActionListener(controllerListener);
		binomiumButton.setActionCommand("BINOMIUM_BUTTON");
		buttonPanel.add(binomiumButton, gridBagConstraints);
	}

	private void initTrinomiumButton() {
		gridBagConstraints.gridy = 2;
		initImage("/Resources/EcuationButtons/3.png");
		trinomiumButton = new JButton(new ImageIcon(image));
		trinomiumButton.setBackground(Color.WHITE);
		trinomiumButton.addActionListener(controllerListener);
		trinomiumButton.setActionCommand("TRINOMIUM_BUTTON");
		buttonPanel.add(trinomiumButton, gridBagConstraints);
	}

	private void initFractionButton() {
		gridBagConstraints.gridy = 0;
		initImage("/Resources/EcuationButtons/2.png");
		fractionButton = new JButton(new ImageIcon(image));
		fractionButton.setBackground(Color.WHITE);
		fractionButton.addActionListener(controllerListener);
		fractionButton.setActionCommand("FRACTION_BUTTON");
		buttonPanel.add(fractionButton, gridBagConstraints);
	}

	public void initBinomiumPanel() {
		this.binomiumPanel = new Binomium(controllerListener);;
		ecuationPanel.add(binomiumPanel, "binomium");
	}
		   
	public void initTriomiumPanel() {
		this.trinomiumPanel = new Trinomium(controllerListener);;
		ecuationPanel.add(trinomiumPanel, "trinomium");
	}

	public void initFractionPanel() {
		this.fractionPanel = new Fraction(controllerListener);
		ecuationPanel.add(fractionPanel, "fraction");
	}

	public Binomium getBinomiumPanel() {
		return binomiumPanel;
	}

	public Trinomium getTrinomiumPanel() {
		return trinomiumPanel;
	}

	public Fraction getFractionPanel() {
		return fractionPanel;
	}

	public JPanel getEcuationPanel() {
		return ecuationPanel;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
	public IntervalPanel getIntervalPanel() {
		return this.intervalPanel;
	}
}
