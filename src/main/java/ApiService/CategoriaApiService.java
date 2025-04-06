/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ApiService;

import modelo.Categoria;
import modelo.Trabajador;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 *
 * @author MI PC
 */
public interface CategoriaApiService {
    @GET("/api/categorias")
    Call<List<Categoria>> getAllCategorias();

    @GET("/api/categorias/{id}")
    Call<Categoria> getCategoriaById(@Path("id") String id);

    @POST("/api/categorias")
    Call<Categoria> createCategoria(@Body Categoria categoria);

    @PUT("/api/categorias/{id}")
    Call<Categoria> updateCategoria(@Path("id") String id, @Body Categoria categoria);

    @DELETE("/api/categorias/{id}")
    Call<Void> deleteCategoria(@Path("id") String id);

    @GET("/api/categorias/buscar")
    Call<List<Categoria>> buscarCategorias(
            @Query("nombre") String nombre
    );
}
