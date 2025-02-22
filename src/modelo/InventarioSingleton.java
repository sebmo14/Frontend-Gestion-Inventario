/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

public class InventarioSingleton {

    private static InventarioSingleton instancia;

    private List<Producto> productos;
    private List<Categoria> categorias;
    private List<Proveedor> proveedores;
    private List<Trabajador> trabajadores;
    private List<Usuario> usuarios;

    private InventarioSingleton() {
        productos = new ArrayList<>();
        categorias = new ArrayList<>();
        proveedores = new ArrayList<>();
        trabajadores = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public static InventarioSingleton getInstancia() {
        if (instancia == null) {
            instancia = new InventarioSingleton();
        }
        return instancia;
    }

    // ----------------- MÉTODOS PARA PRODUCTOS -----------------
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    public boolean editarProducto(int id, String nuevoNombre, String nuevaDescripcion, Categoria nuevaCategoria, double nuevoPrecio) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setDescripcion(nuevaDescripcion);
            producto.setCategoria(nuevaCategoria);
            producto.setPrecio(nuevoPrecio);
            return true;
        }
        return false;
    }

    // ----------------- MÉTODOS PARA CATEGORÍAS -----------------
    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public List<Categoria> obtenerCategorias() {
        return categorias;
    }

    public Categoria buscarCategoriaPorId(int id) {
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean editarCategoria(int id, String nuevoNombre, String nuevaDescripcion) {
        Categoria categoria = buscarCategoriaPorId(id);
        if (categoria != null) {
            categoria.setNombre(nuevoNombre);
            categoria.setDescripcion(nuevaDescripcion);
            return true;
        }
        return false;
    }

    public void eliminarCategoria(int id) {
        categorias.removeIf(c -> c.getId() == id);
    }

    // ----------------- MÉTODOS PARA PROVEEDORES -----------------
    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public List<Proveedor> obtenerProveedores() {
        return proveedores;
    }

    public Proveedor buscarProveedorPorId(String id) {
        for (Proveedor p : proveedores) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean editarProveedor(String id, String nuevoNombre, String nuevoEmail, String nuevaDireccion, int nuevoNumeroTlf) {
        Proveedor proveedor = buscarProveedorPorId(id);
        if (proveedor != null) {
            proveedor.setNombre(nuevoNombre);
            proveedor.setEmail(nuevoEmail);
            proveedor.setDireccion(nuevaDireccion);
            proveedor.setNumeroTlf(nuevoNumeroTlf);
            return true;
        }
        return false;
    }

    public void eliminarProveedor(String id) {
        proveedores.removeIf(p -> p.getId().equals(id));
    }

    // ----------------- MÉTODOS PARA TRABAJADORES -----------------
    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public List<Trabajador> obtenerTrabajadores() {
        return trabajadores;
    }

    public Trabajador buscarTrabajadorPorId(int id) {
        for (Trabajador t : trabajadores) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public boolean editarTrabajador(int id, double nuevoSalario, int nuevosAñosExp, String nuevoNombre, String nuevosApellidos, int nuevaEdad, String nuevoCorreo, String nuevaContraseña) {
        Trabajador trabajador = buscarTrabajadorPorId(id);
        if (trabajador != null) {
            trabajador.setSalario(nuevoSalario);
            trabajador.setAñosExpe(nuevosAñosExp);
            trabajador.setNombre(nuevoNombre);
            trabajador.setApellidos(nuevosApellidos);
            trabajador.setEdad(nuevaEdad);
            trabajador.setCorreo(nuevoCorreo);
            trabajador.setContraseña(nuevaContraseña);
            return true;
        }
        return false;
    }

    public void eliminarTrabajador(int id) {
        trabajadores.removeIf(t -> t.getId() == id);
    }

    // ----------------- MÉTODOS PARA USUARIOS -----------------
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public boolean editarUsuario(int id, String nuevoNombre, String nuevosApellidos, int nuevaEdad, String nuevoCorreo, String nuevaContraseña) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            usuario.setNombre(nuevoNombre);
            usuario.setApellidos(nuevosApellidos);
            usuario.setEdad(nuevaEdad);
            usuario.setCorreo(nuevoCorreo);
            usuario.setContraseña(nuevaContraseña);
            return true;
        }
        return false;
    }

    public void eliminarUsuario(int id) {
        usuarios.removeIf(u -> u.getId() == id);
    }

}
