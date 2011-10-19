package ##PACKAGE##;

import com.google.gwt.event.shared.GwtEvent;

public class ##Event##Event extends GwtEvent<##Event##Handler>{

	private static Type<##Event##Handler> TYPE;

	public static Type<##Event##Handler> getType() {
		return TYPE != null ? TYPE : (TYPE = new Type<##Event##Handler>());
	}

	public ##Event##Event(){

	}

	@Override
	protected void dispatch(##Event##Handler handler) {
		handler.on##Event##(this);
	}

	@Override
	public GwtEvent.Type<##Event##Handler> getAssociatedType() {
		return getType();
	}

}
