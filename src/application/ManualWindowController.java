package application;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ManualWindowController {
	
	@FXML
    private Label labelActualDoc;

    @FXML
    private Button searchDoc;

    @FXML
    private Label labelPath;

    @FXML
    private ImageView imageActualDoc;

    @FXML
    private Label labelKeywords;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label labelDate;

    @FXML
    private Label labelKeywordOne;

    @FXML
    private Label labelKeywordTwo;

    @FXML
    private Label labelKeywordtThree;

    @FXML
    private Label labelKeywordFour;

    @FXML
    private Label labelKeywordFive;

    @FXML
    private Button save;

    @FXML
    private ComboBox<?> listKeywordOne;

    @FXML
    private ComboBox<?> listKeywordTwo;

    @FXML
    private ComboBox<?> listKeywordThree;

    @FXML
    private ComboBox<?> listKeywordFour;

    @FXML
    private ComboBox<?> listKeywordFive;

    @FXML
    private Button zoomPlus;

    @FXML
    private Button zoomMinus;
    
    @FXML
	public void handleSearchDoc() {
		/**
		 * Kk 170223 KK, CB 170224 Dialog zur Dateiauswahl aufrufen *erledigt
		 * Dateiname im Label anzeigen *erledigt ausgewählte Datei im Image
		 * anzeigen
		 */
		// noch fest codiert, wenn wir eine Datenbankanbindung haben sollte
		// hier der Wert von config.rootDir
		File sourceDir = new File("C:");
		// vordefinierte Klasse zur Dateiauswahl
		FileChooser fileChooser = new FileChooser();
		// grundkonfiguration
		fileChooser.setTitle("Bitte gewünschte Datei auswählen");
		fileChooser.setInitialDirectory(sourceDir);
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
				new ExtensionFilter("Text Files", "*.txt", "*.pdf"), new ExtensionFilter("All Files", "*.*"));

		// das wird unsere Datei
		File myFile;
		// file wird gelesen
		// myFile=fileChooser.showOpenDialog(main.getPrimarayStage());
		myFile = fileChooser.showOpenDialog(labelPath.getScene().getWindow());
		if (myFile != null) {
			// Path-angaben ausgeben
			labelPath.setText(myFile.getPath());
			labelPath.setVisible(true);

			// Image anzeigen - hier bockt es noch
//			System.out.println(myFile.toURI());
//			System.out.println(myFile.toURI().toURL());
//			System.out.println(myFile.toURI().toURL().toString());
			try {
				Image myImage = new Image(myFile.toURI().toURL().toExternalForm(),500.0,650.0,false, true);
				System.out.println(myImage.heightProperty());
				imageActualDoc.setImage(myImage);
				//main.getPrimarayStage().show();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// imageActualDoc.setImage(new Image(myFile.getAbsolutePath()));
			// imageActualDoc.setVisible(true);
			// neImage =imageActualDoc.getImage();
			// labelPath.setText(" "+ neImage.getWidth());

		}
		
    }

}