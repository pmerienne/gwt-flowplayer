package com.google.gwt.flowplayer.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

public abstract class EventDispatcher {

	private HandlerManager handlerManager;

	protected HandlerManager createHandlerManager() {
		return new HandlerManager(this);
	}

	protected HandlerManager ensureHandlers() {
		return handlerManager == null ? handlerManager = createHandlerManager() : handlerManager;
	}

	public <H extends EventHandler> HandlerRegistration addHandler(GwtEvent.Type<H> type, final H handler) {
		return ensureHandlers().addHandler(type, handler);
	}

	public <H extends EventHandler> void removeHandler(GwtEvent.Type<H> type, final H handler) {
		ensureHandlers().removeHandler(type, handler);
	}

	public void fireEvent(GwtEvent<?> event) {
		ensureHandlers().fireEvent(event);
	}
}
