import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Nps extends Pane {

    private Label iconBody;
    private ImageView imageBody = new ImageView("24.png");
    private ImageView imageAvatar = new ImageView("ava.png");
    private String name;
    private int x;
    private int y;
    private Text nameBody;
    private Pane paneDialog;
    private TextArea textDialog;
    private Button closeText;

    public Nps(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;

        createBody();
        createDialog();
        createName();


        paneDialog.getChildren().addAll(textDialog,closeText,imageAvatar);
        Main.interfaceRoot.getChildren().addAll(paneDialog);
        getChildren().addAll(iconBody,nameBody);
        Main.gameRoot.getChildren().add(this);

    }

    private void createBody(){
        iconBody = new Label();
        imageBody.setViewport(new Rectangle2D(0, 0, 32, 32));
        iconBody.setGraphic(imageBody);
        iconBody.setTranslateX(x);
        iconBody.setTranslateY(y);


        iconBody.setOnMouseClicked(event -> {
            paneDialog.setDisable(false);
            paneDialog.setVisible(true);
        });

        iconBody.setOnMouseExited(event -> {
            nameBody.setVisible(false);
        });
        iconBody.setOnMouseEntered(event -> {
            nameBody.setVisible(true);
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

    private void createName(){
        nameBody = new Text();
        nameBody.setText(name);
        nameBody.setVisible(false);
        nameBody.setFont(Font.font("Arial", FontWeight.LIGHT, 14));
        nameBody.setFill(Color.BLACK);
        nameBody.setTranslateX(x - 10);
        nameBody.setTranslateY(y - 5);
    }

}
