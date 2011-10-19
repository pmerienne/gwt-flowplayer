package com.google.gwt.flowplayer.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.flowplayer.client.wrapper.Player;

public class PlayerLoadEvent extends GwtEvent<PlayerLoadHandler> {

	private static Type<PlayerLoadHandler> TYPE;

	public static Type<PlayerLoadHandler> getType() {
		return TYPE != null ? TYPE : (TYPE = new Type<PlayerLoadHandler>());
	}

	private Player player;

	public PlayerLoadEvent(Player player) {
		this.player = player;
	}

	@Override
	protected void dispatch(PlayerLoadHandler handler) {
		handler.onPlayerLoad(this);
	}

	@Override
	public GwtEvent.Type<PlayerLoadHandler> getAssociatedType() {
		return getType();
	}

	public Player getPlayer() {
		return player;
	}

}
