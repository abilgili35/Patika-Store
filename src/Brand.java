public class Brand implements Comparable<Brand>{
    private static int nextId = 1;
    private String name;
    private int id;

    public Brand(String name){
        setName(name);
        setId();
    }
    

    public int getId() {
        return id;
    }
    public void setId() {
        this.id = this.nextId;
        this.nextId++;
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Brand o) {
        return this.getName().compareTo(o.getName());
    }
}
