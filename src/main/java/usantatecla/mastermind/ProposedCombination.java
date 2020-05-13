package usantatecla.mastermind;

class ProposedCombination extends Combination {
	
	private static final int ERROR_CODE = -1;

	static Error isValid(int[] codes) {
		if (codes.length != Combination.getWidth()) {
			return Error.WRONG_LENGTH;
		}
		for (int i = 0; i < codes.length; i++) {
			if (codes[i] == -1) {
				return Error.WRONG_CHARACTERS;
			}
			for (int j = i + 1; j < codes.length; j++) {
				if (codes[i] == codes[j]) {
					return Error.DUPLICATED;
				}
			}
		}
		return null;
	}

	static ProposedCombination getInstance(int[] codes) {
		assert ProposedCombination.isValid(codes) != null;
		ProposedCombination proposedCombination = new ProposedCombination();
		for (int code : codes) {
			proposedCombination.colors.add(Color.getInstance(code));
		}
		return proposedCombination;
	}
	
	void write(int[] codes) {
		for (int code : codes) {
			this.console.write(Color.getInstance(code).getInitial());
		}
	}

	int[] read() {
		String characters = this.console.readString(Message.PROPOSED_COMBINATION.getMessage());
		int[] codes = new int[characters.length()];
		for (int i = 0; i < characters.length(); i++) {
			Color color = Color.getInstance(characters.charAt(i));
			if (color == null) {
				codes[i] = ProposedCombination.ERROR_CODE;
			} else {
				codes[i] = color.ordinal();
			}
		}
		return codes;
	}

	int[] getCodes() {
		int[] codes = new int[Combination.getWidth()];
		for (int i = 0; i < codes.length; i++) {
			codes[i] = this.colors.get(i).ordinal();
		}
		return codes;
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}

}
