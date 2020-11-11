package sample;

import Pez.Pez;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    Pez[] arreglopez = new Pez[5];

    ObservableList<String> lista_peces
            = FXCollections.observableArrayList("Huachinango","Salmon","Robalo","Atun","Trucha","Carpa");

    @FXML ComboBox<String> combopez;
    @FXML TextField tpornacimiento;
    @FXML ListView<String> listapeces;
    int contador=0;

    public void agregar(Event event){
        combopez.setItems(lista_peces);
    }

    public void insertar(Event event){
        if(contador<5){
            int x = Integer.parseInt(tpornacimiento.getText());
            arreglopez[contador] = new
                    Pez(combopez.getSelectionModel().getSelectedItem().toString(),x);
            contador++;
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setContentText("Solo se permiten 5 pescas"); alerta.show();
        }
        tpornacimiento.setText("");

    }

    public void procesar(Event event){

        if (arreglopez[4]!=null){
            for (int x=0;x<arreglopez.length;x++){
            String dato = "Pescado "+arreglopez[x].getTipo_pez()+
                    " nacen "+arreglopez[x].getPor_nacimiento()+" por cria y " +
                    arreglopez[x].al_anio() +" al año";
            listapeces.getItems().add(x,dato);
            }
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setContentText("Favor de llenar las 5 pescas"); alerta.show();}

    }



}