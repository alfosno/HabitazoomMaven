package HabitazoomV1;

public class Prueba {

	public static void main(String[] args) {
		AccesoBD accesoBD = AccesoBD.getInstance();
		
		Usuario usuario = accesoBD.buscarUsuario("hola@gmail.com");
		
		if (usuario != null) {
			System.out.println(usuario);
		} else {
			System.out.println("oleeeeee");
		}
		

	}

}
