package Menu;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Menu extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Image bag = new Image("menu.jpg");
        ImageView imageView = new ImageView(bag);
        imageView.setFitHeight(600);
        imageView.setFitWidth(900);
        pane.getChildren().add(imageView);

        MenuItem newGame = new MenuItem("НОВАЯ ИГРА");
        MenuItem options = new MenuItem("НАСТРОЙКИ");
        MenuItem exitGame = new MenuItem("ВЫХОД");

        SubMenu mainMenu = new SubMenu(newGame,options,exitGame);

        MenuItem sound = new MenuItem("ЗВУК");
        MenuItem video = new MenuItem("ВИДЕО");
        MenuItem keys = new MenuItem("УПРАВЛЕНИЕ");
        MenuItem optionBack = new MenuItem("НАЗАД");

        SubMenu optionMenu = new SubMenu(sound,video,keys,optionBack);

        MenuItem ng1 = new MenuItem("ОДИНОЧНАЯ");
        MenuItem ng2 = new MenuItem("ПО СЕТИ");
        MenuItem ng3 = new MenuItem("СТАТИСТИКА");
        MenuItem ng4 = new MenuItem("НАЗАД");

        SubMenu gameMenu = new SubMenu(ng1,ng2,ng3,ng4);



        MenuBox menuBox = new MenuBox(mainMenu);

        ng1.setOnMouseClicked(event -> {

        });

        newGame.setOnMouseClicked(event -> {menuBox.setSubMenu(gameMenu);});
        options.setOnMouseClicked(event -> {menuBox.setSubMenu(optionMenu);});
        optionBack.setOnMouseClicked(event -> {menuBox.setSubMenu(mainMenu);});
        ng4.setOnMouseClicked(event -> {menuBox.setSubMenu(mainMenu);});
        exitGame.setOnMouseClicked(event -> {System.exit(0);});

        pane.getChildren().add(menuBox);
        Scene scene = new Scene(pane, 900, 600);
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ESCAPE){
                FadeTransition ft = new FadeTransition(Duration.seconds(1), menuBox);
                if(!menuBox.isVisible()){
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                }
                else {
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(event1 -> {menuBox.setVisible(false);});
                    ft.play();

                }
            }
        });
        primaryStage.setTitle("Pause");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class MenuItem extends StackPane { // последний добавленный элемент отображается сверху
        public MenuItem(String name){
            Rectangle bg = new Rectangle(200,20, Color.WHITE);
            bg.setOpacity(0.5);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg,text);

            FillTransition ft = new FillTransition(Duration.seconds(0.5),bg);
            setOnMouseEntered(event -> {
                ft.setFromValue(Color.DARKGRAY);
                ft.setToValue(Color.DARKGOLDENROD);
                ft.setCycleCount(Animation.INDEFINITE);
                ft.setAutoReverse(true);
                ft.play();
            });

            setOnMouseExited(event -> {
                ft.stop();
                bg.setFill(Color.WHITE);
            });

        }
    }

    private static class SubMenu extends VBox {
        public SubMenu(MenuItem...menuItems){
            setSpacing(15);
            setTranslateY(100);
            setTranslateX(50);
            for (MenuItem menuItem : menuItems) {
                getChildren().add(menuItem);
            }
        }
    }

    private static class MenuBox extends Pane{
        static SubMenu sm;
        public MenuBox(SubMenu sm){
            MenuBox.sm = sm;
            setVisible(false);

            Rectangle rt = new Rectangle(900,600,Color.LIGHTGRAY);
            rt.setOpacity(0.4);
            getChildren().addAll(rt, sm);
        }

        public void setSubMenu(SubMenu sm){
            getChildren().remove(MenuBox.sm);
            MenuBox.sm = sm;
            getChildren().add(MenuBox.sm);
        }
    }

}
