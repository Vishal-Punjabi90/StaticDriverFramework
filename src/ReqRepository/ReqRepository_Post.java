package ReqRepository;

public class ReqRepository_Post {
	
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		
		return baseURI;
			
	}
	
	public static String resource() {
		String resource="/api/users";
		
		return resource;
		
	}
	
	public static String requestBody() {
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		return requestBody;
		
	}
}
