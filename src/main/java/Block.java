import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Block extends Pane{

    ImageView bg0 = new ImageView("0.png");
    ImageView bg1 = new ImageView("1.png");
    ImageView bg2 = new ImageView("2.png");
    ImageView bg3 = new ImageView("3.png");
    ImageView bg4 = new ImageView("4.png");
    ImageView bg5 = new ImageView("5.png");

    public enum BlockType{
        ZERO,ONE,TWO,THREE,FOUR,FIVE
    }

    public Block(BlockType blockType, int x, int y) {

        setTranslateX(x);
        setTranslateY(y);

        switch (blockType) {
            case ZERO:
                bg0.setViewport(new Rectangle2D(0, 0, 34, 34));
                getChildren().add(bg0);
                break;
            case ONE:
                bg1.setViewport(new Rectangle2D(0, 0, 32, 32));
                getChildren().add(bg1);
                Main.platforms.add(this);
                break;
            case TWO:
                bg2.setViewport(new Rectangle2D(0, 0, 33, 33));
                getChildren().addAll(bg2);
                break;
            case THREE:
                bg3.setViewport(new Rectangle2D(0, 0, 33, 33));
                getChildren().addAll(bg3);
                break;
            case FOUR:
                bg4.setViewport(new Rectangle2D(0, 0, 33, 33));
                getChildren().addAll(bg4);
                Main.platforms.add(this);
                break;
            case FIVE:
                bg5.setViewport(new Rectangle2D(0,0,33,33));
                getChildren().addAll(bg5);
                break;
        }
        Main.gameRoot.getChildren().add(this);
    }

}
