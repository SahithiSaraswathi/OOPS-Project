public abstract class Specifications {
    private int id;
    private String name;
    protected String Availability;
    private int price;

    public Specifications() {
    }

    public Specifications(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public Specifications(String laptopLine) {
        System.out.println(laptopLine);
        String values[] = laptopLine.split(",");
        this.id = Integer.valueOf(values[0]);
        this.name = values[1];
        this.price = Integer.valueOf(values[2]);
        this.Availability = values[3];

    }
}
