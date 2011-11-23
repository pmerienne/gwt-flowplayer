package com.google.gwt.flowplayer.client;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.flowplayer.client.wrapper.Flow;
import com.google.gwt.flowplayer.client.wrapper.Player;
import com.google.gwt.flowplayer.client.wrapper.State;
import com.google.gwt.user.client.ui.Widget;

public class FlowPlayer extends Widget {

	private static final String ID_PREFIX = "$_$gwt-flowplayer$_$";

	private static final Flow FLOW_PLAYER = new Flow();

	private static int count = 0;

	private String id;
	private Player player;

	private String source;

	private boolean autoplay = false;

	public FlowPlayer() {
		this.id = generateUIID();
		DivElement element = Document.get().createDivElement();
		element.setId(this.id);
		element.setInnerHTML("&nbsp;");
		Document.get().getBody().appendChild(element);
		this.player = FLOW_PLAYER.createPlayer(this.id);
		element.removeFromParent();
		setElement(element);
	}

	public FlowPlayer(String url) {
		this.id = generateUIID();
		this.source = url;
		DivElement element = Document.get().createDivElement();
		element.setId(id);
		element.setInnerHTML("&nbsp;");
		Document.get().getBody().appendChild(element);
		this.player = FLOW_PLAYER.createPlayer(this.id, this.source);
		element.removeFromParent();
		setElement(element);
	}

	private String generateUIID() {
		return ID_PREFIX + (count++);
	}

	public void play() {
		if (this.source != null) {
			this.player.play(this.source);
		}
	}

	public void play(String url) {
		this.source = url;
		if (this.player.isLoaded()) {
			this.player.play(this.source);
		}
	}

	public void pause() {
		this.player.pause();
	}

	public void stop() {
		this.player.stop();
	}

	public void hide() {
		this.player.hide();
	}
	
	public void show() {
		this.player.show();
	}
	
	public void seek(int seconds) {
		this.player.seek(seconds);
	}
	
	public State getState() {
		return this.player.getState();
	}
	
	public void setSource(String url) {
		this.source = url;
		if (this.player != null) {
			this.player.close();
			this.player.unload();
			this.player = null;
		}
		if (this.getElement().getParentElement() == null) {
			Document.get().getBody().appendChild(this.getElement());
			this.player = FLOW_PLAYER.createPlayer(this.id, this.source);
			Document.get().getBody().removeChild(this.getElement());
		} else {
			this.player = FLOW_PLAYER.createPlayer(this.id, this.source);
		}
	}

	public boolean isAutoplay() {
		return autoplay;
	}

	public void setAutoplay(boolean autoplay) {
		this.autoplay = autoplay;
	}

	public void release() {
		this.stop();
		this.close();
		this.unload();
		this.getElement().removeFromParent();
	}

	public void close() {
		this.player.close();
	}

	public void unload() {
		this.player.unload();
	}
}
