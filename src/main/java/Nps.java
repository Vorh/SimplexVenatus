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
    private ImageView imageBody;
    private ImageView imageAvatar;
    private String name;
    private int x;
    private int y;

    private Text nameBody;
    private Pane paneDialog;
    private TextArea textDialog;
    private int pageDialog = 0;
    private Button closeText;
    private Button takeQuest;
    private Button listenTest;
    private Button attack;
    private Button backText;

    private Fight fight;

    private String[] dialogData;

    public Nps(String name, int x, int y, String[] dialogData, ImageView imageBody, ImageView imageAvatar){
        this.name = name;
        this.x = x;
        this.y = y;
        this.dialogData = dialogData;
        this.imageBody = imageBody;
        this.imageAvatar = imageAvatar;
        this.fight = fight;
        createBody();
        createDialog();
        createName();



        paneDialog.getChildren().addAll(textDialog, imageAvatar, listenTest,takeQuest,closeText,attack,backText);
        Main.interfaceRoot.getChildren().addAll(paneDialog);

        this.getChildren().addAll(iconBody,nameBody);
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
        paneDialog.setTranslateY(433);
        paneDialog.setVisible(false);
        paneDialog.setDisable(true);

        imageAvatar.setViewport(new Rectangle2D(0, 0, 96, 96));

        textDialog = new TextArea();

        textDialog.setText(dialogData[pageDialog]);

        textDialog.setMouseTransparent(true);
        textDialog.setEditable(false);
        textDialog.setPrefSize(400, 100);
        textDialog.setTranslateX(100);
        textDialog.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        textDialog.setWrapText(true);

        listenTest = new Button("Дальше");
        listenTest.setTranslateX(565);
        listenTest.setPrefSize(65, 20);

        backText = new Button("Назад");
        backText.setTranslateX(500);
        backText.setPrefSize(65, 20);

        closeText = new Button("Прекратить диалог");
        closeText.setTranslateX(500);
        closeText.setTranslateY(25);
        closeText.setPrefSize(130, 20);

        takeQuest = new Button("Взять задание");
        takeQuest.setTranslateX(500);
        takeQuest.setTranslateY(50);
        takeQuest.setPrefSize(130, 20);

        attack = new Button("Атаковать");
        attack.setTranslateX(500);
        attack.setTranslateY(75);
        attack.setPrefSize(130, 20);


        closeText.setOnMouseClicked(event1 -> {
            paneDialog.setVisible(false);
            paneDialog.setDisable(true);
        });

        listenTest.setOnMouseClicked(event -> {
            try {
                pageDialog++;
                textDialog.setText(dialogData[pageDialog]);
            } catch (ArrayIndexOutOfBoundsException e) {
                pageDialog--;
            }
        });

        backText.setOnMouseClicked(event -> {
            try {
                pageDialog--;
                textDialog.setText(dialogData[pageDialog]);
            } catch (ArrayIndexOutOfBoundsException e) {
                pageDialog++;
            }
        });

        attack.setOnMouseClicked(event -> {
            Fight fight = new Fight();

            Main.interfaceRoot.setVisible(false);

            paneDialog.setVisible(false);
            paneDialog.setDisable(true);
        });

    }

    private void createName(){
        nameBody = new Text();
        nameBody.setText(name);
        nameBody.setVisible(false);
        nameBody.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        nameBody.setFill(Color.BLACK);
        nameBody.setTranslateX(x - 10);
        nameBody.setTranslateY(y - 5);
    }

}
