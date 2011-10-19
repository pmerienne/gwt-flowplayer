package com.google.gwt.flowplayer.client.wrapper;

import com.google.gwt.flowplayer.client.event.EventDispatcher;

public class Flow extends EventDispatcher {

	private static final String SWF_URL = "http://releases.flowplayer.org/swf/flowplayer-3.2.5.swf";

	public Flow() {
		if (!isWrapperLoaded()) {
			throw new IllegalStateException("JavaScript library not loaded");
		}
	}

	public native Player createPlayer(String id)
	/*-{
		return $wnd.$f(id,
				@com.google.gwt.flowplayer.client.wrapper.Flow::SWF_URL, {
					clip : {
						autoPlay : false,
						autoBuffering : true
					}
				});
	}-*/;

	public native Player createPlayer(String id, String sourceUrl)
	/*-{
		return $wnd.$f(id,
				@com.google.gwt.flowplayer.client.wrapper.Flow::SWF_URL, {
					clip : {
						url : sourceUrl,
						autoPlay : false,
						autoBuffering : true,

						onStart : function() {
							// TODO dispatch event
						},
						onSeek : function(clip) {
							// TODO dispatch event
						},
						onCuepoint : function(clip, cuepoint) {
							// TODO dispatch event
						}
					},

					// invoked when the player loads (not a clip specific event)
					onLoad : function() {
						// TODO dispatch event
					},

					// when volume level is altered
					onVolume : function(level) {
						// TODO dispatch event
					},

					// when playback is finished
					onFinish : function() {
						// TODO dispatch event
					}
				});
	}-*/;

	public native Player getPlayer()
	/*-{
		return $wnd.$f();
	}-*/;

	public native Player getPlayer(String id)
	/*-{
		return $wnd.$f(id);
	}-*/;

	private native boolean isWrapperLoaded()
	/*-{
		return typeof ($wnd.$f) == 'function';
	}-*/;
}
