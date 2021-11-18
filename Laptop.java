class Laptop extends Specifications {
    public String Availability;

    public Laptop(int id, String name, int price, String Availability) {
        super(id, name, price);
        this.Availability = Availability;
    }

    public String getAvailability() {
        return Availability;
    }

   public Laptop(String laptopLine) {
        super(laptopLine);
       //System.out.println(laptopLine);
       String []values = laptopLine.split(",");
       super.setId(Integer.valueOf(values[0]));
       super.setName((values[1]));
       super.setPrice(Integer.valueOf(values[2]));
       setAvailability( values[3]);
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    @Override
    public String toString() {
        return " id=" + getId() + ", name=" + getName() + ", price=" + getPrice() + " , Availability=" + getAvailability();
    }        
}
