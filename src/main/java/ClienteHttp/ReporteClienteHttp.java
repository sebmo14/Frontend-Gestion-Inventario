/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteHttp;

import ApiService.ReporteApiService;
import modelo.Reporte;
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
public class ReporteClienteHttp {
    private static final String BASE_URL = "https://gestioninventario-boot.onrender.com";
    private static ReporteApiService apiService;

    public ReporteClienteHttp() {
         Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        apiService = retrofit.create(ReporteApiService.class);
    }

    public static void listarTodosReportes() {
        try {
            Response<List<Reporte>> response = apiService.getAllReportes().execute();
            if (response.isSuccessful()) {
                List<Reporte> reportes = response.body();
                reportes.forEach(reporte -> System.out.println(reporte.toString()));
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscarReportePorId(Reporte reporte) {
        try {
            Response<Reporte> response = apiService.getReporteById(reporte.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                System.out.println("Reporte no encontrado: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearReporte(Reporte reporte) {
        try {
            Response<Reporte> response = apiService.createReporte(reporte).execute();
            if (response.isSuccessful()) {
                System.out.println("Reporte creado: " + response.body());
            } else {
                System.out.println("Error al crear reporte: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarReporte(Reporte reporte) {
        try {
            Response<Reporte> response = apiService.updateReporte(reporte.getId(), reporte).execute();
            if (response.isSuccessful()) {
                System.out.println("Reporte actualizado: " + response.body());
            } else {
                System.out.println("Error al actualizar reporte: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarReporte(Reporte reporte) {
        try {
            Response<Void> response = apiService.deleteReporte(reporte.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println("Reporte eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar reporte: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
