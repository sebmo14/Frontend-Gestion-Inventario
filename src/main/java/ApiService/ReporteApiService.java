/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ApiService;

import modelo.Categoria;
import modelo.Reporte;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 *
 * @author MI PC
 */
public interface ReporteApiService {
    @GET("/api/reportes")
    Call<List<Reporte>> getAllReportes();

    @GET("/api/reportes/{id}")
    Call<Reporte> getReporteById(@Path("id") String id);

    @POST("/api/reportes")
    Call<Reporte> createReporte(@Body Reporte reporte);

    @PUT("/api/reportes/{id}")
    Call<Reporte> updateReporte(@Path("id") String id, @Body Reporte reporte);

    @DELETE("/api/reportes/{id}")
    Call<Void> deleteReporte(@Path("id") String id);
}
