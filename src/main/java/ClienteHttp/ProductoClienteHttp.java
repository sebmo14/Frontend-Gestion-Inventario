/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteHttp;

import ApiService.ProductoApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Categoria;
import modelo.Producto;
import modelo.Trabajador;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utilidades.LocalDateAdapter;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author MI PC
 */
public class ProductoClienteHttp {

    Gson gson = new GsonBuilder().registerTypeAdapter(java.time.LocalDate.class, new LocalDateAdapter()).create();
    private static final String BASE_URL = "http://localhost:8080";
    private static ProductoApiService apiService;

    public ProductoClienteHttp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ProductoApiService.class);
    }

    public static List<Producto> listarTodosProductos() {
        try {
            Response<List<Producto>> response = apiService.getAllProductos().execute();
            if (response.isSuccessful()) {
                List<Producto> productos = response.body();
                productos.forEach(producto -> System.out.println(producto.toString()));
                return productos;
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Producto buscarProductoPorId(String id) {
        try {
            Response<Producto> response = apiService.getProductoById(id).execute();
            if (response.isSuccessful()) {
                System.out.println("Producto encontrado: " + response.body());
                return response.body(); // Devuelve el producto encontrado
            } else {
                System.out.println("Producto no encontrado: " + response.code());
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void crearProducto(Producto producto) {
        try {
            Response<Producto> response = apiService.createProducto(producto).execute();
            if (response.isSuccessful()) {
                JOptionPane.showMessageDialog(null, "Producto creado");
                System.out.println("Producto creado: " + response.body());
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear producto");
                System.out.println("Error al crear producto: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean actualizarProducto(String id, String nombre, String descripcion, Categoria categoria, Double precio) {
    try {
        System.out.println("Buscando producto con ID: " + id);
        Producto productoActualizar = ProductoClienteHttp.buscarProductoPorId(id);
        Producto productoAc = ProductoClienteHttp.buscarProductoPorId(id);

        if (productoActualizar == null) {
            System.out.println("Error: No se encontró el producto con ID: " + id);
            return false;
        }

        // Actualizar solo los campos que no están vacíos
        if (nombre != null && !nombre.isEmpty()) {
            productoActualizar.setNombre(nombre);
        } else {
            productoActualizar.setNombre(productoAc.getNombre());
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            productoActualizar.setDescripcion(descripcion);
        } else {
            productoActualizar.setDescripcion(productoAc.getDescripcion());
        }
        if (categoria != null) {
            productoActualizar.setCategoria(categoria);
        } else {
            productoActualizar.setCategoria(productoAc.getCategoria());
        }
        if (precio != null) {
            productoActualizar.setPrecio(precio);
        } else {
            productoActualizar.setPrecio(productoAc.getPrecio());
        }

        System.out.println("Enviando producto actualizado: " + productoActualizar);
        
        try {
            // En lugar de esperar un Producto como respuesta, usamos ResponseBody
            // para manejar cualquier tipo de respuesta o incluso respuesta vacía
            retrofit2.Call<okhttp3.ResponseBody> call = apiService.updateProductoRaw(id, productoActualizar);
            retrofit2.Response<okhttp3.ResponseBody> response = call.execute();
            
            if (response.isSuccessful()) {
                System.out.println("Producto actualizado exitosamente");
                return true;
            } else {
                System.out.println("Error al actualizar producto. Código: " + response.code());
                return false;
            }
        } catch (IOException e) {
            System.out.println("Error de comunicación con la API: " + e.getMessage());
            return false;
        }
    } catch (Exception e) {
        System.out.println("Error inesperado: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}

    public static void eliminarProducto(String id) {
        try {
            Response<Void> response = apiService.deleteProducto(id).execute();
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
