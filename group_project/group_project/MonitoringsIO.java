package group_project;
/**
 *
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.lang.NumberFormatException;
import java.util.Scanner;
import java.sql.*;



public class MonitoringsIO{
    static Connection con;
    static Statement st;
    static ResultSet rs;

    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    final static String USER = "root";
    final static String PASS = "";

    /**
     * Creating an instance of the Monitoring class.
     */
    static Monitoring Nasa = new Monitoring();


    public static void addToDb(Observatory nasa){
        try {

            /**
             * Writing the inputs into the tables of the databasee.
             */

            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DB_URL, USER, PASS);

            st = con.createStatement();

            String sql = "insert into Monitoring "
                    + " (obs_name, country, year_started, area_covered)"
                    + " values ('"+nasa.getName()+"', '"+nasa.getCountry()+"', '"+nasa.getYear_started()+"'," +
                    " '"+nasa.getArea_size()+"')";
            st.executeUpdate(sql);
            // Creating connection with the database and putting the inputs into the Monitoring database table
            Nasa.addObservatory(nasa);
            System.out.println("Input recorded!");
        }catch(Exception se){
            se.printStackTrace();
        }
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String choice = "";

        while(choice != "4"){
            System.out.println("---MAIN MENU---\nType 1 to Enter Observatory data: \nType 2 to Enter Galamsey data : \nType 3 to provide monitoring statistics: \nType 4 to exit");

            choice = s.nextLine();

            switch (choice) {
                case "1":
                    try {
                        //Collecting data from the user.
                        System.out.println("Name of observatory: ");
                        String name = s.nextLine();

                        System.out.println("Enter country of operation: ");
                        String location = s.nextLine();

                        System.out.println("Enter year galamsey operations began (YYYY-MM-DD): ");
                        String yr = s.nextLine();
//                          String year = s.nextLine();
//                          int yr = Integer.parseInt(year);

                        System.out.println("Enter area covered by the observatory (in square kilometers): ");
                        double c = Double.parseDouble(s.nextLine());

                        System.out.println();
                        // System.out.println("List of 'galamsey' events recorded: ");
                        Observatory newEvent = new Observatory(name, location, yr, c);
                        addToDb(newEvent);

//
                        break;
                    }
                    catch (NumberFormatException a){
                        System.out.println("Wrong Input");
                        System.out.println();
                        break;
                    }

                case "2":
                    try {
                        //Collecting data from the user

                        System.out.println("Enter vegetation colour: ");
                        String colour = s.nextLine();

                        System.out.println("Enter position (Latitude and Longitude (eg: 5.603 N, 0.187 W))");
                        String position = s.nextLine();


                        System.out.println("Enter year of event (YYYY-MM-DD): ");
                        String yr = s.nextLine();

                        // Creating connection with database and inputing the records
                        Connection myConn = null;
                        Statement myStmt = null; //We can also used PreparedStatement


                        try {
                            Class.forName(JDBC_DRIVER);

                            myConn = DriverManager.getConnection(DB_URL, USER, PASS);

                            myStmt = myConn.createStatement();

                            String sql = "insert into Observatory "
                                    + " (veg_color, position, col_value, year)"
                                    + " values ('"+colour+"', '"+position+"', '"+yr+"')";


                            myStmt.executeUpdate(sql);
                        }catch(Exception se){
                            se.printStackTrace();
                        }

                        /**
                         *Creating a galamsey event and putting it into
                         *the ArrayList of the Observatory created
                         *
                         * */
                        Nasa.getObservatories().get(Nasa.getObservatories().size()-1).addGalamseyEvents(new Galamsey(colour, position, yr));
                        System.out.println("Input recorded!");
                        // System.out.println(Nasa.getObservatories().get(Nasa.getObservatories().size()-1).galamseyAboveValueOf(0));
//
//                            private Galamsey gala = new Galamsey(colour, positon, cv);
//                            Observatory.addObservatories(gala);
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Invalid Input");
                        System.out.println();
                        break;
                    }
                case "3":
                    try {
                        System.out.println("Enter 1 to calculate the largest average galamsey value\n"
                                + "Enter 2 to calculate the largest 'galamsey' ever recorded\n"
                                + "Enter 3 to get All 'galamsey' with colour value greater than certain threshold value");
                        String in = s.nextLine();
                        switch(in) {
                            case "1":
                                System.out.println("The largest average recorded is: "+ Nasa.getLargestAverageGalamseyValue());
                            case "2":
                                System.out.println("The largest Galamsey color value ever record is: "+Nasa.largestGalamseyValueEverRecord());
                            case "3":
                                try {
                                    System.out.println("Enter the Threshold: \n");
                                    int i = s.nextInt();
                                    System.out.println("The Galamsey Activities above the threshold are:"
                                            + "----------------------------------------\n"+
                                            Nasa.getAllGalamseyActAboveValueof(i));


                                }catch(Exception e) {
                                    System.out.println("Invalid Input");
                                    System.out.println();
                                    break;
                                }
                            default:
                                System.out.println("Invalid Input");
                                System.out.println();
                                break;
                        }
                    }catch(Exception e) {
                        System.out.println("Invalid Input");
                        System.out.println();
                        break;
                    }
//                        System.out.println("The largest average 'galamsey': ");
//                        System.out.println("Largest 'galamsey' ever recorded: ");
//                        System.out.println("All 'galamsey' with colour value greater than ...");
                    break;

                case "4":
                    // Writing the inputs into csv files
                    Connection myConn = null;
                    PreparedStatement myStmt = null;

                    try {

                        PrintWriter pw = new PrintWriter(new File("C:\\Users\\Robert-William Evans\\Desktop\\Monitoring.csv"));
                        PrintWriter pw1 = new PrintWriter(new File("C:\\Users\\Robert-William Evans\\Desktop\\Observatory.csv"));
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb1 = new StringBuilder();


                        Class.forName(JDBC_DRIVER);

                        myConn = DriverManager.getConnection(DB_URL, USER, PASS);

                        ResultSet rs = null;

                        String query = "Select * from Monitoring";
                        myStmt = myConn.prepareStatement(query);
                        rs = myStmt.executeQuery();

                        while (rs.next()) {
                            sb.append(rs.getString("id"));
                            sb.append(",");
                            sb.append(rs.getString("obs_name"));
                            sb.append(",");
                            sb.append(rs.getString("country"));
                            sb.append(",");
                            sb.append(rs.getString("year_started"));
                            sb.append(",");
                            sb.append(rs.getString("area_covered"));
                            sb.append("\r\n");
                        }

                        pw.write(sb.toString());
                        pw.close();

                        ResultSet rs1 = null;
                        String query1 = "Select * from Observatory";
                        myStmt = myConn.prepareStatement(query1);
                        rs1 = myStmt.executeQuery();

                        while (rs1.next()) {
                            sb1.append(rs1.getString("id"));
                            sb1.append(",");
                            sb1.append(rs1.getString("veg_color"));
                            sb1.append(",");
                            sb1.append(rs1.getString("position"));
                            sb1.append(",");
                            sb1.append(rs1.getString("col_value"));
                            sb1.append(",");
                            sb1.append(rs1.getString("year"));
                            sb1.append("\r\n");
                        }

                        pw1.write(sb1.toString());
                        pw1.close();
                        System.out.println("Finished!");
                    }catch(Exception e) {
                        e.printStackTrace();
                    }

                    System.exit(0);

                default:
                    System.out.println("Invalid Input");
                    System.out.println();
                    break;
            }
        }
    }

    public static class Controller {
        @FXML
        private Button add_gal, add_obs, stats, obsStats;

        public void gal_add(ActionEvent actionEvent) throws IOException {
            Parent newScreen = FXMLLoader.load(getClass().getResource("galamPage.fxml"));
            Scene scene = new Scene(newScreen);
            Stage stage2 = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage2.setScene(scene);
            stage2.show();

        }

        public void obs_add(ActionEvent actionEvent) throws IOException {
            Parent newScreen = FXMLLoader.load(getClass().getResource("ObservePage.fxml"));
            Scene scene = new Scene(newScreen);
            Stage stage2 = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage2.setScene(scene);
            stage2.show();
        }

        public void show_stats(ActionEvent actionEvent) throws IOException {
            Parent newScreen = FXMLLoader.load(getClass().getResource("statsView.fxml"));
            Scene scene = new Scene(newScreen);
            Stage stage2 = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage2.setScene(scene);
            stage2.show();
        }

        public void show_Obsstats(ActionEvent actionEvent) throws IOException {
            Parent newScreen = FXMLLoader.load(getClass().getResource("obsTable.fxml"));
            Scene scene = new Scene(newScreen);
            Stage stage2 = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage2.setScene(scene);
            stage2.show();
        }
    }
}