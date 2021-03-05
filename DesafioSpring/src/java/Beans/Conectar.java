/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author maria
 */
public class Conectar {

    private JdbcTemplate jdbcTem;

    public Conectar() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/" + Datos_BD.bbdd);
        ds.setUsername(Datos_BD.usuario);
        ds.setPassword(Datos_BD.clave);

        jdbcTem = new JdbcTemplate(ds);
    }

    public Conectar(String bd, String usuario, String pass) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/" + bd);
        ds.setUsername(usuario);
        ds.setPassword(pass);

        jdbcTem = new JdbcTemplate(ds);
    }

    //----------------------------------------------------------
    public List Obtener_Datos_Tabla(String nom_tabla) throws SQLException {
        String sql = "select * from " + nom_tabla;
        //La función queryForList devuelve un Objeto de tipo List con una colección de Maps que se corresponden a cada una de las filas de la tabla.
        List datos = this.jdbcTem.queryForList(sql);
        return datos;
    }

    public boolean insertar(String tabla, String email, String nom, String apellido, String pass, String rol) {
        boolean ok = true;
        String sql = "INSERT INTO "+ tabla + " VALUES ('"+email+"', '" + nom + "', '" + apellido + "', '"+ pass + "', '"+rol+"')";
        try {
            this.jdbcTem.execute(sql);
        } catch (Exception w) {
            ok = false;
        }
        return ok;
    }
    
    public boolean insertarPreg(String tabla, String enunciado, String tipo) {
        boolean ok = true;
        String sql = "INSERT INTO "+ tabla + " VALUES (default, '"+ enunciado +"', '"+tipo+"')";
        try {
            this.jdbcTem.execute(sql);
        } catch (Exception w) {
            ok = false;
        }
        return ok;
    }
    
    public boolean insertarResp(String tabla, int id_preg, String descripcion, int correcta) {
        boolean ok = true;
        String sql = "INSERT INTO "+ tabla + " VALUES (default, "+ id_preg +", '"+ descripcion +"', "+ correcta +")";
        try {
            this.jdbcTem.execute(sql);
        } catch (Exception w) {
            ok = false;
        }
        return ok;
    }
    
    public List buscarUsuario(String nom_tabla, String email, String pass) throws SQLException {
        String sql = "select * from " + nom_tabla + " where email='"+ email+"' and pass='"+ pass+"'";
        
        List datos = this.jdbcTem.queryForList(sql);
        
        return datos;
    }
    
    public List sacarExamen() throws SQLException {
        String sql = "select * from preguntas JOIN respuesta on preguntas.id_preg = respuesta.id_preg ";
        
        List datos = this.jdbcTem.queryForList(sql);
        
        return datos;
    }
    
    public boolean eliminarPreg(String tabla, int id) {
        boolean ok = true;
        String sql = "DELETE FROM " +tabla+" WHERE id_preg = "+id;
        try {
            this.jdbcTem.execute(sql);
        } catch (Exception w) {
            ok = false;
        }
        return ok;
    }
    
    public List sacarResp(String tabla, int id) throws SQLException {
        String sql = "SELECT * FROM " +tabla+" WHERE id_preg = "+id;
        
        List datos = this.jdbcTem.queryForList(sql);
        
        return datos;
    }
    
    public List obtenerPersona(String nom_tabla, String email) throws SQLException {
        String sql = "select * from " + nom_tabla + " where email='"+ email+"'";
        
        List datos = this.jdbcTem.queryForList(sql);
        
        return datos;
    }
    
    public boolean guardarNota(String email, float puntos) {
        boolean ok = true;
        String sql = "INSERT INTO notas VALUES ('"+ email +"', "+ puntos +")";
        try {
            this.jdbcTem.execute(sql);
        } catch (Exception w) {
            ok = false;
        }
        return ok;
    }
    
    public boolean modificarNota(String email, float puntos) {
        boolean ok = true;
        String sql = "UPDATE notas SET nota="+ puntos +" WHERE email='"+ email+ "' ";
        try {
            this.jdbcTem.execute(sql);
        } catch (Exception w) {
            ok = false;
        }
        return ok;
    }
    
    public List corregir(String nom_tabla, int id, int resp) throws SQLException {
        String sql = "select * from " + nom_tabla + " where id_preg="+ id+" and id_resp = "+ resp +" and correcta = 1";
        
        List datos = this.jdbcTem.queryForList(sql);
        
        return datos;
    }
     
}
