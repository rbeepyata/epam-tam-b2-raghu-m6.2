package com.tam.builder.flights.businessobject;

public class FlightSchedule {

	private String fromCountry;
	private String fromAirport;
	private String toCountry;
	private String toAirport;
	

	public static class Builder {
		private String fromCountry;
		private String fromAirport;
		private String toCountry;
		private String toAirport;

		public Builder() {
		}

		public FlightSchedule build() {
			return new FlightSchedule(this);
		}

		public Builder fromCountry(String fromCountry) {
			this.fromCountry = fromCountry;
			return this;
		}

		public Builder fromAirport(String fromAirport) {
			this.fromAirport = fromAirport;
			return this;
		}

		public Builder toCountry(String toCountry) {
			this.toCountry = toCountry;
			return this;
		}

		public Builder toAirport(String ToAirport) {
			this.toAirport = ToAirport;
			return this;
		}
	}

	private FlightSchedule(Builder builder) {
		this.fromCountry = builder.fromCountry;
		this.fromAirport = builder.fromAirport;
		this.toCountry = builder.toCountry;
		this.toAirport = builder.toAirport;
	}

	public String getFromCountry() {
		return fromCountry;
	}

	public String getFromAirport() {
		return fromAirport;
	}

	public String getToCountry() {
		return toCountry;
	}
	public String getToAirport() {
		return toAirport;
	}
}
