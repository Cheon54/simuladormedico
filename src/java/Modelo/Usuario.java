package Modelo;

/**
 *
 * @author angel
 */
public class Usuario {
    String rut;
    String nombres;
    String apellidop;
    String apellidom;
    String fnac;
    String genero;
    int fono;
    String email;
    int comuna;
    String direccion;
    int ndireccion;
    int prevision;
    String clave;

    public Usuario(String rut, String nombres, String apellidop, String apellidom, String fnac, String genero, int fono, String email, int comuna, String direccion, int ndireccion, int prevision, String clave) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.fnac = fnac;
        this.genero = genero;
        this.fono = fono;
        this.email = email;
        this.comuna = comuna;
        this.direccion = direccion;
        this.ndireccion = ndireccion;
        this.prevision = prevision;
        this.clave = clave;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNdireccion() {
        return ndireccion;
    }

    public void setNdireccion(int ndireccion) {
        this.ndireccion = ndireccion;
    }

    public int getPrevision() {
        return prevision;
    }

    public void setPrevision(int prevision) {
        this.prevision = prevision;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
