package com.google.gwt.flowplayer.client.wrapper;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

class NativeHelper {
	public native static void callMethod(JavaScriptObject object, String name)
	/*-{
		object[name].apply(object, []);
	}-*/;

	public static JsArrayString fromArray(String... values) {
		JsArrayString result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < values.length; ++i) {
			result.set(i, values[i]);
		}
		return result;
	}
}
