package usantatecla.mastermind;

import java.util.Random;
import java.util.Collections;

class SecretCombination extends Combination {

	SecretCombination() {
		super();
		for(Color color: Color.values()) {
			this.colors.add(color);
		}
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < Color.length() - Combination.getWidth(); i++) {
			this.colors.remove(random.nextInt(this.colors.size()));
		}
		Collections.shuffle(this.colors);
	}

	Result getResult(ProposedCombination proposedCombination) {
		int blacks = 0;
		for (int i = 0; i < this.colors.size(); i++) {
			if (proposedCombination.contains(this.colors.get(i), i)) {
				blacks++;
			}
		}
		int whites = 0;
		for (Color color : this.colors) {
			if (proposedCombination.contains(color)) {
				whites++;
			}
		}
		return new Result(blacks, whites - blacks);
	}

	void writeln() {
		for (int i = 0; i < Combination.getWidth(); i++) {
			Message.SECRET.write();
		}
		this.console.writeln();
	}

	void shuffleArray(Color[] array) {
		Random random = new Random(System.currentTimeMillis());
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			Color color = array[index];
			array[index] = array[i];
			array[i] = color;
		}
	}

}
