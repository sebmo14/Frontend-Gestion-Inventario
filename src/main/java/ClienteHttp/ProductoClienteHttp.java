/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteHttp;

import ApiService.ProductoApiService;
import modelo.Producto;
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
public class ProductoClienteHttp {
    private static final String BASE_URL = "http://localhost:8080";
    private static ProductoApiService apiService;

    public ProductoClienteHttp() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        apiService = retrofit.create(ProductoApiService.class);
    }

    public static void listarTodosProductos() {
        try {
            Response<List<Producto>> response = apiService.getAllProductos().execute();
            if (response.isSuccessful()) {
                List<Producto> productos = response.body();
                productos.forEach(producto -> System.out.println(producto.toString()));
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscarProductoPorId(Producto producto) {
        try {
            Response<Producto> response = apiService.getProductoById(producto.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                System.out.println("Producto no encontrado: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearProducto(Producto producto) {
        try {
            Response<Producto> response = apiService.createProducto(producto).execute();
            if (response.isSuccessful()) {
                System.out.println("Producto creado: " + response.body());
            } else {
                System.out.println("Error al crear producto: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarProducto(Producto producto) {
        try {
            Response<Producto> response = apiService.updateProducto(producto.getId(), producto).execute();
            if (response.isSuccessful()) {
                System.out.println("Producto actualizado: " + response.body());
            } else {
                System.out.println("Error al actualizar producto: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarProducto(Producto producto) {
        try {
            Response<Void> response = apiService.deleteProducto(producto.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println("Producto eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar producto: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
