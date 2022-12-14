package ec.edu.intsuperior.modelo;

import ec.edu.intsuperior.controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConsultas extends Conexion {

    
    //SQLCLIENTE
    public boolean registrar(cliente cli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO clientes (cliCedula, cliNombreCompleto, cliTelefono, cliDireccion, cliEmail) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getCed());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getTel());
            ps.setString(4, cli.getDir());
            ps.setString(5, cli.getEmail());
            ps.execute();
            return true;
        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean modificar(cliente cli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE clientes SET cliCedula=?, cliNombreCompleto=?, cliTelefono=?, cliDireccion=?, cliEmail=? WHERE idClientes=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getCed());
            ps.setString(2, cli.getNom());
            ps.setString(3, cli.getTel());
            ps.setString(4, cli.getDir());
            ps.setString(5, cli.getEmail());
            ps.setInt(6, cli.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean eliminar(cliente cli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM clientes WHERE idClientes=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean buscar(cliente cli) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM clientes WHERE cliCedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getCed());
            rs = ps.executeQuery();

            if (rs.next()) {
                cli.setId(Integer.parseInt(rs.getString("idClientes")));
                cli.setCed(rs.getString("cliCedula"));
                cli.setNom(rs.getString("cliNombreCompleto"));
                cli.setTel(rs.getString("cliTelefono"));
                cli.setDir(rs.getString("cliDireccion"));
                cli.setEmail(rs.getString("cliEmail"));

                return true;
            }

            return false;
        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    
    //SQLEMPLEADO
    
    public boolean registrarEmp(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO empleados (empCedula, empNombreCompleto, empEdad, empDireccion, empCargo, empEstadoCivil, empCorreo, empTelefono, empHorarioEntrada) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getCedEmp());
            ps.setString(2, emp.getNomEmp());
            ps.setString(3, emp.getEdadEmp());
            ps.setString(4, emp.getDirEmp());
            ps.setString(5, emp.getCarEmp());
            ps.setString(6, emp.getEstadoEmp());
            ps.setString(7, emp.getCorreoEmp());
            ps.setString(8, emp.getTelEmp());
            ps.setString(9, emp.getHoraEmp());
            
            ps.execute();
            return true;
        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    public boolean modificarEmp(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE empleados SET empCedula=?, empNombreCompleto=?, empEdad=?, empDireccion=?, empCargo=?, empEstadoCivil=?, empCorreo=?, empTelefono=?, empHorarioEntrada=? WHERE idEmpleado=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getCedEmp());
            ps.setString(2, emp.getNomEmp());
            ps.setString(3, emp.getEdadEmp());
            ps.setString(4, emp.getDirEmp());
            ps.setString(5, emp.getCarEmp());
            ps.setString(6, emp.getEstadoEmp());
            ps.setString(7, emp.getCorreoEmp());
            ps.setString(8, emp.getTelEmp());
            ps.setString(9, emp.getHoraEmp());
            ps.setInt(10, emp.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    public boolean eliminarEmp(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM empleados WHERE idEmpleado=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    public boolean buscarEmp(Empleado emp) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM empleados WHERE empCedula=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getCedEmp());
            rs = ps.executeQuery();

            if (rs.next()) {
                emp.setId(Integer.parseInt(rs.getString("idEmpleado")));
                emp.setCedEmp(rs.getString("empCedula"));
                emp.setNomEmp(rs.getString("empNombreCompleto"));
                emp.setEdadEmp(rs.getString("empEdad"));
                emp.setDirEmp(rs.getString("empDireccion"));
                emp.setCarEmp(rs.getString("empCargo"));
                emp.setEstadoEmp(rs.getString("empEstadoCivil"));
                emp.setCorreoEmp(rs.getString("empCorreo"));
                emp.setTelEmp(rs.getString("empTelefono"));
                emp.setHoraEmp(rs.getString("empHorarioEntrada"));

                return true;
            }

            return false;
        } catch (SQLException e) {

            System.err.println(e);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
}
