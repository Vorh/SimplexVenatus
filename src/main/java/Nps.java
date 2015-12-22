import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Nps extends Pane {

    private Label iconBody;
    private ImageView imageBody = new ImageView("24.png");
    private ImageView imageAvatar = new ImageView("ava.png");
    private String name = "Клон";
    private int x = 100;
    private int y = 200;
    private Pane paneDialog;
    private TextArea textDialog;
    private Button closeText;

    public Nps(){

        createBody();
        createDialog();


        paneDialog.getChildren().addAll(textDialog,closeText,imageAvatar);
        Main.interfaceRoot.getChildren().addAll(paneDialog);
        getChildren().addAll(iconBody);
        Main.gameRoot.getChildren().add(this);

    }

    private void createBody(){
        iconBody = new Label();
        imageBody.setViewport(new Rectangle2D(0, 0, 32, 32));
        iconBody.setGraphic(imageBody);
        iconBody.setTranslateX(x);
        iconBody.setTranslateY(y);
        iconBody.setText(name);
        iconBody.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        iconBody.setTextFill(Color.RED);
        iconBody.setGraphicTextGap(2);
        iconBody.setContentDisplay(ContentDisplay.BOTTOM);

        iconBody.setOnMouseClicked(event -> {
            paneDialog.setDisable(false);
            paneDialog.setVisible(true);

        });
    }

    private void createDialog(){
        paneDialog = new Pane();
        paneDialog.setTranslateX(0);
        paneDialog.setTranslateY(440);
        paneDialog.setVisible(false);
        paneDialog.setDisable(true);


        textDialog = new TextArea();
        textDialog.setText("Меня Зовут Клон , я первый нпс созданный создателем \n" +
                "я очень убогий и кривой , но думаю в будущем стану лучше \n и мой " +
                "функционал будет более разообразный");
        textDialog.setMouseTransparent(true);
        textDialog.setEditable(false);
        textDialog.setPrefSize(400, 100);
        textDialog.setTranslateX(100);
        textDialog.setFont(Font.font("Arial",FontWeight.BOLD,12));

        closeText = new Button("X");
        closeText.setTranslateX(500);


        closeText.setOnMouseClicked(event1 -> {
            paneDialog.setVisible(false);
            paneDialog.setDisable(true);
        });

        imageAvatar.setViewport(new Rectangle2D(96, 0, 96, 96));
    }

}
