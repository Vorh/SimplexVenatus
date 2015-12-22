import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public static ArrayList<Block> platforms = new ArrayList<>();
    public static ArrayList<Nps> nps = new ArrayList<>();

    ImageView imageView = new ImageView("24.png");

    Player player;

    final static int BLOCK_SIZE = 32;
    final static int PLAYER_SIZE = 32;

    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();
    public static Pane interfaceRoot = new Pane();

    int levelNumber = 0;
    private int levelWidth;

    public void update(){
        if(isPressed(KeyCode.UP)){
            player.animation.play();
            player.animation.setOffsetY(96);
            player.moveY(-2);
        }else if(isPressed((KeyCode.DOWN))){
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(2);
        }else if(isPressed(KeyCode.RIGHT)){
            player.animation.play();
            player.animation.setOffsetY(64);
            player.moveX(2);
        }else if(isPressed(KeyCode.LEFT)){
            player.animation.play();
            player.animation.setOffsetY(32);
            player.moveX(-2);
        }else {
            player.animation.stop();
        }
    }

    public void initContent(){

        levelWidth = LevelData.levels[levelNumber][0].length()*BLOCK_SIZE;
        for(int i = 0; i < LevelData.levels[levelNumber].length; i++){
            String line = LevelData.levels[levelNumber][i];
            for(int j = 0; j < line.length();j++){
                switch (line.charAt(j)){
                    case '0':
                        Block floor = new Block(Block.BlockType.ZERO, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '1':
                        Block platformFloor = new Block(Block.BlockType.ONE, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '2':
                        Block brick = new Block(Block.BlockType.TWO,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                    case '3':
                        Block bonus = new Block(Block.BlockType.THREE,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                }
            }

        }

        Interface interfaceGame = new Interface(Interface.AvatarType.ZERO);
        player = new Player(imageView,100,100);
        Nps nps = new Nps();


        player.translateXProperty().addListener((obs,old,newValue)->{
            int offset = newValue.intValue();
            if(offset>300 && offset<levelWidth-300){
                gameRoot.setLayoutX(-(offset-300));
            }
        });


        gameRoot.getChildren().addAll(player);
        appRoot.getChildren().addAll(gameRoot,interfaceRoot);



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initContent();
        Scene scene = new Scene(appRoot, 600,543);

        scene.setOnKeyPressed(event -> {
            keys.put(event.getCode(), true);
        });
        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
        });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };

        timer.start();
        primaryStage.setTitle("Tanks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public boolean isPressed(KeyCode key){
        return keys.getOrDefault(key,false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
