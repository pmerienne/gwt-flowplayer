package com.google.gwt.flowplayer.client.wrapper;

import com.google.gwt.core.client.JavaScriptObject;

public class Status extends JavaScriptObject {

	protected Status() {
		// Required for JavaScriptObject
	}

	public final native int getBufferEnd() /*-{
		return this.bufferEnd;
	}-*/;

	public final native int getBufferStart() /*-{
		return this.bufferStart;
	}-*/;

	public final native int getState() /*-{
		return this.state;
	}-*/;

	public final native int gettime() /*-{
		return this.time;
	}-*/;

	public final native int getVolume()
	/*-{
		return this.volume;
	}-*/;

	public final native boolean isMuted()
	/*-{
		return this.muted;
	}-*/;
}
