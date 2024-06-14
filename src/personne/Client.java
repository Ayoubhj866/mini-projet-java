package personne;

public class Client {

    //conteur
    private static long idCounter = 1 ;

    private long ID ;
    private String firstName  ;
    private String lastName ;

    public Client (String firstName , String lastName)
    {
        this.ID = generateId() ;
        this.firstName = firstName  ;
        this.lastName = lastName ;
    }

    // générer un ID unique
    private synchronized long generateId() {
        return idCounter++;
    }

    // Getters and Setters


    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        Client.idCounter = idCounter;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }
}
