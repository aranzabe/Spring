
package Beans;

import java.sql.*;
import java.util.Calendar;

public class Conexion 
{
    
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
            InstantiationException, IllegalAccessException, SQLException
    {
        //Cargar el driver/controlador
        String controlador = "com.mysql.jdbc.Driver";
        //String controlador = "oracle.jdbc.driver.OracleDriver";
        //String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
        Class.forName(controlador).newInstance();
        
        Conectar("examen");
    }
    
    public Conexion(String b,String u,String c) throws ClassNotFoundException, 
            InstantiationException, IllegalAccessException, SQLException
    {
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
    private void Conectar(String nombre_bbdd) throws SQLException
    {
        String URL_BD = "jdbc:mysql://localhost/" + nombre_bbdd;
        //String URL_BD = "jdbc:oracle:oci:@REPASO";
        //String URL_BD = "jdbc:oracle:oci:@REPASO";
        //String URL_BD = "jdbc:odbc:REPASO";
      
        //Realizamos la conexión a una BD con un usuario y una clave.
        try {
            Conex = java.sql.DriverManager.getConnection(URL_BD,usuario,clave);
            Sentencia_SQL = Conex.createStatement();
            System.out.println("Conexion realizada con éxito");
        }
        catch (Exception e)
        {
            System.err.println("Exception: "+e.getMessage());
        }

    }

    
    //----------------------------------------------------------
    public void Obtener_Datos_Tabla(String nom_tabla) throws SQLException
    {
        String Sentencia = "SELECT * FROM " + nom_tabla;
        Conj_Registros =  Sentencia_SQL.executeQuery(Sentencia);
    }
    
    public Object obtenerDato(String tabla, String campo, String dato, String condicion) throws SQLException{
        Object dato_guardado=0;
        String Sentencia = "SELECT "+campo+" FROM " + tabla + " WHERE "+condicion+" = '"+dato+"'";
        Conj_Registros =  Sentencia_SQL.executeQuery(Sentencia);
        Conj_Registros.next();
        dato_guardado=Conj_Registros.getString(campo);
        return dato_guardado;
    }
    
    public String Obtener_Ultimo(String Campo) throws SQLException
    {
        String valor;

        Conj_Registros.last();
        valor = Conj_Registros.getString(Campo);
        return valor;
    }
    
    public String sacarRespu(String tabla, String campo, int dato) throws SQLException{
        String dato_guardado="";
        String Sentencia = "SELECT "+campo+" FROM " + tabla + " WHERE id_preg = "+dato+" AND CORRECTA = 1";
        Conj_Registros =  Sentencia_SQL.executeQuery(Sentencia);
        Conj_Registros.next();
        dato_guardado=Conj_Registros.getString(campo);
        return dato_guardado;
    }
    
    public String sacarDatos(int i, String campo) throws SQLException{
        String dato="";
        Conj_Registros.absolute(i+1);
        dato= Conj_Registros.getString(campo);
        
        return dato;
    }
    
    public int sacarNumRespu(String tabla, int dato) throws SQLException{
        int tam = 0;
        String Sentencia = "SELECT * FROM " + tabla + " WHERE id_preg = "+dato+" AND CORRECTA = 1";
        Conj_Registros =  Sentencia_SQL.executeQuery(Sentencia);
        Conj_Registros.last();
        tam= Conj_Registros.getRow();
        return tam;
    }
    

}






