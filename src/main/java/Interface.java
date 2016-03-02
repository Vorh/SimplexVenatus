import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Interface extends Pane {

    private ImageView iconAvatar = new ImageView("avatars/ava.png");
    private static Label namePlayer;
    private static Label lvlPlayer;
    private static Label hpBar;
    private static Label mpBar;

    public enum AvatarType{
        ZERO,ONE,TWO,THREE
    }

    public Interface(AvatarType avatarType){

        setWidth(600);
        setHeight(543);

        createAvatar(avatarType);
        createName("Vorh");
        createBarLvl(2);
        createHeatPointsBar(200, 200);
        createManaPointsBar(200,200);
        Main.interfaceRoot.getChildren().addAll(this);
    }

    private void createAvatar(AvatarType avatarType){

        switch (avatarType){
            case ZERO:
                iconAvatar.setViewport(new Rectangle2D(0,0,96,96));
                break;
            case ONE:
                iconAvatar.setViewport(new Rectangle2D(96,0,96,96));
                break;
            case TWO:
                break;
            case THREE:
                break;
        }
        iconAvatar.setTranslateX(10);
        iconAvatar.setTranslateY(10);
        getChildren().addAll(iconAvatar);
    }

    private void createName(String name){
        namePlayer = new Label();
        namePlayer.setText(name);
        namePlayer.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        namePlayer.setTextFill(Color.BLACK);
        namePlayer.setTranslateX(110);
        namePlayer.setTranslateY(10);
        getChildren().addAll(namePlayer);
    }

    private void createBarLvl(int lvl){
        lvlPlayer = new Label();
        lvlPlayer.setText("LVL_" + lvl);
        lvlPlayer.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        lvlPlayer.setTextFill(Color.RED);
        lvlPlayer.setTranslateX(110);
        lvlPlayer.setTranslateY(40);
        getChildren().addAll(lvlPlayer);

    }

    private void createHeatPointsBar(int current, int max){
        hpBar = new Label();
        hpBar.setText("HP  " + current + "/" + max);
        hpBar.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        hpBar.setTextFill(Color.web("#f30935"));
        hpBar.setTranslateX(450);
        hpBar.setTranslateY(10);
        getChildren().addAll(hpBar);
    }

    private void createManaPointsBar(int current, int max){
        mpBar = new Label();
        mpBar.setText("HP  " + current + "/" + max);
        mpBar.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        mpBar.setTextFill(Color.web("#0966f3"));
        mpBar.setTranslateX(450);
        mpBar.setTranslateY(40);
        getChildren().addAll(mpBar);
    }

}
