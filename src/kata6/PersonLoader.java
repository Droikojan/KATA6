package kata6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class PersonLoader {
    
    public static ArrayList<Person1> read () throws ClassNotFoundException, SQLException{
        
        ArrayList<Person1> lista = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        Connection connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA6\\Data\\KATA.sDB");
        Statement state = connect.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM PEOPLE");
        
        while (rs.next()){
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            String genero = rs.getString(3);
            String fechaNacimiento = rs.getString(4);
            Float peso = rs.getFloat(5);
            String mail = rs.getString(6);
            
            lista.add(new Person1(id, name, genero, fechaNacimiento, peso, mail));
        }
                
        return lista;
    }
    
}
