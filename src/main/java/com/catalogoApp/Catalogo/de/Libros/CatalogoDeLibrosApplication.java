package com.catalogoApp.Catalogo.de.Libros;

import com.catalogoApp.Catalogo.de.Libros.model.AutorDelLibro;
import com.catalogoApp.Catalogo.de.Libros.model.LibroDelAutor;
import com.catalogoApp.Catalogo.de.Libros.repository.AutorRepository;
import com.catalogoApp.Catalogo.de.Libros.repository.LibroRepository;
import com.catalogoApp.Catalogo.de.Libros.service.ConsumoApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CatalogoDeLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoDeLibrosApplication.class, args);
	}

	public class PrincipalAPP {
		private final Scanner teclado = new Scanner(System.in);
		private final ConsumoApi consumoAPI = new ConsumoApi();
		private static final String URL_BASE = "https://gutendex.com/books/?page=";
		private final LibroRepository libroRepository;
		private final AutorRepository autorRepository;

		public PrincipalAPP(LibroRepository libroRepository, AutorRepository autorRepository) {
			this.libroRepository = libroRepository;
			this.autorRepository = autorRepository;
		}

		public void muestraElMenu() {
			int opcion;

			do {
				System.out.println("""
                    BIENVENIDOS, CATALOGO DE LIBROS - LITERALURA CHALLENG
                    """);
				var menu = """
                    1 - Buscar libro por titulo
                    2 - Lista de libros registrados
                    3 - Lista de autores registrados
                    4 - Lista de autores vivos en un determinado año
                    5 - Lista de libros por idioma
                    
                    6 - Salir
                    """;
				System.out.println(menu);
				opcion = teclado.nextInt();
				teclado.nextLine();

				switch (opcion) {
					case 1:
						buscarLibroPorTitulo();
						break;
					case 2:
						buscarLibrosRegistrados();
						break;
					case 3:
						buscarAutoresRegistrados();
						break;
					case 4:
						buscarAutoresVivos();
					case 5:
						buscarLibrosPorIdioma();
						break;
					case 6:
						System.out.println("Saliendo de la aplicación, gracias por utilizar nuestro servicio!!");
						break;
					default:
						System.out.println("Opcion incorrecta, Por favor seleccione una opción valida");
				}
			} while (opcion != 6);
		}

		private void buscarLibroPorTitulo() {
			System.out.println("Ingrese el titulo del libro a buscar: ");
			String tituloLibro = teclado.nextLine();
			try {
				List<LibroDelAutor> libros = libroRepository.findAll();

				if (!libros.isEmpty()) {

					for (LibroDelAutor libro : libros) {
						System.out.println("\n\n********** LIBROS **********\n");
						System.out.println("Titulo: " + libro.getTitulo());
						System.out.println("Autor: " + libro.getAutor().getNombre());
						System.out.println("Idioma: " + libro.getLenguaje());
						System.out.println("Descargas: " + libro.getDescargas());
						System.out.println("\n****************************\n\n");
					}
				} else {
					System.out.println("\n\n****** NO SE ENCONTRARON RESULTADOS ******\n\n");
				}
			} catch (Exception e) {
				System.out.println("\n\n****** ERROR AL BUSCAR LIBROS REGISTRADOS ******\n\n");
				e.printStackTrace();
			}
		}

		private void buscarLibrosRegistrados() {
			try {
				List<LibroDelAutor> libros = libroRepository.findAll();

				if (!libros.isEmpty()) {

					for (LibroDelAutor libro : libros) {
						System.out.println("\n\n********** LIBROS **********\n");
						System.out.println("Titulo: " + libro.getTitulo());
						System.out.println("Autor: " + libro.getAutor().getNombre());
						System.out.println("Idioma: " + libro.getLenguaje());
						System.out.println("Descargas: " + libro.getDescargas());
						System.out.println("\n****************************\n\n");
					}
				} else {
					System.out.println("\n\n****** NO SE ENCONTRARON RESULTADOS ******\n\n");
				}

			} catch (Exception e) {
				System.out.println("\n\n****** ERROR AL BUSCAR LIBROS REGISTRADOS ******\n\n");
				e.printStackTrace();
			}
		}

		private void buscarAutoresRegistrados() {
			try {
				List<AutorDelLibro> autores = autorRepository.findAll();

				if (!autores.isEmpty()) {
					for (AutorDelLibro autor : autores) {
						System.out.println("\n\n********** AUTORES **********\n");
						System.out.println("Nombre: " + autor.getNombre());
						System.out.println("Fecha de Nacimiento: " + autor.getFechaDeNacimiento());
						System.out.println("Fecha de Fallecimiento: " + autor.getFechaDeFallecimiento());
						System.out.println("Libros: " + autor.getLibros());
						System.out.println("\n****************************\n\n");
					}
				} else {
					System.out.println("\n\n****** NO SE ENCONTRARON RESULTADOS ******\n\n");
				}
			} catch (Exception e) {
				System.out.println("\n\n****** ERROR AL BUSCAR AUTORES REGISTRADOS ******\n\n");
				e.printStackTrace();
			}
		}

		private void buscarAutoresVivos() {
			System.out.println("Por favor ingrese el año que desea consultar: ");
			int year = teclado.nextInt();
			teclado.nextLine();

			try {
				List<AutorDelLibro> autores = autorRepository.findForYear(year);

				if (!autores.isEmpty()) {
					for (AutorDelLibro autor : autores) {
						System.out.println("\n\n********** AUTORES VIVOS **********\n");
						System.out.println("Nombre: " + autor.getNombre());
						System.out.println("Fecha de Nacimiento: " + autor.getFechaDeNacimiento());
						System.out.println("\n****************************\n\n");
					}
				} else {
					System.out.println("\n\n****** NO SE ENCONTRARON RESULTADOS ******\n\n");
				}
			} catch (Exception e) {
				System.out.println("\n\n****** ERROR AL BUSCAR AUTORES VIVOS ******\n\n");
				e.printStackTrace();
			}

		}

		private void buscarLibrosPorIdioma() {
			System.out.println("Ingrese el codigo de idioma (ES, EN, FR, PT): ");
			String codigoIdioma = teclado.nextLine();

			try {
				List<LibroDelAutor> libros = libroRepository.findForLanguaje(codigoIdioma);

				if (!libros.isEmpty()) {
					for (LibroDelAutor libro : libros) {
						System.out.println("\n\n********** LIBROS EN " + codigoIdioma + " **********\n");
						System.out.println("Titulo: " + libro.getTitulo());
						System.out.println("Autor: " + libro.getAutor().getNombre());
						System.out.println("Idioma: " + libro.getLenguaje());
						System.out.println("Descargas: " + libro.getDescargas());
						System.out.println("\n****************************\n\n");
					}
				}else {
					System.out.println("\n\n****** NO SE ENCONTRARON RESULTADOS ******\n\n");
				}
			}catch (Exception e) {
				System.out.println("\n\n****** ERROR AL BUSCAR AUTORES VIVOS ******\n\n");
				e.printStackTrace();
			}
		}

	}
}
