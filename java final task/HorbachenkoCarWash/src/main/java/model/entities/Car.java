package model.entities;

public class Car {
	
	public enum Car_Type{jeep, passenger, minibus}
	
	private String plate_numbers;
	private Client owner;
	private Car_Type type;
	
	public Car() {
		
	}

	public String getPlate_numbers() {
		return plate_numbers;
	}

	public Client getOwner() {
		return owner;
	}

	public Car_Type getType() {
		return type;
	}
	
	public static CarBuilder newBuilder() {
        return new Car().new CarBuilder();
    }

	@Override
	public String toString() {
		StringBuilder result=new StringBuilder()
				.append(plate_numbers).append(" ")
				.append(type).append(" ")
				.append(owner.toShortString());
				
		return result.toString();
	}

	public class CarBuilder {
		
		private CarBuilder( ) {
			
		}
		
		public CarBuilder setPlate_numbers(String plate_numbers) {
			Car.this.plate_numbers = plate_numbers;
			return this;
		}

		public CarBuilder setOwner(Client owner) {
			Car.this.owner = owner;
			return this;
		}

		public CarBuilder setType(Car_Type type) {
			Car.this.type = type;
			return this;
		}
		
		public Car build() {
	        return Car.this;
	    }
		
	}
	
}
