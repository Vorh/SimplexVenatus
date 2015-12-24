import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Shot extends Pane implements Runnable{

    private ImageView imageView = new ImageView("fireball.png");
    private static Direction direction;
    private Thread fireBall = new Thread(this);  // НЕ ЗАБЫВАЙ ПРО this ДЛЯ УКАЗАНИЯ ОБЪЕКТ
    private boolean flagShot;

    public enum Direction{
        UP,DOWN,LEFT,RIGHT
    }

    public Shot(){

        getChildren().add(imageView);
        Main.gameRoot.getChildren().addAll(this);

    }

    public static void setDirection(Direction direction) {
        Shot.direction = direction;
    }

    public void shot(double x, double y) {
        setTranslateX(x);
        setTranslateY(y);
        fireBall.start();
    }


    @Override
    public void run() {
        while (true) {

                switch (direction) {
                    case UP:
                        setTranslateY(getTranslateY() - 1);
                        break;
                    case DOWN:
                        setTranslateY(getTranslateY() + 1);
                        break;
                    case LEFT:
                        setTranslateX(getTranslateX() + 1);
                        break;
                    case RIGHT:
                        setTranslateX(getTranslateX() + 1);
                        break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


}
