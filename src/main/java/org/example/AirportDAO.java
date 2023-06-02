package org.example;
import java.sql.*;
import java.util.ArrayList;
public class AirportDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/db";

    //CRUD create read update delete
    public static void create(Airport oUstas) {
        String query = "INSERT INTO `sb_airport`( `biz_name`, `address`, `city`) VALUES " + "(?,?,?)";
        try {
            // sukuriamas prisijungimas prie duomenų bazės
            Connection connection = DriverManager.getConnection(URL, "root", "");
            //sukuriama paruošiamuoji užklausa DB
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, oUstas.getBizName());
            statement.setString(2, oUstas.getAddress());
            statement.setString(3, oUstas.getCity());

            // įvykdoma užklausa DB executeUpdate naudojamas sukuriant naują įrašą, redaguojant esamą ir trinimui
            // norint atlikri paiešką reikia naudoti metodą executeQuery
            statement.executeUpdate();
            System.out.println("Pavyko");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Įvyko klaida kuriant naują įrašą DB. Plačiau: " + e.getMessage());
        }
    }

    public static ArrayList<Airport> searchByAirportName(String name) {
        String query = "SELECT * FROM `sb_airport` WHERE `biz_name`LIKE '" + name + "'";
        ArrayList<Airport> oUstai = new ArrayList<>();
        Connection connection = null;
        try {
            // sukuriamas prisijungimas prie duomenų bazės
            connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);
              while (resultSet.next()) {
                //išsitraukiame iš resultSet reikšmes pagal stulpelio pavadinimo (esančio DB)
                int bizId = resultSet.getInt("biz-id");
                String bizName = resultSet.getString("biz_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                oUstai.add((new Airport(bizId, bizName, address, city)));

            }
            statement.close();
            connection.close();
            System.out.println("Pavyko");
        } catch (SQLException e) {
            System.out.println("Įvyko klaida. Plačiau: " + e.getMessage());
        }
        return oUstai;
    }

    public static void update(Airport uostas) {
        String query = "UPDATE `sb_airport` SET `biz_name`= ?,`address`= ?,`city`= ? WHERE `biz-id`= ?";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, uostas.getBizName());
            statement.setString(2, uostas.getAddress());
            statement.setString(3, uostas.getCity());
            statement.setInt(4, uostas.getBizId());
            statement.executeUpdate();
            System.out.println("Pavyko updatinti");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Įvyko klaida keičiant duomenys. Plačiau: " + e.getMessage());

        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM `sb_airport` WHERE `biz-id`= ?";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Pavyko ištrinti");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ištrinti nepavyko. Plačiau" + e.getMessage());
        }

    }
}