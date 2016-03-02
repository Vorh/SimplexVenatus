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

    ImageView imageView = new ImageView("animation/gg.png");

    Player player;
    Interface interfaceGame;

    final static int BLOCK_SIZE = 32;
    final static int PLAYER_SIZE = 32;

    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();
    public static Pane interfaceRoot = new Pane();
    public static Pane fightRoot = new Pane();


    int levelNumber = 0;
    private int levelWidth;
    static boolean flagShot = true;

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
        }else if(isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetY(32);

            player.moveX(-2);
        }else {
            player.animation.stop();
        }
    }

    public void initContent(){

        buildLVL();


        interfaceGame = new Interface(Interface.AvatarType.ZERO);
        player = new Player(imageView,100,100);
        Nps nps1 = new Nps("Враганус", 290, 411, DialogData.CLON, new ImageView("animation/23.png"), new ImageView("avatars/ava.png"));
        Nps nps2 = new Nps("Бурака", 290, 101, DialogData.CLON, new ImageView("animation/23.png"), new ImageView("avatars/ava.png"));
        Nps nps0 = new Nps("Герион",50,250, DialogData.GERION, new ImageView("animation/gg.png"), new ImageView("avatars/ava.png"));

        player.translateXProperty().addListener((obs,old,newValue)->{
            int offset = newValue.intValue();
            if(offset>455 && offset<levelWidth-455){
                gameRoot.setLayoutX(-(offset-455));
            }
        });

        gameRoot.getChildren().addAll(player);
        appRoot.getChildren().addAll(gameRoot,interfaceRoot,fightRoot);
    }

    private void buildLVL() {
        levelWidth = LevelData.levels[levelNumber][0].length()*BLOCK_SIZE;
        for(int i = 0; i < LevelData.levels[levelNumber].length; i++){
            String line = LevelData.levels[levelNumber][i];
            for(int j = 0; j < line.length();j++){
                switch (line.charAt(j)){
                    case '0':
                        Block bg0 = new Block(Block.BlockType.ZERO, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '1':
                        Block bg1 = new Block(Block.BlockType.ONE, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '2':
                        Block bg2 = new Block(Block.BlockType.TWO,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                    case '3':
                        Block bg3 = new Block(Block.BlockType.THREE,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                    case '4':
                        Block bg4 = new Block(Block.BlockType.FOUR,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                    case '5':
                        Block bg5 = new Block(Block.BlockType.FIVE,j*BLOCK_SIZE,i*BLOCK_SIZE);
                        break;
                }
            }

        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initContent();

        Scene scene = new Scene(appRoot, 900,600);

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
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public boolean isPressed(KeyCode key){
        return keys.getOrDefault(key,false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
