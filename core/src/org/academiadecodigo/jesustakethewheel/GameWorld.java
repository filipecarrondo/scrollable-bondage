package org.academiadecodigo.jesustakethewheel;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import org.academiadecodigo.jesustakethewheel.platform.FactoryPlat;
import org.academiadecodigo.jesustakethewheel.platform.Platform;
import org.academiadecodigo.jesustakethewheel.platform.PlatformFactory;
import org.academiadecodigo.jesustakethewheel.player.Player;
import org.academiadecodigo.jesustakethewheel.rope.Rope;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 23/11/2017.
 */
public class GameWorld {

    private Player playerOne;
    private Player playerTwo;
    private Rope rope;

    private World world;
    private LinkedList<Platform> platforms;

    public GameWorld() {

        rope = new Rope(playerOne, playerTwo);
        world = new World(new Vector2(0f, -170f), true);
        playerOne = new Player(world);
        playerTwo = new Player(world);
        platforms = new LinkedList<>();
    }

    private enum Stages {
        // Stages go here
    }


    public void update() {
        if(platforms.size() < 10){
            platforms.offer(FactoryPlat.platforms(platforms.peekLast(), platforms.size()));
            System.out.println(platforms.size() + " SIZE");
        }
        playerOne.update();
    }


    public World getWorld() {
        return world;
    }

    public Player getPlayerOne() {
        return playerOne;
    }
    public LinkedList<Platform> getPlatforms() {
        return platforms;
    }
}
