/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//Esta librería se puede utilizar en un proyecto JSP o Servlet o Struts2

/**
 *
 * @author faranzabe
 */
public class Conectar {

    private JdbcTemplate jdbcTem;

    public Conectar() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/ejemplo");
        ds.setUsername("fernando");
        ds.setPassword("Chubaca2018");

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

    public boolean insertar(String dn, String no, String tfno) {
        boolean ok = true;
        String sql = "INSERT INTO personas VALUES ('" + dn + "', '" + no + "', '" + tfno + "')";
        try {
            this.jdbcTem.execute(sql);
        } catch (Exception w) {
            ok = false;
        }
        return ok;
    }
}
