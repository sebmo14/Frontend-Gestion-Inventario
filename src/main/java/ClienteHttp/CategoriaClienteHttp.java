/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteHttp;

import ApiService.CategoriaApiService;
import modelo.Categoria;
import modelo.Trabajador;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author MI PC
 */
public class CategoriaClienteHttp {
    private static final String BASE_URL = "http://localhost:8080";
    private static CategoriaApiService apiService;

    public CategoriaClienteHttp() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        apiService = retrofit.create(CategoriaApiService.class);
    }

    public static void listarTodosCategorias() {
        try {
            Response<List<Categoria>> response = apiService.getAllCategorias().execute();
            if (response.isSuccessful()) {
                List<Categoria> categorias = response.body();
                categorias.forEach(categoria -> System.out.println(categoria.toString()));
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscarCategoriaPorId(Categoria categoria) {
        try {
            Response<Categoria> response = apiService.getCategoriaById(categoria.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                System.out.println("Categoria no encontrada: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearCategoria(Categoria categoria) {
        try {
            Response<Categoria> response = apiService.createCategoria(categoria).execute();
            if (response.isSuccessful()) {
                System.out.println("Categoria creado: " + response.body());
            } else {
                System.out.println("Error al crear categoria: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarCategoria(Categoria categoria) {
        try {
            Response<Categoria> response = apiService.updateCategoria(categoria.getId(), categoria).execute();
            if (response.isSuccessful()) {
                System.out.println("Categoria actualizado: " + response.body());
            } else {
                System.out.println("Error al actualizar categoria: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarCategoria(Categoria categoria) {
        try {
            Response<Void> response = apiService.deleteCategoria(categoria.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println("Categoria eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar categoria: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscarCategoriaPorFiltros(String nombre) {
        try {
            Response<List<Categoria>> response = apiService.buscarCategorias(nombre).execute();
            if (response.isSuccessful()) {
                response.body().forEach(categoria -> System.out.println(categoria.toString()));
            } else {
                System.out.println("Error al buscar categorias: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
