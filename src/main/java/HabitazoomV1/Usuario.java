package HabitazoomV1;
import java.sql.SQLException;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String alias;
	private String correo;
	private String contrasena;
	private String fecha_Nacimiento;
	private String descripcion;
	
	
	public Usuario(String n,String a,String al,String c, String cont, String nac) {
		this.nombre=n;
		this.apellido=a;
		this.alias=al;
		this.correo=c;
		this.contrasena=cont;
		this.fecha_Nacimiento=nac;
	}
	
	public Usuario(String n,String a,String al,String c, String cont, String nac, String descripcion) {
		this(n,a,al,c,cont,nac);
		this.descripcion=descripcion;
	}
	
	public static Usuario inicioSesion(String correo,String contrasena) throws Excepcion {

        AccesoBD aux = AccesoBD.getInstance();

        Usuario res= aux.buscarUsuario(correo);

        if(res==null) {
            throw new Excepcion("no existe ese usuario");
        } else if(!res.getContrasena().equals(contrasena)) {
            throw new Excepcion("contrase�a incorrecta");
        }

        return res;
    }
	
	public static void nuevoUsuario(String n,String a,String al,String c, String cont, String nac, String descripcion) throws Excepcion {

        Usuario usr = new Usuario(n,a,al,c,cont,nac,descripcion);
        AccesoBD aux = AccesoBD.getInstance();
		aux.anadirUsuario(usr);

    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(String fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString () {
		return "Correo: " + correo + " || alias: " + alias + " || pass: " + contrasena
				+ " || fecha: " + fecha_Nacimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + fecha_Nacimiento.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (fecha_Nacimiento != other.fecha_Nacimiento)
			return false;
		return true;
	}
}
