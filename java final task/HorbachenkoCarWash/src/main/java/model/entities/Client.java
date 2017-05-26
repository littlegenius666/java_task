package model.entities;

public class Client {

	public enum Gender{male, female}
	
	private int id_client;
	private String name;
	private Gender gender;
	private int car_count;
	private int service_count;
	private String phone_number;
	
	public Client() {
		id_client=-1;
		name="Enter name";
		gender=Gender.male;
		car_count=1;
		service_count=1;
		phone_number="+380501234567";
	}
	
	
	
	public int getId_client() {
		return id_client;
	}
	
	public String getName() {
		return name;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public int getCar_count() {
		return car_count;
	}
	
	public int getService_count() {
		return service_count;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public static ClientBuilder newBuilder() {
        return new Client().new ClientBuilder();
    }
	
	@Override
	public String toString() {
		StringBuilder result=new StringBuilder()
		.append(name).append(" ")
		.append(gender).append(" ")
		.append(car_count).append(" ")
		.append(service_count).append(" ")
		.append(phone_number);
		return result.toString();
	}
	
	public String toShortString() {
		StringBuilder result=new StringBuilder()
		.append(name).append(" ")
		.append(phone_number);
		return result.toString();
	}
	
	public class ClientBuilder {
		
		private ClientBuilder( ) {
			
		}
		
		public ClientBuilder setId_client(int id_client) {
			Client.this.id_client = id_client;
			return this;
		}
		
		public ClientBuilder setName(String name) {
			Client.this.name = name;
			return this;
		}
		
		public ClientBuilder setGender(Gender gender) {
			Client.this.gender = gender;
			return this;
		}
		
		public ClientBuilder setCar_count(int car_count) {
			Client.this.car_count = car_count;
			return this;
		}
		
		public ClientBuilder setService_count(int service_count) {
			Client.this.service_count = service_count;
			return this;
		}
		
		public ClientBuilder setPhone_number(String phone_number) {
			Client.this.phone_number = phone_number;
			return this;
		}
		
		public Client build() {
	        return Client.this;
	    }
		
	}
	
}
