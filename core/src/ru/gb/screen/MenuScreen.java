package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture background;
    private Vector2 position;
    private Vector2 position_diff;
    private Vector2 position_stop;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        background = new Texture("space.jpg");
        position = new Vector2();
        position_diff = new Vector2(0, 0);
        position_stop = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(img, position.x, position.y);
        batch.end();
        if (position_stop.dst(position) > 1) {
            position.add(position_diff);
        } else {
            position.set(position_stop);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        background.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        position_stop.set(screenX, Gdx.graphics.getHeight() - screenY);
        position_diff.set(position_stop.cpy().sub(position));
        position_diff.nor();
        return false;
    }
}
