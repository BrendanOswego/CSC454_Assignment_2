package main;

interface Model {
	void applyStateChange(Store newStore);
	Store getState();
}
