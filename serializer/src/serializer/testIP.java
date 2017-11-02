package serializer;

public class testIP {

	public static void main(String[] args) {
		
		String ip = "127.00.010.001";
	
        System.out.println(removeIpv4LeadingZero(ip));
	}
	
	private static String removeIpv4LeadingZero(String ip) {
		String[] list = ip.split("\\.");
		String goodip = "";
		for (String item : list) {
			Integer newitem = Integer.parseInt(item);
			goodip = goodip.concat(newitem.toString().concat("."));
		}
		return goodip.substring(0, goodip.length() - 1);
	}

}
