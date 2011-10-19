package com.google.gwt.flowplayer.client.wrapper;

public enum State {
	UNLOADED(-1), LOADED(0), UNSTARTED(1), BUFFERING(2), PLAYING(3), PAUSED(4), ENDED(5);

	public static State valueOf(int state) {
		for (State value : values()) {
			if (value.getValue() == state) {
				return value;
			}
		}
		throw new IllegalArgumentException("Unknow state " + state);
	}

	private int value;

	private State(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
