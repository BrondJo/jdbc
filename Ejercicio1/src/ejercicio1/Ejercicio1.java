package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.sql.ResultSet;

public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadulp", "root", "");

            /*System.out.println("Carga de alumnos");
             System.out.println("----------------");
             //Consultas: carga de 3 alumnos
            for (int i = 0; i < 3; i++) {
                System.out.println("Ingrese dni del alumno "+(i+1));
                int dni = tc.nextInt();
                tc.nextLine();
                System.out.println("Ingrese nombre del alumno "+(i+1));
                String nombre = tc.nextLine();
                System.out.println("Ingrese apellido del alumno "+(i+1));
                String apellido = tc.nextLine();
                System.out.println("Ingrese fecha de nacimiento del alumno "+(i+1) + " (formato = yyyy-mm-dd)");
                String fechaNac = tc.nextLine();
                System.out.println("Ingrese estado del alumno "+(i+1));
                boolean estado = tc.nextBoolean();

                String insert1 = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps1 = con.prepareStatement(insert1);
                ps1.setInt(1, dni);
                ps1.setString(2, apellido);
                ps1.setString(3, nombre);
                ps1.setString(4, fechaNac);
                ps1.setBoolean(5, estado);
                int registro1 = ps1.executeUpdate();

                if (registro1 == 1) {
                    JOptionPane.showMessageDialog(null, "Successful query!");
                } else {
                    JOptionPane.showMessageDialog(null, "Query error!");
                }
            }*/
 /*Consultas: carga de 4 materias
            String sql = "INSERT INTO materia VALUES(null, 'ingles', 2, true), (null, 'base de datos', 2, true), (null, 'estructura de datos', 1, true), (null, 'metodologias agiles', 3, true)";
            PreparedStatement ps = con.prepareStatement(sql);
            int registro2 = ps.executeUpdate();
   
            if (registro2 >= 1) {
                    JOptionPane.showMessageDialog(null, "Successful query!");
                } else {
                    JOptionPane.showMessageDialog(null, "Query error!");
                }*/
 
 
            //consultas: incribir a los 3 alumnos en 2 materias cada uno
            /*String sql = "INSERT INTO inscripcion VALUES (null, 7, 6, 13), (null, 8, 6, 14), (null, 6, 7, 15), (null, 9, 7, 16), (null, 10, 8, 13), (null, 5, 8, 16)";
            PreparedStatement ps = con.prepareStatement(sql);
            int registro3 = ps.executeUpdate();
            if (registro3 >= 1) {
                JOptionPane.showMessageDialog(null, "Successful query!");
            } else {
                JOptionPane.showMessageDialog(null, "Query error!");
            }*/
            
            
            //Consulta: listar alumnos con nota superior a 8
            /*String sql = "SELECT alumno.nombre, alumno.apellido, inscripcion.nota FROM alumno JOIN inscripcion ON (inscripcion.id_alumno = alumno.id_alumno) WHERE nota > 8";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();
            
            while(resultado.next()){
                System.out.println("Nombre: "+resultado.getString("nombre"));
                System.out.println("Apellido: "+resultado.getString("apellido"));
                System.out.println("Nota: "+resultado.getInt("nota"));
                System.out.println();
            }*/
            
            //consulta: desuscribir un alumno de una de las materias
            String sql ="DELETE FROM inscripcion WHERE id_materia = 16 AND id_alumno = 8";
            PreparedStatement ps = con.prepareStatement(sql);
            int registro3 = ps.executeUpdate();
            if (registro3 >= 1) {
                JOptionPane.showMessageDialog(null, "Successful query!");
            } else {
                JOptionPane.showMessageDialog(null, "Query error!");
            }
            

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error loading JDBC driver" + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error connecting to the databases" + ex.getMessage());
        }

    }

}
