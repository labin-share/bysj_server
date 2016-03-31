package common;

public class LngLatAssistant {
	
	public static double calculateDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double EARTH_RADIUS = 6378.137;
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double radLng1 = rad(lng1);
		double radLng2 = rad(lng2);
		double radLat1RadLat2 = radLat1 - radLat2;
		double radLng1RadLng2 = radLng1 - radLng2;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(
				Math.sin(radLat1RadLat2 / 2), 2)
				+ Math.cos(radLat1)
				* Math.cos(radLat2)
				* Math.pow(Math.sin(radLng1RadLng2 / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

}
