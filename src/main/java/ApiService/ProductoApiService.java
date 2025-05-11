/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ApiService;

import modelo.Categoria;
import modelo.Producto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import okhttp3.ResponseBody;

/**
 *
 * @author MI PC
 */
public interface ProductoApiService {

    @GET("/api/productos")
    Call<List<Producto>> getAllProductos();

    @GET("/api/productos/{id}")
    Call<Producto> getProductoById(@Path("id") Integer id);

    @POST("/api/productos")
    Call<Producto> createProducto(@Body Producto producto);

    @PUT("/api/productos/{id}")
    Call<Producto> updateProducto(@Path("id") Integer id, @Body Producto producto);

    @PUT("/api/productos/{id}")
    Call<ResponseBody> updateProductoRaw(@Path("id") Integer id, @Body Producto producto);

    @DELETE("/api/productos/{id}")
    Call<Void> deleteProducto(@Path("id") Integer id);
}
