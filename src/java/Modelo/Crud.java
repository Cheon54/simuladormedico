package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Crud {
    private final Conexion c = new Conexion();
    private final Connection con = c.Conectar();
    private PreparedStatement psInsertar;
    
    public String insertarUsuario(Usuario ct){
        try{
            if(con != null){
                PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_paciente where rut_paciente = ?");
                ps.setString(1, ct.getRut());
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    return "Rut ingresado ya está en uso.";
                }else{
                    psInsertar = con.prepareStatement("INSERT INTO tbl_paciente(rut_paciente, nombre_paciente, apellidop_paciente, apellidom_paciente, fnac_paciente, genero_paciente, telefono_paciente, email_paciente, Cod_Comuna, calle_paciente, ncalle_paciente, Cod_Prevision, Clave) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    psInsertar.setString(1, ct.getRut());
                    psInsertar.setString(2, ct.getNombres());
                    psInsertar.setString(3, ct.getApellidop());
                    psInsertar.setString(4, ct.getApellidom());
                    psInsertar.setString(5, ct.getFnac());
                    psInsertar.setString(6, ct.getGenero());
                    psInsertar.setInt(7, ct.getFono());
                    psInsertar.setString(8, ct.getEmail());
                    psInsertar.setInt(9, ct.getComuna());
                    psInsertar.setString(10, ct.getDireccion());
                    psInsertar.setInt(11, ct.getNdireccion());
                    psInsertar.setInt(12, ct.getPrevision());
                    psInsertar.setString(13, ct.getClave());
                    boolean result = psInsertar.execute();
                    if (!result){
                        return "Usuario registrado Correctamente.";
                    }else{
                        return "Error no se pudo registrar usuario.";
                    }
                }
            }else{
                return "No hay conexión con base de dato.";
            }
        }catch(SQLException e){
            return "SQL exception occured" + e;
        }
    }
    public String insertarCita(int idhora, String rut){
        try{
            String idrut = consultaDato(rut, "Cod_Paciente");
            int idruta = Integer.parseInt(idrut);
            if(con != null){
                PreparedStatement ps = con.prepareStatement("SELECT estado_hora FROM tbl_horamedica where Cod_HoraMedica = ?");
                ps.setInt(1, idhora);
                ResultSet rs = ps.executeQuery();
                int valor = 0;
                while(rs.next()){
                    valor = rs.getInt(1);
                }
                
                if(valor == 1){
                    return "Cita ingresada ya está en uso.";
                }else{
                    psInsertar = con.prepareStatement("INSERT INTO tbl_citamedica(Cod_Paciente, Cod_HoraMedica) Values (?,?)");
                    psInsertar.setInt(1, idruta);
                    psInsertar.setInt(2, idhora);
                    boolean result = psInsertar.execute();
                    if (!result){
                        PreparedStatement up = con.prepareStatement("update tbl_horamedica set estado_hora = 1 where Cod_HoraMedica = "+idhora+"");
                        up.execute();
                        return "Hora registrada Correctamente.";
                    }else{
                        return "Error no se pudo registrar hora.";
                    }
                }
            }else{
                return "No hay conexión con base de dato.";
            }
        }catch(SQLException e){
            return "SQL exception occured" + e;
        }
    }
    public String eliminarCita(int idcita, int idhora){
        try{
            if(con != null){
                psInsertar = con.prepareStatement("Delete FROM tbl_citamedica where Cod_CitaMedica = ?");
                psInsertar.setInt(1, idcita);
                boolean result = psInsertar.execute();
                if (!result){
                    PreparedStatement up = con.prepareStatement("update tbl_horamedica set estado_hora = 0 where Cod_HoraMedica = "+idhora+"");
                    up.execute();
                    return "Cita eliminada Correctamente.";
                }else{
                    return "Error cita ya eliminada.";
                }
            }else{
                return "No hay conexión con base de dato.";
            }
        }catch(SQLException e){
            return "SQL exception occured" + e;
        }
    }
    public static LinkedList<Comuna> getComunas(){
        LinkedList<Comuna> listaComuna = new LinkedList<>();
        try{
              Conexion c = new Conexion();
              Connection con = c.Conectar();
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery("select * from tbl_comuna");
              while (rs.next()){
                 Comuna comuna = new Comuna();
                 comuna.setId(rs.getInt("Cod_Comuna"));
                 comuna.setNombre(rs.getString("nombre_comuna"));
                 listaComuna.add(comuna);
              }
              rs.close();
              st.close();
        }catch (SQLException e){
            System.out.println("SQL exception occured" + e);
        }
        return listaComuna;
    }
    public static LinkedList<Prevision> getPrevisiones(){
        LinkedList<Prevision> listaPrevision = new LinkedList<>();
        try{
              Conexion c = new Conexion();
              Connection con = c.Conectar();
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery("select * from tbl_prevision");
              while (rs.next()){
                 Prevision prevision = new Prevision();
                 prevision.setId(rs.getInt("Cod_Prevision"));
                 prevision.setNombre(rs.getString("nombre_prevision"));
                 listaPrevision.add(prevision);
              }
              rs.close();
              st.close();
        }catch (SQLException e){
            System.out.println("SQL exception occured" + e);
        }
        return listaPrevision;
    }
    public boolean consultaUsuario(String rut){
        try{
            if(con != null){
                PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_paciente where rut_paciente = ?");
                ps.setString(1, rut);
                ResultSet rs = ps.executeQuery();
                return rs.next();
            }else{
                return false;
            }
        }catch(SQLException e){
            return false;
        }
    }
    public boolean consultaClave(String rut, String clave){
        try{
            if(con != null){
                PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_paciente where Clave = ? and rut_paciente = ?");
                ps.setString(1, clave);
                ps.setString(2, rut);
                ResultSet rs = ps.executeQuery();
                return rs.next();
            }else{
                return false;
            }
        }catch(SQLException e){
            return false;
        }
    }
    public String consultaDato(String rut, String parametro){
        try{
            if(con != null){
                PreparedStatement ps = con.prepareStatement("SELECT "+parametro+" FROM tbl_paciente where rut_paciente = ?");
                ps.setString(1, rut);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    return rs.getString(1);
                }else{
                    return "No hay dato";
                }
            }else{
                return "Erro bd";
            }
        }catch(SQLException e){
            return "Error";
        }
    }
    public String consultaDatoMedico(String rut, String parametro){
        try{
            if(con != null){
                PreparedStatement ps = con.prepareStatement("SELECT "+parametro+" FROM tbl_medico where rut_medico = ?");
                ps.setString(1, rut);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    return rs.getString(1);
                }else{
                    return "No hay dato";
                }
            }else{
                return "Erro bd";
            }
        }catch(SQLException e){
            return "Error";
        }
    }
}
