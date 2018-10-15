package com.imcs.jdbc.entity;

public enum State {
	AK("Alaska"), AL("Alabama"), AR("Arkansas"), AZ("Arizona"), CA("California"), CO("Colorado"), CT("Connecticut"),
	DE("Delaware"), FL("Florida"), GA("Georgia"), HI("Hawaii"), IA("Iowa"), ID("Idaho"), IL("Illinois"), IN("Indiana"),
	KS("Kansas"), KY("Kentucky"), LA("Louisiana"), MA("Massachusetts"), MD("Maryland"), ME("Maine"), MI("Michigan"),
	MN("Minnesota"), MO("Missouri"), MS("Mississippi"), MT("Montana"), NC("NorthCarolina"), ND("NorthDakota"),
	NE("Nebraska"), NH("NewHampshire"), NJ("NewJersey"), NM("NewMexico"), NV("Nevada"), NY("NewYork"), OH("Ohio"),
	OK("Oklahoma"), OR("Oregon"), PA("Pennsylvania"), RI("RhodeIsland"), SC("SouthCarolina"), SD("SouthDakota"),
	TN("Tennessee"), TX("Texas"), UT("Utah"), VA("Virginia"), VT("Vermont"), WA("Washington"), WI("Wisconsin"),
	WV("WestVirginia"), WY("Wyoming");
	private String stateName;

	private State(String stateName) {
		this.stateName = stateName;
	}

	public String getStateName() {
		return this.stateName;
	}

	public static State getState(String stateName) {
		for (State state : State.values()) {
			if (state.getStateName().equalsIgnoreCase(stateName)) {
				return state;
			}
		}

		return null;
	}
}
