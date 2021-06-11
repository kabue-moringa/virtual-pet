import org.sql2o.*;

import java.util.List;

public class Person {
    private String email;
    private String name;
    private int id;

    public Person(String name, String email) {


        this.email = email;
        this.name = name;
    }

    public static List<Person> all() {
        String sql = "SELECT * FROM persons";
            try(Connection con =DB.sql2o.open()){
                return con.createQuery(sql).executeAndFetch(Person.class);
            }

    }

//    public static long find(int id) {
//    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    public static Person find(int id) {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM persons where id = :id";
            Person person = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Person.class);
            return person;
        }
    }


//    Override

    @Override
    public boolean equals(Object otherPerson){
       if(!(otherPerson instanceof Person)){
           return false;
       }else{
           Person newPerson = (Person) otherPerson;
           return this.getName().equals(newPerson.getName())&&
                   this.getEmail().equals(newPerson.getEmail());
       }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO persons(name, email) VALUES(:name, email)";
                    con.createQuery(sql)
                            .addParameter("name", this.name)
                            .addParameter("email",this.email)
                            .executeUpdate()
                            .getKey();

        }



    }

    public int getId() {
        return id;
    }


}
