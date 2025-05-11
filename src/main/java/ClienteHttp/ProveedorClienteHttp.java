/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteHttp;

import ApiService.ProveedorApiService;
import modelo.Proveedor;
import excepciones.CampoVacioExcepcion;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

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

    public static List<Proveedor> listarTodosProveedores() {
        try {
            Response<List<Proveedor>> response = apiService.getAllProveedores().execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Proveedor buscarProveedorPorId(Integer id) {
        try {
            Response<Proveedor> response = apiService.getProveedorById(id).execute();
            Proveedor proveedor = response.body();
            if (response.isSuccessful()) {

                return proveedor;
            } else {
                System.out.println("Proveedor no encontrado: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void crearProveedor(Proveedor proveedor) throws CampoVacioExcepcion {
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

    public static boolean actualizarProveedor(Integer id, String nombre, String email, String direccion, int numTlf) {
        try {
            Proveedor proveedor = new Proveedor(nombre, email, direccion, numTlf);
            Proveedor proveedorOg = buscarProveedorPorId(id);
            
            proveedor.setId(id);
            
            if (nombre != null && !nombre.isEmpty()) {
                proveedor.setNombre(nombre);
            } else {
                proveedor.setNombre(proveedorOg.getNombre());

            }
            if (email != null && !email.isEmpty()) {
                proveedor.setEmail(email);
            } else {
                proveedor.setEmail(proveedorOg.getEmail());

            }
            if (direccion != null && !direccion.isEmpty()) {
                proveedor.setDireccion(direccion);
            } else {
                proveedor.setDireccion(proveedorOg.getDireccion());

            }
            if (!(numTlf == 0)) {
                proveedor.setDireccion(email);
            } else {
                proveedor.setNumeroTlf(proveedorOg.getNumeroTlf());

            }

            Response<Proveedor> response = apiService.updateProveedor(proveedor.getId(), proveedor).execute();
            if (response.isSuccessful()) {
                System.out.println("Proveedor actualizado: " + response.body());
                return true;
            } else {
                System.out.println("Error al actualizar proveedor: " + response.code());
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void eliminarProveedor(Integer id) {
        try {
            Response<Void> response = apiService.deleteProveedor(id).execute();
            if (response.isSuccessful()) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado con exito");
                System.out.println("Proveedor eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar proveedor");
                System.out.println("Error al eliminar proveedor: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
