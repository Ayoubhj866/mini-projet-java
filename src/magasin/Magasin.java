package magasin;

import java.util.Random;

public class Magasin {

    private long id  ;
    private String name ;
    private String address ;


    public Magasin (String name    , String address  )
    {
        this.id = new Random().nextInt(500) + 1;
        this.name = name ;
        this.address = address ;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    @Override
    public String toString() {
        return "Magasin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
