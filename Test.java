package illumio;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Firewall fw = new Firewall("C:\\Users\\wangzhengzhi\\Documents\\leetcode\\test.csv");
		System.out.println(fw.rules.get(1));
		
		
		System.out.println(fw.accept_packet("inbound", "tcp", 80, "192.168.1.2"));  //True
		System.out.println("=================");
		System.out.println(fw.accept_packet("outbound", "udp", 1555, "52.15.62.99"));  //True
		System.out.println("=================");
		System.out.println(fw.accept_packet("inbound", "udp", 53, "192.168.2.1"));    //True
		System.out.println("=================");
		System.out.println(fw.accept_packet("outbound", "tcp", 10234, "192.168.10.11"));    //True
		System.out.println("=================");
		System.out.println(fw.accept_packet("inbound", "tcp", 81, "192.168.1.2"));  //False
		System.out.println("=================");
		System.out.println(fw.accept_packet("inbound", "udp", 24, "52.12.48.92"));  //False
		System.out.println("=================");
		System.out.println(fw.accept_packet("outbound", "udp", 1555, "52.15.62.101"));  //False
		System.out.println("=================");
		System.out.println(fw.accept_packet("outbound", "udp", 555, "52.15.62.100"));  //False
		System.out.println("=================");
		System.out.println(fw.accept_packet("outbound", "udp", 12, "52.19.62.100"));  //False
		System.out.println("=================");
	}

}
