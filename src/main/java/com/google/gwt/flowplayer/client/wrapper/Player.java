package com.google.gwt.flowplayer.client.wrapper;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.dom.client.Element;

public class Player extends JavaScriptObject {
	protected Player() {
		// Required for JavaScriptObject
	}

	/**
	 * TODO missing addClip(configuration, index);
	 * 
	 * @param url
	 * @param index
	 * @return
	 */
	public final native Clip addClip(String url, int index)
	/*-{
		return this.addClip(url, index);
	}-*/;

	public final native Player close()
	/*-{
		return this.close();
	}-*/;

	public final native Clip getClip()
	/*-{
		return this.getClip();
	}-*/;

	public final native Clip getClip(int index)
	/*-{
		return this.getClip(index);
	}-*/;

	public final native Clip getCommonClip()
	/*-{
		return this.getCommonClip();
	}-*/;

	public final native Plugin getControls()
	/*-{
		return getControls();
	}-*/;

	public final native int getIndex()
	/*-{
		return this.getIndex();
	}-*/;

	public final native Element getParent()
	/*-{
		return this.getParent();
	}-*/;

	public final Clip[] getPlaylist() {
		JsArray<Clip> clips = getPlaylistNative();
		Clip[] result = new Clip[clips.length()];
		for (int i = 0; i < clips.length(); ++i) {
			result[i] = clips.get(i);
		}
		return result;
	}

	// TODO setPlaylist();
	// TODO getConfig(copy);
	// TODO getFlashParams();
	// TODO load()
	// TODO loadPlugin*
	// TODO play(clip, instream);
	// TODO play(configuration)
	// TODO play([...]);

	private final native JsArray<Clip> getPlaylistNative()
	/*-{
		return this.getPlaylist();
	}-*/;

	public final native Plugin getPlugin(String name)
	/*-{
		return this.getPlugin(name);
	}-*/;

	public final native Plugin getScreen()
	/*-{
		return this.getScreen();
	}-*/;

	public final State getState() {
		return State.valueOf(this.getStateAsInt());
	}

	public final native int getStateAsInt()
	/*-{
		return this.getState();
	}-*/;

	public final native Status getStatus()
	/*-{
		return this.getStatus();
	}-*/;

	public final native double getTime()
	/*-{
		return this.getTime();
	}-*/;

	public final native JsArrayMixed getVersion()
	/*-{
		return this.getVersion();
	}-*/;

	public final native int getVolume()
	/*-{
		return this.getVolume();
	}-*/;

	public final native Player hide()
	/*-{
		return this.hide();
	}-*/;

	public final native String id()
	/*-{
		return this.id();
	}-*/;

	public final native boolean isFullscreen()
	/*-{
		return this.isFullscreen();
	}-*/;

	public final native boolean isHiden()
	/*-{
		return this.isHidden();
	}-*/;

	public final native boolean isLoaded()
	/*-{
		return this.isLoaded();
	}-*/;

	public final native boolean isPaused()
	/*-{
		return this.isPaused();
	}-*/;

	public final native boolean isPlaying()
	/*-{
		return this.isPlaying();
	}-*/;

	public final native Player mute()
	/*-{
		return this.mute();
	}-*/;

	public final native Player pause()
	/*-{
		return this.pause();
	}-*/;

	public final native Player play()
	/*-{
		return this.play();
	}-*/;

	public final native Player play(int index)
	/*-{
		return this.play(index);
	}-*/;

	public final native Player play(String url)
	/*-{
		return this.play(url);
	}-*/;

	public final native Player reset()
	/*-{
		return this.reset();
	}-*/;

	public final native Player reset(String... pluginNames)
	/*-{
		var names = @com.google.gwt.flowplayer.client.wrapper.NativeHelper::fromArray([Ljava/lang/String;)(pluginNames);
		return this.reset(names);
	}-*/;

	public final native Player resume()
	/*-{
		return this.resume();
	}-*/;

	public final native Player seek(int seconds)
	/*-{
		return this.seek(seconds);
	}-*/;

	/**
	 * TODO setClip(configuration);
	 * 
	 * @param url
	 * @return
	 */
	public final native Player setClip(String url)
	/*-{
		return this.setClip(url);
	}-*/;

	public final native Player setVolume(int value)
	/*-{
		return this.setVolume(value);
	}-*/;

	public final native Player show()
	/*-{
		return this.show();
	}-*/;

	public final native Player startBuffering()
	/*-{
		return this.startBuffering();
	}-*/;

	public final native Player stop()
	/*-{
		return this.stop();
	}-*/;

	public final native Player stopBuffering()
	/*-{
		return this.stopBuffering();
	}-*/;

	public final native boolean toggle()
	/*-{
		return this.play();
	}-*/;

	public final native boolean toggleFullscreen()
	/*-{
		return this.toggleFullscreen();
	}-*/;

	public final native Player unload()
	/*-{
		return this.unload();
	}-*/;

	public final native Player unmute()
	/*-{
		return this.unmute();
	}-*/;
}
