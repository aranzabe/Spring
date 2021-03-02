package Modelos;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    //********************* Atributos *************************
    private java.sql.Connection Conex;
    //Atributo a través del cual hacemos la conexión física.
    private java.sql.Statement Sentencia_SQL;
    //Atributo que nos permite ejecutar una sentencia SQL
    private java.sql.ResultSet Conj_Registros;
    //(Cursor) En él están almacenados los datos.
    private String bbdd;
    private String usuario;
    private String clave;

    //********************** Constructores **************************
    //----------------------------------------------------------
    public Conexion() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, SQLException {
        //Cargar el driver/controlador
        String controlador = "com.mysql.jdbc.Driver";
        //String controlador = "oracle.jdbc.driver.OracleDriver";
        //String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
        Class.forName(controlador).newInstance();

        Conectar("ejemplo");
    }

    public Conexion(String b, String u, String c) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, SQLException {
        //Cargar el driver/controlador
        String controlador = "com.mysql.jdbc.Driver";
        //String controlador = "oracle.jdbc.driver.OracleDriver";
        //String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
        Class.forName(controlador).newInstance();
        bbdd = b;
        usuario = u;
        clave = c;
        Conectar(bbdd);
    }

    //********************** Métodos **************************
    //----------------------------------------------------------
    private void Conectar(String nombre_bbdd) throws SQLException {
        String URL_BD = "jdbc:mysql://localhost/" + nombre_bbdd;
        //String URL_BD = "jdbc:oracle:oci:@REPASO";
        //String URL_BD = "jdbc:oracle:oci:@REPASO";
        //String URL_BD = "jdbc:odbc:REPASO";

        //Realizamos la conexión a una BD con un usuario y una clave.
        try {
            Conex = java.sql.DriverManager.getConnection(URL_BD, usuario, clave);
            Sentencia_SQL = Conex.createStatement();
            System.out.println("Conexion realizada con éxito");
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }

    }

    //----------------------------------------------------------
    public List Obtener_Datos_Tabla(String nom_tabla) throws SQLException {
        List<Persona> lp = new ArrayList();
        //List <Persona>lp = new LinkedList();
        String Sentencia = "SELECT * FROM " + nom_tabla;
        Conj_Registros = Sentencia_SQL.executeQuery(Sentencia);
        while (Conj_Registros.next()) {
            lp.add(new Persona(Conj_Registros.getString("DNI"), Conj_Registros.getString("Nombre"), Conj_Registros.getString("Tfno")));
        }
        return lp;
    }


    //----------------------------------------------------------
    public void Insertar_Dato(String tabla, String DNI, String Nombre, String apell, int Tfno, int avi) {
        String Sentencia = "INSERT INTO " + tabla + " VALUES ('" + DNI + "'," + "'" + Nombre + "','" + apell + "','" + Tfno + "','" + avi + "')";
        try {
            Sentencia_SQL.executeUpdate(Sentencia);
        } catch (SQLException sq) {
            javax.swing.JOptionPane.showMessageDialog(null, "Clave duplicada", "Añadir", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    //------------------------------------------------------
    int Insertar_Dato(String tab, String d, String nom, int tfn) throws SQLException {
        String Sentencia = "INSERT INTO " + tab + " VALUES ('" + d + "'," + "'" + nom + "'," + tfn + ")";
        return Sentencia_SQL.executeUpdate(Sentencia);
    }

    public boolean insertar(String dn, String no, String tfno) {
        boolean ok = true;
        String sql = "INSERT INTO personas VALUES ('" + dn + "', '" + no + "', '" + tfno + "')";
        try {
            this.Sentencia_SQL.execute(sql);
        } catch (Exception w) {
            ok = false;
        }
        return ok;
    }

}
