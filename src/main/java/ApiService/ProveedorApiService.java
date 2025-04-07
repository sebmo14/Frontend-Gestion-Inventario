/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ApiService;

import modelo.Categoria;
import modelo.Proveedor;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import okhttp3.ResponseBody;

/**
 *
 * @author MI PC
 */
public interface ProveedorApiService {

    @GET("/api/proveedores")
    Call<List<Proveedor>> getAllProveedores();

    @GET("/api/proveedores/{id}")
    Call<Proveedor> getProveedorById(@Path("id") String id);

    @POST("/api/proveedores")
    Call<Proveedor> createProveedor(@Body Proveedor proveedor);

    @PUT("/api/proveedores/{id}")
    Call<Proveedor> updateProveedor(@Path("id") String id, @Body Proveedor proveedor);

    @PUT("proveedores/{id}")
    Call<ResponseBody> updateProveedorRaw(@Path("id") String id, @Body Proveedor proveedor);

    @DELETE("/api/proveedores/{id}")
    Call<Void> deleteProveedor(@Path("id") String id);
}
