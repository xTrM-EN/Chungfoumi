package me.xtrm.rockpapiersizo.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import me.xtrm.rockpapiersizo.RPSLogic;
import me.xtrm.rockpapiersizo.data.Messages;
import me.xtrm.rockpapiersizo.data.RPSChoice;
import me.xtrm.rockpapiersizo.data.RPSResult;

@SuppressWarnings("serial")
class RPSPanel extends JPanel {

	private final BufferedImage background;
	private final Font textFont;
	JLabel text;

	RPSPanel() throws IOException {
		this.background = ImageIO.read(getClass().getResourceAsStream("/assets/chungus.png")); //$NON-NLS-1$
		this.textFont = new JLabel().getFont().deriveFont(12F);

		this.setLayout(null);

		this.text = new JLabel(Messages.getString("rps.chungus.text.0")); //$NON-NLS-1$
		this.text.setBounds(200, 95, 300, 50);
		this.text.setFont(this.textFont);
		this.text.setForeground(Color.white);
		this.add(this.text);

		IntStream.range(0, RPSChoice.values().length).forEach(i -> {
			JButton button = new JButton(RPSChoice.values()[i].getName());
			button.setBounds(290, 190 + (50 * i), 180, 35);
			button.addActionListener(e -> {
				RPSResult result = RPSLogic.INSTANCE.checkChoice(i);
				RPSLogic.INSTANCE.score(result);

				int[] scores = RPSLogic.INSTANCE.getScores();
				this.text.setText(
						String.format(Messages.getString("rps.chungus.text.1"),  //$NON-NLS-1$
								RPSLogic.INSTANCE.getLastChoice(),
								result.getName(), 
								scores[0], scores[1]));

				// then reset
				RPSLogic.INSTANCE.performChoice();
			});

			this.add(button);
		});
	}

	@Override
	protected void paintComponent(Graphics graphics2d) {
		super.paintComponent(graphics2d);
		graphics2d.drawImage(this.background, 0, 0, 500, 500, this);
	}
}
