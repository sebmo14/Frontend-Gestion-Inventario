/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteHttp;

import ApiService.ProveedorApiService;
import modelo.Proveedor;
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
public class ProveedorClienteHttp {
    private static final String BASE_URL = "http://localhost:8080";
    private static ProveedorApiService apiService;

    public ProveedorClienteHttp() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        apiService = retrofit.create(ProveedorApiService.class);
    }

    private static void listarTodosProveedores() {
        try {
            Response<List<Proveedor>> response = apiService.getAllProveedores().execute();
            if (response.isSuccessful()) {
                List<Proveedor> proveedores = response.body();
                proveedores.forEach(proveedor -> System.out.println(proveedor.toString()));
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void buscarProveedorPorId(Proveedor proveedor) {
        try {
            Response<Proveedor> response = apiService.getProveedorById(proveedor.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                System.out.println("Proveedor no encontrado: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void crearProveedor(Proveedor proveedor) {
        try {
            Response<Proveedor> response = apiService.createProveedor(proveedor).execute();
            if (response.isSuccessful()) {
                System.out.println("Proveedor creado: " + response.body());
            } else {
                System.out.println("Error al crear proveedor: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void actualizarProveedor(Proveedor proveedor) {
        try {
            Response<Proveedor> response = apiService.updateProveedor(proveedor.getId(), proveedor).execute();
            if (response.isSuccessful()) {
                System.out.println("Proveedor actualizado: " + response.body());
            } else {
                System.out.println("Error al actualizar proveedor: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void eliminarProveedor(Proveedor proveedor) {
        try {
            Response<Void> response = apiService.deleteProveedor(proveedor.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println("Proveedor eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar proveedor: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
