import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Block extends Pane{

    ImageView wall = new ImageView("wall.png");
    ImageView floor = new ImageView("floor.png");

    public enum BlockType{
        ZERO,ONE,TWO,THREE
    }

    public Block(BlockType blockType, int x, int y) {

        setTranslateX(x);
        setTranslateY(y);

        switch (blockType) {
            case ZERO:
                floor.setViewport(new Rectangle2D(0,0,32,32));
                getChildren().add(floor);
                break;
            case ONE:
                wall.setViewport(new Rectangle2D(0, 0, 32, 32));
                getChildren().add(wall);
                Main.platforms.add(this);
                break;
            case TWO:

                floor.setViewport(new Rectangle2D(47, 47, 16, 16));
                break;
            case THREE:
                floor.setViewport(new Rectangle2D(384, 0, 16, 16));
                break;
        }
        Main.gameRoot.getChildren().add(this);
    }

}
