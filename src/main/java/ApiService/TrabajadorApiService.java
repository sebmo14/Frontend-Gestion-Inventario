/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ApiService;

/**
 *
 * @author MI PC
 */
import DTO.LoginRequest;
import DTO.LoginResponse;
import modelo.Trabajador;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface TrabajadorApiService {
    @GET("/api/trabajadores")
    Call<List<Trabajador>> getAllTrabajadores();

    @GET("/api/trabajadores/{id}")
    Call<Trabajador> getTrabajadorById(@Path("id") Integer id);

    @POST("/api/trabajadores")
    Call<Trabajador> createTrabajador(@Body Trabajador trabajador);

    @PUT("/api/trabajadores/{id}")
    Call<Trabajador> updateTrabajador(@Path("id") Integer id, @Body Trabajador trabajador);

    @DELETE("/api/trabajadores/{id}")
    Call<Void> deleteTrabajador(@Path("id") Integer id);

    @POST("/api/trabajadores/login")
    Call<LoginResponse> loginTrabajador(@Body LoginRequest loginRequest);
    
}
