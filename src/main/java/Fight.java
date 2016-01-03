import javafx.geometry.Rectangle2D;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Fight extends Pane{
    Pane skillsPaneMC;
    Pane statePaneMC;
    Pane statePaneEnemy;
    Pane icon;

    ImageView iconAvatar = new ImageView("ava.png");
    ImageView iconEnemy = new ImageView("ava.png");
    ImageView iconBodyEnemy = new ImageView("ava.png");


    TextArea logFight;


    Fight(){
        statePaneMC();
        statePaneEnemy();
        skillsPaneMC();
        icon();
        logFight();

        getChildren().addAll(skillsPaneMC,statePaneMC,statePaneEnemy,icon, logFight);
        Main.fightRoot.getChildren().addAll(this);
    }

    private void statePaneMC(){
        statePaneMC = new Pane();
        statePaneMC.setTranslateX(14);
        statePaneMC.setTranslateY(134);
        statePaneMC.setPrefSize(77,255);
    }

    private void statePaneEnemy(){
        statePaneEnemy = new Pane();
        statePaneEnemy.setTranslateX(475);
        statePaneEnemy.setTranslateY(134);
        statePaneEnemy.setPrefSize(77,255);
    }

    private void skillsPaneMC(){
        skillsPaneMC = new Pane();
        skillsPaneMC.setTranslateX(341);
        skillsPaneMC.setTranslateY(415);
        skillsPaneMC.setPrefSize(472,468);
    }

    private void icon(){
        icon = new Pane();

        iconAvatar.setViewport(new Rectangle2D(0,0,96,96));
        iconAvatar.setTranslateX(14);
        iconAvatar.setTranslateY(15);

        iconEnemy.setViewport(new Rectangle2D(0, 0, 96, 96));
        iconEnemy.setTranslateX(475);
        iconEnemy.setTranslateY(15);

        iconBodyEnemy.setViewport(new Rectangle2D(0,0,96,96));
        iconBodyEnemy.setTranslateX(218);
        iconBodyEnemy.setTranslateY(134);

        icon.getChildren().addAll(iconAvatar,iconBodyEnemy, iconEnemy);
    }

    private void logFight(){
        logFight = new TextArea();
        logFight.setTranslateX(14);
        logFight.setTranslateY(415);
        logFight.setWrapText(false);
        logFight.setPrefSize(166,468);
    }
}
