package org.examen;

import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://database-1.cqpbkpjgxsg8.us-east-1.rds.amazonaws.com:5432/f12006";
        String user = "postgres";
        String password = "12345678";

        Constructor seat = new Constructor("seatf1", "SeatF1", "Spanish", "https://en.wikipedia.org/wiki/Seat");
        Piloto carlosSainz = new Piloto("SAI", "Carlos", "Sainz", LocalDate.of(1994, 9, 1), "Spanish", "https://en.wikipedia.org/wiki/Carlos_Sainz_Jr.", seat);
        Piloto manuelAloma = new Piloto("ALO", "Manuel", "Alomá", LocalDate.of(1981, 7, 29), "Spanish", "https://en.wikipedia.org/wiki/Fernando_Alonso", seat);

        try(Connection conexion = DriverManager.getConnection(url, user, password)){
            try{
//            conexion.setAutoCommit(false);
//
//            String insertarEquipo = "INSERT INTO constructors(constructorref, name, nationality, url) VALUES(?, ?, ?, ?) " +
//                    "ON CONFLICT (constructorid) DO NOTHING";
//            PreparedStatement sentencia = conexion.prepareStatement(insertarEquipo, PreparedStatement.RETURN_GENERATED_KEYS);
//            sentencia.setString(1, seat.getConstructorRef());
//            sentencia.setString(2, seat.getNombre());
//            sentencia.setString(3, seat.getNacionalidad());
//            sentencia.setString(4, seat.getUrl());
//
//            sentencia.executeUpdate();
//
//            ResultSet resultado = sentencia.getGeneratedKeys();
//            resultado.next();
//            carlosSainz.getEquipo().setConstructorId(resultado.getInt(1));
//            manuelAloma.getEquipo().setConstructorId(resultado.getInt(1));
//            System.out.println("El id del equipo es: " + carlosSainz.getEquipo().getConstructorId());
//
//            String insertarPiloto1 = "INSERT INTO drivers(code, forename, surname, dob, nationality, url, constructorId) VALUES(?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement sentencia2 = conexion.prepareStatement(insertarPiloto1);
//            sentencia2.setString(1, carlosSainz.getCodigo());
//            sentencia2.setString(2, carlosSainz.getNombre());
//            sentencia2.setString(3, carlosSainz.getApellido());
//            sentencia2.setDate(4, Date.valueOf(carlosSainz.getFechaNacimiento()));
//            sentencia2.setString(5, carlosSainz.getNacionalidad());
//            sentencia2.setString(6, carlosSainz.getUrl());
//            sentencia2.setInt(7, carlosSainz.getEquipo().getConstructorId());
//
//            sentencia2.executeUpdate();
//
//            String insertarPiloto2 ="INSERT INTO drivers(code, forename, surname, dob, nationality, url, constructorId) VALUES(?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement sentencia3 = conexion.prepareStatement(insertarPiloto2);
//            sentencia3.setString(1, manuelAloma.getCodigo());
//            sentencia3.setString(2, manuelAloma.getNombre());
//            sentencia3.setString(3, manuelAloma.getApellido());
//            sentencia3.setDate(4, Date.valueOf(manuelAloma.getFechaNacimiento()));
//            sentencia3.setString(5, manuelAloma.getNacionalidad());
//            sentencia3.setString(6, manuelAloma.getUrl());
//            sentencia3.setInt(7, manuelAloma.getEquipo().getConstructorId());
//
//            sentencia3.executeUpdate();
//
//            conexion.commit();
//            conexion.setAutoCommit(true);

            CallableStatement resultadosPiloto = conexion.prepareCall("{call get_results_by_driver(?)}");
            resultadosPiloto.setString(1, "ALO");
            resultadosPiloto.execute();
            ResultSet resultados = resultadosPiloto.getResultSet();
                System.out.println("Resultados:");
                while (resultados.next()){
                    System.out.print("CIRCUITO:"+resultados.getString("circuit"));
                    System.out.println(" POSICION: "+resultados.getInt("result"));
                }

                System.out.println();

            CallableStatement clasificacionFinal = conexion.prepareCall("{call get_drivers_standings()}");
            clasificacionFinal.execute();
            ResultSet clasificacion = clasificacionFinal.getResultSet();
            System.out.println("Clasificacion final:");
            while (clasificacion.next()){
                System.out.print("PILOTO:"+clasificacion.getString("driver"));
                System.out.println(" PUNTOS: "+clasificacion.getInt("points"));
            }

        }catch (SQLException ex1) {
            System.err.println(ex1.getClass().getName() + ": " + ex1.getMessage());
            try {
                conexion.rollback();
                System.err.println("ROLLBACK ejecutado");
            } catch (SQLException ex2) {
                System.err.println("Error haciendo ROLLBACK");
            }
        }
    } catch (SQLException ex) {
        System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
    }

    }
}