package org.examen;

public class Constructor {
    private int constructorId;
    private String constructorRef;
    private String nombre;
    private String nacionalidad;
    private String url;

    public Constructor(int constructorId, String constructorRef, String nombre, String nacionalidad, String url) {
        this.constructorId = constructorId;
        this.constructorRef = constructorRef;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.url = url;
    }

    public Constructor(String constructorRef, String nombre, String nacionalidad, String url) {
        this.constructorRef = constructorRef;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.url = url;
    }

    public int getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(int constructorId) {
        this.constructorId = constructorId;
    }

    public String getConstructorRef() {
        return constructorRef;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "constructorRef='" + constructorRef + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
