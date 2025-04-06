/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteHttp;

import ApiService.TrabajadorApiService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import DTO.LoginRequest;
import modelo.Trabajador;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

import javax.swing.*;

/**
 *
 * @author MI PC
 */
public class TrabajadorClienteHttp {
    private static final String BASE_URL = "http://localhost:8080";
    private static TrabajadorApiService apiService;

    public TrabajadorClienteHttp() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        apiService = retrofit.create(TrabajadorApiService.class);
    }

    public static void listarTodosTrabajadores() {
        try {
            Response<List<Trabajador>> response = apiService.getAllTrabajadores().execute();
            if (response.isSuccessful()) {
                List<Trabajador> trabajadores = response.body();
                trabajadores.forEach(trabajador -> System.out.println(trabajador.toString()));
            } else {
                System.out.println("Error: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscarTrabajadorPorId(Trabajador trabajador) {
        try {
            Response<Trabajador> response = apiService.getTrabajadorById(trabajador.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                System.out.println("Trabajador no encontrado: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearTrabajador(Trabajador trabajador) {
        try {
            Response<Trabajador> response = apiService.createTrabajador(trabajador).execute();
            if (response.isSuccessful()) {
                System.out.println("Trabajador creado: " + response.body());
            } else {
                System.out.println("Error al crear Trabajador: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarTrabajador(Trabajador trabajador) {
        try {
            Response<Trabajador> response = apiService.updateTrabajador(trabajador.getId(), trabajador).execute();
            if (response.isSuccessful()) {
                System.out.println("Trabajador actualizado: " + response.body());
            } else {
                System.out.println("Error al actualizar Trabajador: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarTrabajador(Trabajador trabajador) {
        try {
            Response<Void> response = apiService.deleteTrabajador(trabajador.getId()).execute();
            if (response.isSuccessful()) {
                System.out.println("Trabajador eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar trabajador: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Trabajador login(LoginRequest login) {
        try {
            Response<Trabajador> response = apiService.loginTrabajador(login).execute();
            if (response.isSuccessful()) {
                return response.body();  // Devuelve el trabajador logueado
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
