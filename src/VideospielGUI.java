import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;



public class VideospielGUI extends JFrame {
    private JPanel frame;
    private JTextField genreField;
    private JTextField altersfreigabeField;
    private JCheckBox istMultiplayer1;
    private JButton speichernButton;
    private JTextField filterField;
    private JComboBox sortierenBox;
    private JTextField preisField;
    private JTable ausgabetable;
    private JButton filternButton;
    private JButton sortierenButton;
    private JTextField titelField;
    private JButton berechneButton;
    private JTextArea ausgabeArea;
    private ArrayList<Spiel> spieleListe;
    private DefaultTableModel table;


    public VideospielGUI() {
        spieleListe = new ArrayList<>();
        setTitle("Videospiele");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setContentPane(frame);
        setVisible(true);
        table = new DefaultTableModel(
                new Object[]{ "Titel:","Genre:", "Altersfreigabe:", "Multiplayer:", "Preis:"}, 0
        );
        ausgabetable.setModel(table);


        //Einfügen von Standardspielen im Table
        initObjekte();


        //Sortieroptionen zur ComboBox hinzufügen
        sortierenBox.addItem("Titel");
        sortierenBox.addItem("Genre");
        sortierenBox.addItem("Altersfreigabe");
        sortierenBox.addItem("Multiplayer");
        sortierenBox.addItem("Preis");


        //Button für Speichern des Spiels
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String titel = titelField.getText();
                String genre = genreField.getText();
                boolean istMultiplayer = istMultiplayer1.isSelected();


                //Catch Funktion
                try {

                    if (titel.isEmpty()) {
                        throw new Exception("Titel darf nicht leer sein!");}
                    if (genre.isEmpty()) throw new Exception("Genre darf nicht leer sein!");
                    if (enthaeltZahlen(genre)) throw new Exception("Genre darf keine Zahlen enthalten!");
                    if (altersfreigabeField.getText().isEmpty())
                        throw new Exception("Altersfreigabe darf nicht leer sein");
                    if (preisField.getText().isEmpty()) throw new Exception("Preis darf nicht leer sein");

                    int altersfreigabe = (int) Double.parseDouble(altersfreigabeField.getText());
                    double preis = Double.parseDouble(preisField.getText());

                    String janein;

                    if (istMultiplayer == true) {
                        janein = "Ja";
                    } else {
                        janein = "Nein";
                    }

                    table.addRow(new Object[]{titel, genre, altersfreigabe, janein, preis});
                    titelField.setText("");
                    genreField.setText("");
                    altersfreigabeField.setText("");
                    istMultiplayer1.setSelected(false);
                    preisField.setText("");

                    Spiel spiel = new Spiel(titel, genre, altersfreigabe, istMultiplayer, preis);
                    spieleListe.add(spiel);
                    JOptionPane.showMessageDialog(frame, "Spiel wurde erfolgreich erstellt!");
                    ausgabeArea.setText("Spiel wurde gespeichert!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,"Fehlerhafte Eingabe: Altersfreigabe und Preis müssen Zahlen sein!");
                    ausgabeArea.setText("Überprüfen Sie ihre Eingabe!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame,ex.getMessage());
                    ausgabeArea.setText("Überprüfen Sie ihre Eingabe!");}
                }
        });


        //Button für Sortieren
        sortierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sortieren = sortierenBox.getSelectedItem().toString();
                switch (sortieren) {
                    case "Genre" : spieleListe.sort(Comparator.comparing(Spiel::getGenre));
                    refresh();break;
                    case "Altersfreigabe" : spieleListe.sort(Comparator.comparing(Spiel::getAltersfreigabe));
                        refresh();break;
                    case "Multiplayer" : spieleListe.sort(Comparator.comparing(Spiel::isistMultiplayer));
                        refresh(); break;
                    case "Preis" : spieleListe.sort(Comparator.comparing(Spiel::getPreis));
                        refresh(); break;
                    case "Titel" : spieleListe.sort(Comparator.comparing(Spiel::getTitel)); refresh(); break;
                }
            }
        });

        //Button um zu Filtern
        filternButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterSpiele();
            }
        });

        //Button um Gesamtpreis zu berechnen
        berechneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double summe = gesamtpreis();
            ausgabeArea.setText("Der Gesamtpreis aller Spiele ist: " + String.valueOf(summe) + "€");
            }
        });
    }


    //Erstellung von GUI


//Methode für das Einfügen von Standartspielen
    private void initObjekte() {
        spieleListe.addAll(Spiel.standartspiele());
        for (Spiel t : spieleListe) {
            boolean istMultiplayer = t.isistMultiplayer();
            String janein;

            if (istMultiplayer == true) {
                janein = "Ja";
            } else {
                janein = "Nein";
            }

            table.addRow(new Object[]{
                    t.getTitel(),
                    t.getGenre(),
                    t.getAltersfreigabe(),
                    janein,
                    t.getPreis()
            });
        }
    }

//Methode um den Table "neu zu laden"
    private void refresh() {
        table.setRowCount(0);
        for (Spiel t : spieleListe) {
            boolean istMultiplayer = t.isistMultiplayer();
            String janein;

            if (istMultiplayer == true) {
                janein = "Ja";
            } else {
                janein = "Nein";
            }

            table.addRow(new Object[]{
                    t.getTitel(),
                    t.getGenre(),
                    t.getAltersfreigabe(),
                    janein,
                    t.getPreis()
            });
        }
    }


    //Methode um zu Filtern
    public void filterSpiele() {
        String filter = filterField.getText().toLowerCase().trim();
        table.setRowCount(0);

        for (Spiel t : spieleListe) {
            String janein;
            if (t.isistMultiplayer() == true) {
                janein = "Ja";
            } else {
                janein = "Nein";
            }

            String suchtext = t.getTitel() + " " + t.getGenre() + " " +
                    t.getAltersfreigabe() + " " + janein + " " + t.getPreis();

            if (suchtext.toLowerCase().contains(filter)) {
                table.addRow(new Object[]{
                        t.getTitel(), t.getGenre(), t.getAltersfreigabe(), janein, t.getPreis()
                });
            }
        }
    }


    //Methode zur Berechnung des Gesamtpreises
    public double gesamtpreis() {
        double gesamt = 0;
        for (Spiel t : spieleListe) {
            gesamt += t.getPreis();
        }   return gesamt;
    }
//Methode um zu überprüfen ob im Textfeld Zahlen vorhanden sind
    private boolean enthaeltZahlen(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}